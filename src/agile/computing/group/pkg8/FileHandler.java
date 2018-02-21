/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author vincentnieutin
 */
public class FileHandler {

    String[] supportedFormats = {"xls", "xlsx"};

    DBConnection con = new DBConnection("sql2.freesqldatabase.com", "sql2220155", "sql2220155", "nC8!uE3*");

    String query;

    /**
     * This method uploads a file to the web server and then stores the file's
     * URL in a MySQL table
     *
     * @param uploadPath the path at which the file will be uploaded
     * @param file the file that will be uploaded
     * @param id the is of the user that is uploading the file
     * @return true if the file was successfully uploaded, false if not
     */
    public boolean uploadFile(File uploadPath, File file, int id) {
        boolean uploaded = false;
        File destination;
        String newName = id + "" + new SimpleDateFormat("ddMMyyhhmmss").format(new Date());
        String format = file.getName().split("\\.")[1];

        if (!fileExists(uploadPath, new File(newName)) && fileIsSupported(format)) {
            destination = new File(uploadPath.toString() + "\\" + newName + "." + format);
            try {
                Files.copy(file.toPath(), destination.toPath());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            query = "INSERT INTO " + con.getDatabase() + ".Project (file_name,file_path) VALUES ('" + newName + "." + format + "', '" + uploadPath.toString().replace("\\", "\\\\") + "')";

            try {
                con.getConnection().prepareStatement(query).execute();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            uploaded = true;
        }

        return uploaded;
    }

    /**
     *
     * @param path the path of the file to be downloaded
     * @return true if the file was successfully downloaded, false if not
     */
    public boolean downloadFile(File path) {
        boolean downloaded = false;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame dialogFrame = new JFrame();

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads"));
        fc.setFileFilter(new FileNameExtensionFilter("Excel file","xls","xlsx"));
        fc.setDialogTitle("Save file");

        int userSelection = fc.showSaveDialog(dialogFrame);

        switch (userSelection) {
            case JFileChooser.APPROVE_OPTION:
                File downloadPath = fc.getCurrentDirectory();
                File fileName = fc.getSelectedFile();
                File destination = new File(downloadPath.toString() + "\\" + fileName.getName() + "." + path.getName().split("\\.")[1]);
                 {
                    try {
                        Files.copy(path.toPath(), destination.toPath());
                        downloaded = true;
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                    }
                }
                break;
        }

        return downloaded;
    }

    /**
     * This method checks if a file exists at a specified path
     *
     * @param path the path where the existence of the file will be checked
     * @param file the file that will be checked if it already exists
     * @return true if the file exists, false if not
     */
    public boolean fileExists(File path, File file) {
        boolean exists = false;
        for (File f : path.listFiles()) {
            if (f.getName().equals(file.getName())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    /**
     * This method checks if the specified file is supported
     *
     * @param format the name of the file that will be checked
     * @return true if the file is supported, false if not
     */
    public boolean fileIsSupported(String format) {
        boolean supported = false;
        for (String s : supportedFormats) {
            if (s.equals(format)) {
                supported = true;
                break;
            }
        }

        return supported;
    }
}
