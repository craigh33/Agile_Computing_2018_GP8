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
 * @author craig
 */
public class NodeTest {
    
    Node test;
   
    
    public NodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        test = new Node();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of returnResearcher method, of class Node.
     */
    @Test
    public void testReturnResearcher() {
        System.out.println("returnResearcher");
        String expResult = null;
        String result = test.returnResearcher();
        assertEquals("Researcher not returned",expResult, result);
    }
    
     /**
     * Test of returnDownload_URL method, of class Node.
     */
    @Test
    public void testReturnDownload_URL() {
        System.out.println("returnDownload_URL");
        String expResult = null;
        String result = test.returnDownload_URL();
        assertEquals("URL not returned",expResult, result);
    }
    
     /**
     * Test of returnComments method, of class Node.
     */
    @Test
    public void testReturnComments() {
        System.out.println("returnComments");
        String expResult = null;
        String result = test.returnResearcher();
        assertEquals("Comments not returned",expResult, result);
    }
    
     /**
     * Test of returnDay method, of class Node.
     */
    @Test
    public void testReturnDay() {
        System.out.println("returnDay");
        int expResult = 0;
        int result = test.returnDay();
        assertEquals("Day was not returned",expResult, result);
         }

    /**
     * Test of returnMonth method, of class Node.
     */
    @Test
    public void testReturnMonth() {
        System.out.println("returnMonth");
        int expResult = 0;
        int result = test.returnMonth();
        assertEquals("Month was not returned",expResult, result);
    }
}
