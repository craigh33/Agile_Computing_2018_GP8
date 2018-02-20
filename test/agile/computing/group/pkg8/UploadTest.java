/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
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
public class UploadTest {

    Upload upload;

    public UploadTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        upload = new Upload();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of uploadFile method, of class Upload.
     */
    @Test
    public void testUploadFile() {
        File file = new File("test.xlsx");
        File uploadPath = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
        boolean expResult = true;
        boolean result = upload.uploadFile(uploadPath, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of fileExists method, of class Upload.
     */
    @Test
    public void testFileExists() {
        File path = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
        File file = new File("test.xlsx");

        boolean expResult = true;
        boolean result = upload.fileExists(path, file);
        assertEquals(expResult, result);
    }

    /**
     * Test of fileIsSupported method, of class Upload.
     */
    @Test
    public void testFileIsSupported() {
        String filename = "test.xls";
        boolean expResult = true;
        boolean result = upload.fileIsSupported(filename);
        assertEquals(expResult, result);
    }

}
