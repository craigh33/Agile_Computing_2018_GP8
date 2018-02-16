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
     * Test of Node method, of class Node.
     */
    @Test
    public void testNode() {
        System.out.println("Node");
        test.Node();
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnResearcher method, of class Node.
     */
    @Test
    public void testReturnResearcher() {
        System.out.println("returnResearcher");
        String expResult = "";
        String result = test.returnResearcher();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnDownload_URL method, of class Node.
     */
    @Test
    public void testReturnDownload_URL() {
        System.out.println("returnDownload_URL");
        String expResult = "";
        String result = test.returnDownload_URL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
