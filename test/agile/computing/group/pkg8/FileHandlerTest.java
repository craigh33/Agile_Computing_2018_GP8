/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
public class FileHandlerTest {

    FileHandler fh;

    public FileHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fh = new FileHandler();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of uploadFile method, of class FileHandler.
     */
    @Test
    public void testUploadFile() {
        File file = new File("test.xlsx");
        File uploadPath = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
        boolean expResult = true;
        boolean result = fh.uploadFile(uploadPath, file,1);
        assertEquals(expResult, result);
    }

    /**
     * Test of fileExists method, of class FileHandler.
     */
    @Test
    public void testFileExists() {
        File path = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
        File file = new File("test.xlsx");

        boolean expResult = true;
        boolean result = fh.fileExists(path, file);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of fileIsSupported method, of class FileHandler.
     */
    @Test
    public void testFileIsSupported() {
        String format = "xls";
        boolean expResult = true;
        boolean result = fh.fileIsSupported(format);
        assertEquals(expResult, result);
    }

    /**
     * Test of downloadFile method, of class FileHandler.
     */
    @Test
    public void testDownloadFile() throws IOException {
        File path = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files\\test.xlsx");
        boolean expResult = true;
        boolean result = fh.downloadFile(path);
        assertEquals("File failed to download",expResult, result);
    }

}
