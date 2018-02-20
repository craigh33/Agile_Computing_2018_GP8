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
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/?user=" + username + "&password=" + password);
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
}
