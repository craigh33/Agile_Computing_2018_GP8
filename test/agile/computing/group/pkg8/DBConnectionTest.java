/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

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
    String host = "sql2.freesqldatabase.com";
    String db = "sql2220155";
    String username = "sql2220155";
    String password = "nC8!uE3*";

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

    @After
    public void tearDown() {
    }
}
