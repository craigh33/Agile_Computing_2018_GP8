/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vincentnieutin
 */
public class Upload {

    String[] supportedFormats = {"xls", "xlsx"};

    DBConnection con = new DBConnection("sql2.freesqldatabase.com", "sql2220155", "sql2220155", "nC8!uE3*");

    String query;

    /**
     * This method uploads a file to the web server and then store the file's
     * URL in a MySQL table
     *
     * @param uploadPath the path at which the file will be uploaded
     * @param file the file that will be uploaded
     * @return true if the file was successfully uploaded, false if not
     */
    public boolean uploadFile(File uploadPath, File file) {
        boolean uploaded = false;
        File destination;

        if (!fileExists(uploadPath, file) && fileIsSupported(file.getName())) {
            destination = new File(uploadPath.toString() + "\\" + file.getName());
            try {
                //destination.createNewFile();
                Files.copy(file.toPath(), destination.toPath());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            query = "INSERT INTO " + con.getDatabase() + ".Project (file_name,file_path) VALUES ('" + file.getName() + "', '" + uploadPath.toString().replace("\\", "\\\\") + "')";

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
     * @param filename the name of the file that will be checked
     * @return true if the file is supported, false if not
     */
    public boolean fileIsSupported(String filename) {
        boolean supported = false;
        String format = filename.split("\\.")[1];
        for (String s : supportedFormats) {
            if (s.equals(format)) {
                supported = true;
                break;
            }
        }

        return supported;
    }
}
