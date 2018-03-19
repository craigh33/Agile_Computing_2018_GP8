/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void testNewProject() {
        connection.newProject(700, "TESTPROJECT", "TESTRESEARCHER", "TESTCOMMENT", "TEST.TEST", "C:\\TEST");
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE name='TESTPROJECT'");
            rs.next();
            assertNotNull(rs.getString("name"));
            stmt.executeUpdate("DELETE FROM project WHERE name='TESTPROJECT'");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testEditProject() {
        connection.editProject("700", "TESTPROJECT", "NEWTESTCOMMENT", true, false, false, false);
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE comment='NEWTESTCOMMENT");
            assertNotNull(rs.getString("comment"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testDeleteProject() {
        
    }
    
    @Test
    public void testGetProjets() {
        ResultSet rs = connection.getProjects();
        try {
            assertNotNull(rs.getArray(0));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testGetProjectByID() {
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE id=1");
            ResultSet rs2 = connection.getProject("1");
            assertEquals(rs.getInt("id"), rs2.getInt("id"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testGetUserByStaffID() {
        ResultSet x = connection.getUserByStaffID(1);
        try {
        x.next();
        assertEquals("admin", x.getString("Password"));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testAddUser() {
        connection.addUser(700, "thing", "James", "Bond", "007@mi6.com", "Researcher");
        ResultSet x = connection.getUserByStaffID(700);
        try {
            x.next();
            assertEquals("Bond", x.getString("Lastname"));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testRemoveUser() {
        connection.removeUserById(700);
        ResultSet x = connection.getUserByStaffID(700);
        try {
            assertNull(x.getInt("staffid"));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @After
    public void tearDown() {
    }
}
