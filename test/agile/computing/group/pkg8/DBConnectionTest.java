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
        connection.newProject(700, "TESTPROJECT", "TESTRESEARCHER", "TESTCOMMENT", "TEST.TESTDOC", "C:\\TEST");
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE name='TESTPROJECT'");
            rs.next();
            String projectID = rs.getString("id");
            connection.editProject(projectID, "NEWTESTPROJECT", "NEWTESTCOMMENT", true, true, true, true, "TEST ID", "TEST ID", "TEST ID", "TEST ID");
            rs = stmt.executeQuery("SELECT * FROM project WHERE name='NEWTESTPROJECT'");
            rs.next();
            assertEquals("NEWTESTPROJECT", rs.getString("name"));
            //delete test project after use
            stmt.executeUpdate("DELETE FROM project WHERE id="+projectID);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testRemoveProjectByID() {
        connection.newProject(700, "TESTPROJECT", "TESTRESEARCHER", "TESTCOMMENT", "TEST.TEST", "C:\\TEST");
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            // get project id
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE name='TESTPROJECT'");
            rs.next();
            int id = rs.getInt("id");
            connection.removeProjectById(id);
            rs = stmt.executeQuery("SELECT * FROM project WHERE id=" + id);
            assertFalse(rs.next());
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testREVISIONeditProject() {
        connection.newProject(700, "TESTPROJECT", "TESTRESEARCHER", "TESTCOMMENT", "TEST.TESTDOC", "C:\\TEST");
        Connection con = connection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM project WHERE name='TESTPROJECT'");
            rs.next();
            String projectID = rs.getString("id");
            connection.REVISIONeditProject(projectID, 999, "1", true, "1");
            rs = stmt.executeQuery("SELECT * FROM project WHERE revision=999");
            rs.next();
            assertEquals("TESTPROJECT", rs.getString("name"));
            //delete test project after use
            stmt.executeUpdate("DELETE FROM project WHERE id="+projectID);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testGetStaff() {
        ResultSet rs = connection.getStaff();
        try {
            assertNotNull(rs.getArray(0));
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
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
    public void testGetProject() {
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
        connection.addUser(700, "thing", "James", "Bond", "007@mi6.gov.uk", "Researcher");
        Connection con = connection.getConnection();
        ResultSet x = connection.getUserByStaffID(700);
        try {
            Statement stmt = con.createStatement();
            x.next();
            assertEquals("Bond", x.getString("Lastname"));
            stmt.executeUpdate("DELETE FROM staff WHERE staffid=700");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Test
    public void testRemoveUserByID() {
        connection.addUser(700, "thing", "james", "bond", "007@mi6.gov.uk", "Researcher");
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
        connection.closeConnection();
    }
}
