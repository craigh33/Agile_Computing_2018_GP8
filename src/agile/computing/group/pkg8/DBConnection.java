/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
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
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/"+db+"?user=" + username + "&password=" + password);
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
    
    public Hashtable getUserByStaffID(String staffID){
        /*
        returns hashtable with keys equal to database column names as result
        */
        Hashtable<String,String> result = new Hashtable();
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE StaffID = "+staffID);
            //return rs;
            while(rs.next()){
                System.out.println(rs.getString("StaffID"));
                result.put("StaffID", rs.getString("StaffID"));
                result.put("Password", rs.getString("Password"));
                result.put("FirstName", rs.getString("FirstName"));
                result.put("LastName", rs.getString("LastName"));
                result.put("email", rs.getString("email"));
                result.put("JobType", rs.getString("JobType"));
            }
        }
        catch (SQLException e){
            e.printStackTrace(System.out);
        }
        return result;
        
    }
}
