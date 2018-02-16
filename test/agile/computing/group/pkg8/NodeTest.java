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
     * Test of returnProjectName method, of class Node.
     */
    @Test
    public void testReturnProjectName() {
        System.out.println("returnRProjectName");
        String expResult = null;
        String result = test.returnProjectName();
        assertEquals("Project Name not returned",expResult, result);
    }
    
    /**
     * Test of returnProjectID method, of class Node.
     */
    @Test
    public void testProjectID() {
        System.out.println("returnProjectID");
        int expResult = 0;
        int result = test.returnProjectID();
        assertEquals("Project ID not returned",expResult, result);
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
    
    /**
     * Test of returnYear method, of class Node.
     */
    @Test
    public void testReturnYear() {
        System.out.println("returnYear");
        int expResult = 0;
        int result = test.returnYear();
        assertEquals("Year was not returned",expResult, result);
    }
    
    /*
    * Test of returnResearcherSig method
    */
    @Test
    public void testReturnResearcherSig() {
        System.out.println("returnResearcherSig");
        boolean result = test.returnResearcherSig();
        assertFalse("Researcher Signature was not returned",result);
    }
    
     /*
    * Test of returnRISSig method
    */
    @Test
    public void testReturnRISSig() {
        System.out.println("returnRISSIg");
        boolean result = test.returnRISSig();
        assertFalse("RIS Signature was not returned",result);
    }
    
     /*
    * Test of returnRISSig method
    */
    @Test
    public void testDepDeanSig() {
        System.out.println("returnDepDeanSig");
        boolean result = test.returnDepDeanSig();
        assertFalse("DepDean Signature was not returned",result);
    }
    
     /*
    * Test of returnRISSig method
    */
    @Test
    public void testReturnDeanSig() {
        System.out.println("returnDeanSIg");
        boolean result = test.returnDeanSig();
        assertFalse("Dean Signature was not returned",result);
    }
    
    /**
     * Test of editProjectName method, of class Node.
     */
    @Test
    public void testEditProjectName() {
        System.out.println("editProjectName");
        String expResult = "";
        String result = test.editProjectName(expResult);
        assertEquals("Project Name not edited",expResult, result);
    }
    
    /**
     * Test of editProjectID method, of class Node.
     */
    @Test
    public void testEditProjectID() {
        System.out.println("editProjectID");
        int expResult = 1;
        int result = test.editProjectID(expResult);
        assertEquals("Project ID not edited",expResult, result);
    }
    
    /**
     * Test of editResearcher method, of class Node.
     */
    @Test
    public void testEditResearcher() {
        System.out.println("editResearcher");
        String expResult = "";
        String result = test.editResearcher(expResult);
        assertEquals("Researcher not edited",expResult, result);
    }
    
    /**
     * Test of editDownload_URL method, of class Node.
     */
    @Test
    public void testEditDownload_URL() {
        System.out.println("editDownload_URL");
        String expResult = "";
        String result = test.editDownload_URL(expResult);
        assertEquals("Download URL not edited",expResult, result);
    }
    
    /**
     * Test of editComments method, of class Node.
     */
    @Test
    public void testEditComments() {
        System.out.println("editComments");
        String expResult = "";
        String result = test.editComments(expResult);
        assertEquals("Comments not Edited",expResult, result);
    }
    
    /**
     * Test of editDay method, of class Node.
     */
    @Test
    public void testEditDay() {
        System.out.println("editDay");
        int expResult = 1;
        int result = test.editDay(expResult);
        assertEquals("Day not Edited",expResult, result);
    }
    
    /**
     * Test of editMonth method, of class Node.
     */
    @Test
    public void testEditMonth() {
        System.out.println("editMonth");
        int expResult = 1;
        int result = test.editMonth(expResult);
        assertEquals("Month not Edited",expResult, result);
    }
    
    /**
     * Test of editYear method, of class Node.
     */
    @Test
    public void testEditYear() {
        System.out.println("editYear");
        int expResult = 1;
        int result = test.editYear(expResult);
        assertEquals("Month not Edited",expResult, result);
    }
    
    /*
    * Test of editResearcherSig method
    */
    @Test
    public void testEditResearcherSig() {
        System.out.println("editResearcherSig");
        boolean result = test.editResearcherSig(true);
        assertTrue("Researcher Signature was not edited",result);
    }
    
    /*
    * Test of editRISSig method
    */
    @Test
    public void testEditRISSig() {
        System.out.println("editRISSig");
        boolean result = test.editRISSig(true);
        assertTrue("RIS Signature was not edited",result);
    }
    
    /*
    * Test of editDepDeanSig method
    */
    @Test
    public void testEditDepDeanRISSig() {
        System.out.println("editDepDeanSig");
        boolean result = test.editDepDeanSig(true);
        assertTrue("DepDean Signature was not edited",result);
    }
    
    /*
    * Test of editDepDeanSig method
    */
    @Test
    public void testEditDeanRISSig() {
        System.out.println("editDeanSig");
        boolean result = test.editDeanSig(true);
        assertTrue("Dean Signature was not edited",result);
    }
    
    
}
