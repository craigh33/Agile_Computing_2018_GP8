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
    String[] supportedImages = {"JPEG", "jpg", "png"};

    DBConnection con = new DBConnection("silva.computing.dundee.ac.uk", "17agileteam8db", "17agileteam8", "7632.at8.2367");

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

            query = "UPDATE " + con.getDatabase() + ".Project SET file_name = '" + newName + "." + format + "' , file_path = '" + uploadPath.toString().replace("\\", "\\\\") + "\\\\" + newName + "." + format + "' WHERE id = " + id ;
            System.out.println(query);
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
     * This method uploads a file to the web server and then stores the file's
     * URL in a MySQL table
     *
     * @param uploadPath the path at which the file will be uploaded
     * @param file the file that will be uploaded
     * @param id the is of the user that is uploading the file
     * @return true if the file was successfully uploaded, false if not
     */
    public boolean uploadSignature(File uploadPath, File file, int id) {
        boolean uploaded = false;
        File destination;
        String newName = id + "" + new SimpleDateFormat("ddMMyyhhmmss").format(new Date()) + "" + "signature";
        String format = file.getName().split("\\.")[1];

        if (!fileExists(uploadPath, new File(newName)) && imageIsSupported(format)) {
            
            
            destination = new File(uploadPath.toString() + "\\" + newName + "." + format);
            try {
                Files.copy(file.toPath(), destination.toPath());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            query = "UPDATE " + con.getDatabase() + ".Staff SET sig_name = '" + newName + "." + format + "' , sig_path = '" + uploadPath.toString().replace("\\", "\\\\") + "\\\\" + newName + "." + format + "' WHERE id = " + id ;
            System.out.println(query);
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
     * This method downloads a file at the specified path and prompts the user
     * where to save this file
     *
     * @param path the path of the file to be downloaded
     * @return true if the file was successfully downloaded, false if not
     */
    public boolean downloadFile(File path) {
        boolean downloaded = false;

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (InstantiationException e) {
            e.printStackTrace(System.out);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.out);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.out);
        }

        JFrame dialogFrame = new JFrame();

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads"));
        fc.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
        fc.setSelectedFile(new File("finances.xlsx"));
        fc.setDialogTitle("Save file");

        int userSelection = fc.showSaveDialog(dialogFrame);

        switch (userSelection) {
            case JFileChooser.APPROVE_OPTION:
                File downloadPath = fc.getCurrentDirectory();
                String fileName = fc.getSelectedFile().getName();

                if (fileName.contains(".")) {
                    fileName = fileName.split("\\.")[0];
                }

                File destination = new File(downloadPath.toString() + "\\" + fileName + "." + path.getName().split("\\.")[1]);
                 {
                    try {
                        Files.copy(path.toPath(), destination.toPath());
                        downloaded = true;
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        JOptionPane.showMessageDialog(null, "There was a problem with your acion. Download cancelled.", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    /**
     * This method checks if the specified file is supported
     *
     * @param format the name of the file that will be checked
     * @return true if the file is supported, false if not
     */
    public boolean imageIsSupported(String format) {
        boolean supported = false;
        for (String s : supportedImages) {
            if (s.equals(format)) {
                supported = true;
                break;
            }
        }

        return supported;
    }
    
    /**
     * This method creates a dialog for image selection
     * 
     * @return The image selected
     */
    File imageSelect(){
        JFrame dialogFrame = new JFrame();

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("jpg", "png", "JPEG"));
            fc.setDialogTitle("Choose file");

            int userSelection = fc.showSaveDialog(dialogFrame);
            File file = null;
            switch (userSelection) {
                case JFileChooser.APPROVE_OPTION:
                    //File file = new File(fc.getSelectedFile().getName());
                    file = new File(fc.getSelectedFile().toString());
                    break;
            }
            return file;
    }
    
    /**
     * This method creates a dialog for excel file selection
     * 
     * @return The file selected
     */
    File uploadSelect(){
        JFrame dialogFrame = new JFrame();

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
            fc.setDialogTitle("Choose file");

            int userSelection = fc.showSaveDialog(dialogFrame);
            File file = null;
            switch (userSelection) {
                case JFileChooser.APPROVE_OPTION:
                    //File file = new File(fc.getSelectedFile().getName());
                    file = new File(fc.getSelectedFile().toString());
                    break;
            }
            return file;
    }
}
