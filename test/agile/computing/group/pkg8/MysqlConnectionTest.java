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
public class MysqlConnectionTest {

    MysqlConnection connection;

    public MysqlConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        connection = new MysqlConnection();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of connect method, of class Connexion.
     */
    @Test
    public void testConnect() throws Exception {        
        String host = "sql2.freesqldatabase.com";
        String db = "sql2220155";
        String username = "sql2220155";
        String password = "nC8!uE3*";
        connection.connect(host, db, username, password);
        boolean expResult = true;
        boolean result = connection.connect(host, db, username, password);
        assertEquals("Connexion failed", expResult, result);
    }

}
