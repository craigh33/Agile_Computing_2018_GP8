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
public class MysqlConnection {

    Connection con;
    String url, username, password;
    boolean connected;
    
    /**
     * 
     * @param host The host of the database
     * @param db The name of the database
     * @param username The username used to connect to the database
     * @param password The password associated with the username
     * @return a boolean the tells if the connection was successful or not
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public boolean open(String host, String db, String username, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connected = false;

        url = "jdbc:mysql://" + host + "/" + db;
        this.username = username;
        this.password = password;
        con = DriverManager.getConnection(url, username, password);
        Statement testStatement = con.createStatement();
        if (testStatement.execute("SELECT 1")) {
            connected = true;
        }
        return connected;
    }
    
    public boolean close() throws SQLException{
        if(connected){
            con.close();
            connected = false;
        }
        
        return connected;
    }
}
