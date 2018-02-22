/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author vincentnieutin
 */
public class DBConnection {

    Connection con;
    String host, db, username, password;
    Statement stmt;

    public DBConnection(String host, String db, String username, String password) {
        this.host = host;
        this.db = db;
        this.username = username;
        this.password = password;
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db + "?user=" + username + "&password=" + password);
        } catch (SQLException e) {
            // change to GUI output stream as required
            e.printStackTrace(System.out);
        }
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public String getDatabase() {
        return this.db;
    }

    public Hashtable getUserByStaffID(String staffID) {
        /*
        returns hashtable with keys equal to database column names as result
         */
        Hashtable<String, String> result = new Hashtable();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE StaffID = " + staffID);
            //return rs;
            while (rs.next()) {
                System.out.println(rs.getString("StaffID"));
                result.put("StaffID", rs.getString("StaffID"));
                result.put("Password", rs.getString("Password"));
                result.put("FirstName", rs.getString("FirstName"));
                result.put("LastName", rs.getString("LastName"));
                result.put("email", rs.getString("email"));
                result.put("JobType", rs.getString("JobType"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return result;

    }

    public ResultSet getProjects() {
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM 17agileteam8db.project");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return rs;
    }

    public void newProject(int id, String projectName, String researcher, String comments, String fileName, String filePath) {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try {
            File destination;
            String newName = id + "" + new SimpleDateFormat("ddMMyyhhmmss").format(new Date());
            String format = fileName.split("\\.")[1];

            destination = new File(filePath + "\\" + newName + "." + format);

            stmt = con.createStatement();
            stmt.execute("INSERT INTO project (name, researcher, comments ,date, file_name,file_path) VALUES ('" + projectName + "','" + researcher + "','" + comments + "','" + date + "','" + newName + "." + format + "', '" + filePath.replace("\\", "\\\\") + "\\\\" + newName + "." + format + "')");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}
