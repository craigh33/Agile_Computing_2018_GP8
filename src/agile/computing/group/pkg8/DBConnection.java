/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author vincentnieutin
 */
public class DBConnection {

    JOptionPane SQLError = new JOptionPane();
    Connection con;
    String host, db, username, password;
    Statement stmt;

    //set up for database connection
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
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
        }
    }

    //connects to the database
    public Connection getConnection() {
        return this.con;
    }

    //closes the connection to the database
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }

    
    public String getDatabase() {
        return this.db;
    }

    /*
        refactored code from hashtable to resultset
        looks up staff by staffID
    */
    public ResultSet getUserByStaffID(int staffID) {
       
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Staff WHERE StaffID = " + staffID);
            //return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
        return rs;

    }
    
    //adds a new user to the database
    public void addUser(int staffID, String password, String firstName, String lastName, String email, String jobType) {
        try {
            //SQL statement for the insertion of a user
            String sqlStatement = "INSERT INTO Staff VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sqlStatement);
            //sets the values to the corresponding columns in the database
            pstmt.setInt(1, staffID);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, email);
            pstmt.setString(6, jobType);
            pstmt.executeUpdate();
            //closes the connection
            pstmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    //Deletes a user from the database by staffID
    public void removeUserById(int staffID) {
        try {
            //sets up a connection object with the createStatement method from sql library
            stmt = con.createStatement();
            //executes delete query and removes staff member from the database
            stmt.execute("DELETE FROM Staff WHERE StaffID=" + staffID);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }

    //gets all the projects from the database
    public ResultSet getProjects() {
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM 17agileteam8db.project");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }

        return rs;
    }

    public void newProject(int Staffid, String projectName, String researcher, String comments, String fileName, String filePath) {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try {
            File destination;
            String newName = Staffid + "" + new SimpleDateFormat("ddMMyyhhmmss").format(new Date());
            String format = fileName.split("\\.")[1];

            //destination/file path of the new file 
            destination = new File(filePath + "\\" + newName + "." + format);

            //inserts the new file into the project table in the database
            stmt = con.createStatement();
            stmt.execute("INSERT INTO project (name, researcher, comments ,date, file_name,file_path) VALUES ('" + projectName + "','" + researcher + "','" + comments + "','" + date + "','" + newName + "." + format + "', '" + filePath.replace("\\", "\\\\") + "\\\\" + newName + "." + format + "')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    //gets a project in the database by projectID
    public ResultSet getProject(String  id){
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM project WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
        return rs;
    }
    
    //Updates values within the database if changes to projects have been made e.g if RIS has signed the document
    public void editProject(String id, String name, String comments, boolean researcher_sig, boolean ris_sig, boolean depDean_sig, boolean dean_sig){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET name = '" + name + "', comments = '" + comments + "', researcher_sig = " + researcher_sig + ", ris_sig = " + ris_sig + ", depDean_sig = " + depDean_sig + ", dean_sig = " + dean_sig + " WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
   
    public void REVISIONeditProject(String id, int revision, String ris_seen, boolean needs_reviewed, String researcher_needs2_review){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET revision = '" + revision + "', ris_seen = " + ris_seen + ", needs_reviewed = " + needs_reviewed + ", researcher_needs2_review = " + researcher_needs2_review + "  WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    public ResultSet getStaff() {
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM 17agileteam8db.Staff");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }

        return rs;
    }
    
    public void removeProjectById(int id) {
        try {
            //sets up a connection object with the createStatement method from sql library
            stmt = con.createStatement();
            //executes delete query and removes staff member from the database
            stmt.execute("DELETE FROM project WHERE id =" + id);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
}
