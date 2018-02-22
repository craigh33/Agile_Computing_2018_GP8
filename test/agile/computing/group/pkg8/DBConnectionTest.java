/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vincentnieutin
 */
public class DBConnectionTest {

    DBConnection connection;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";

    public DBConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        connection = new DBConnection(host, db, username, password);
    }
    
    @Test
    public void testGetUserByStaffID() {
        ResultSet x = connection.getUserByStaffID(1);
        try {
        assertEquals("admin", x.getString("Password"));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @After
    public void tearDown() {
    }
}
