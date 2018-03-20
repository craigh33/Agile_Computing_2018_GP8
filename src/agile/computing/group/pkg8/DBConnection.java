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
 * Constructor
 * 
 * @author vincentnieutin
 */
public class DBConnection {

    JOptionPane SQLError = new JOptionPane();
    Connection con;
    String host, db, username, password;
    Statement stmt;

    /**
     * Creates DB Connection
     * 
     * @param host
     * @param db
     * @param username
     * @param password 
     */
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

    /**
     * Gets Connection
     * 
     * @return con
     */
    public Connection getConnection() {
        return this.con;
    }

    /**
     * Closes Connection
     */
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }

    /**
     * Returns Database
     * 
     * @return db
     */
    public String getDatabase() {
        return this.db;
    }

    /**
     * Searches for user bY ID
     * 
     * @param staffID
     * @return ResultSet containing staff members details
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
    
    /**
     * Searcher Users by email
     * 
     * @param email
     * @return ResultSet of User
     */
    public ResultSet getUserByStaffEmail(String email) {
       
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Staff WHERE email = '" + email + "'");
            //return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
        return rs;

    }
    
    //adds a new user to the database
   /* public void addUser(int staffID, String password, String firstName, String lastName, String email, String jobType) {
        try {
            //SQL statement for the insertion of a user
            String sqlStatement = "INSERT INTO Staff VALUES (?,?,?,?,?,?,?,?);";
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
    }*/
    
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

    /**
     * Used to return all resultsets
     * 
     * @return ResultSet of Projects
     */
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

    /**
     * Creates new project on database
     * 
     * @param Staffid
     * @param projectName
     * @param researcher
     * @param comments
     * @param fileName
     * @param filePath 
     */
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
    
    /**
     * Searches for project by id
     * 
     * @param id
     * @return ResultSet containing project
     */
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
    
    /**
     * Method for editing existing project
     * Searches by ID
     * 
     * @param id
     * @param name
     * @param comments
     * @param researcher_sig
     * @param ris_sig
     * @param depDean_sig
     * @param dean_sig
     * @param signed_researcher_id
     * @param signed_ris_id
     * @param signed_assodean_id
     * @param signed_dean_id 
     */
    public void editProject(String id, String name, String comments, boolean researcher_sig, boolean ris_sig, boolean depDean_sig, boolean dean_sig, String signed_researcher_id, String signed_ris_id, String signed_assodean_id, String signed_dean_id){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET name = '" + name + "', comments = '" + comments + "', rearcher_sig =se " + researcher_sig + ", ris_sig = " + ris_sig + ", depDean_sig = " + depDean_sig + ", dean_sig = " + dean_sig + ", signed_researcher_id = " + signed_researcher_id + ", signed_ris_id = " + signed_ris_id + ", signed_assodean_id = " + signed_assodean_id + ", signed_dean_id = " + signed_dean_id + " WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
   
    /**
     * Only Updates Revision Types for notifications
     * 
     * @param id
     * @param revision
     * @param ris_seen
     * @param needs_reviewed
     * @param researcher_needs2_review 
     */
    public void REVISIONeditProject(String id, int revision, String ris_seen, boolean needs_reviewed, String researcher_needs2_review){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET revision = '" + revision + "', ris_seen = " + ris_seen + ", needs_reviewed = " + needs_reviewed + ", researcher_needs2_review = " + researcher_needs2_review + "  WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Used for notifications
     * 
     * @param id
     * @param assoDean_seen 
     */
    public void editAssoDean_Seen(String id, String assoDean_seen){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET assoDean_seen = '" + assoDean_seen +"'  WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Used for Notifications
     * 
     * @param id
     * @param dean_seen 
     */
    public void editDean_Seen(String id, String dean_seen){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE project SET dean_seen = '" + dean_seen +"'  WHERE id = " + id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Used to get entire staff table
     * 
     * @return ResultSet of all staff
     */
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
    
    /**
     * Used to remove project
     * 
     * @param id 
     */
    public void removeProjectById(int id) {
        try {
            //sets up a connection object with the createStatement method from sql library
            stmt = con.createStatement();
            //executes delete query and removes project from the database
            stmt.execute("DELETE FROM project WHERE id =" + id);
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Used to add staff member
     * 
     * @param StaffID
     * @param Password
     * @param FirstName
     * @param LastName
     * @param email
     * @param jobType 
     */
    public void addStaff(int StaffID, String Password, String FirstName, String LastName, String email, String jobType) {
       try{
        stmt = con.createStatement();
        stmt.execute("INSERT INTO Staff (StaffID, Password, FirstName, LastName, email, JobType) VALUES ('" + StaffID + "','" + Password + "','" + FirstName + "','" + LastName + "','" + email + "','" + jobType + "')" );
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
    
        public void editStaff(int StaffID, String Password, String FirstName, String LastName, String email, String jobType, String sig_path, String sig_name){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE staff SET Password = '" + Password + "', FirstName = '" + FirstName + "', LastName " + LastName + ", email = " + email + ", JobType = " + jobType + ", sig_path = " + sig_path + ", sig_name = " + sig_name + " WHERE StaffID = " + StaffID);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
    }
      public void updateStaffDetails(int StaffID, String Password, String email){
        try {
            stmt = con.createStatement();
            stmt.execute("UPDATE staff SET Password = '" + Password +  "', email = " + email + " WHERE StaffID = " + StaffID);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(SQLError, "No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            e.printStackTrace(System.out);
        }
      }
    
}
