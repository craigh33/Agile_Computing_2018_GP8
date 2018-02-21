/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
        String newName = id + "" + new SimpleDateFormat("ddmmyyhhmmss").format(new Date());
        String format = file.getName().split("\\.")[1];

        if (!fileExists(uploadPath, new File(newName)) && fileIsSupported(format)) {
            destination = new File(uploadPath.toString() + "\\" + newName + "." + format);
            try {
                Files.copy(file.toPath(), destination.toPath());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            query = "INSERT INTO " + con.getDatabase() + ".Project (file_name,file_path) VALUES ('" +  newName + "." + format + "', '" + uploadPath.toString().replace("\\", "\\\\") + "')";

            try {
                con.getConnection().prepareStatement(query).execute();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            uploaded = true;
        }

        return uploaded;
    }

    public boolean downloadFile(File path, File file) throws MalformedURLException, IOException {
        boolean downloaded = false;

        URL url = new URL(path.toString());
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("test.xlsx");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

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
     * @param filename the name of the file that will be checked
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
