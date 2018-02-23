/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
 


/**
 *
 * @author craig
 */
public class PrintHandler {
 
    /**
     * This method creates a pdf file with the details of a project
     * 
     * @param savePath the path where the file while be saved
     * @param fname the name of the file to be saved
     * @throws DocumentException
     * @throws IOException 
     */
    public void createPdf(String savePath, String fname)
        
	throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(savePath));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        // step 5
        document.close();
    }
}
