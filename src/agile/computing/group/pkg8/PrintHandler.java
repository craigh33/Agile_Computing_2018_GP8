/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.SQLError;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.filechooser.FileNameExtensionFilter;
 


/**
 *
 * @author craig
 */
public class PrintHandler {
    
    JOptionPane SQLError = new JOptionPane();
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";
 
    /**
     * This method creates a pdf file with the details of a project
     * 
     * @param savePath the path where the file while be saved
     * @param fname the name of the file to be saved
     * @throws DocumentException
     * @throws IOException 
     */
    public void createPdf(String filename, ResultSet rs)
         
	throws DocumentException, IOException {
        Image image = Image.getInstance("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\University of Dundee (logo).png");
        Image sig = Image.getInstance("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\Signatures\\default.png");
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Chunk(""));
        try{
        ListItem iD = new ListItem(Integer.toString(rs.getInt("id")));
        ListItem name = new ListItem(rs.getString("name"));
        ListItem researcher = new ListItem(rs.getString("researcher"));
        ListItem date = new ListItem(rs.getDate("date").toString());
        ListItem filePath = new ListItem(rs.getString("file_path"));
        ListItem comments = new ListItem(rs.getString("comments"));
        int researchSig = Integer.parseInt(rs.getString("signed_researcher_id"));
        int risSig = Integer.parseInt(rs.getString("signed_ris_id"));
        int assoDeanSig = Integer.parseInt(rs.getString("signed_assodean_id"));
        int deanSig = Integer.parseInt(rs.getString("signed_dean_id"));
        image.scaleAbsolute(200, 75);
        sig.scaleAbsolute(50, 25);        
        document.add(image);
        List list = new List(List.UNORDERED);
        iD.setAlignment(Element.ALIGN_JUSTIFIED);
        list.add("Project ID");
        list.add(iD);
        list.add("Project Name");
        list.add(name);
        list.add("Researcher Name");
        list.add(researcher);
        list.add("Date of Creation");
        list.add(date);
        list.add("Excel Filepath");
        list.add(filePath);
        list.add("Comments");
        list.add(comments);
        
        Paragraph title2 = new Paragraph("Project Details", 
 
        FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, 
 
        new CMYKColor(0, 255, 0, 0)));
        
        document.add(title2);
        document.add(list);
        document.add(new Paragraph(" "));
        
        if (rs.getInt("researcher_sig") > 0){
            document.add(new Paragraph("Researcher Signature"));
            sig = getSignature(researchSig);
            sig.scaleAbsolute(50, 25);
            document.add(sig);
        }
        if (rs.getInt("ris_sig") > 0){
            document.add(new Paragraph("RIS Signature"));
            sig = getSignature(risSig);
            sig.scaleAbsolute(50, 25);
            document.add(sig);
        }
        if (rs.getInt("depDean_Sig") > 0){
            document.add(new Paragraph("Associate Dean Signature"));
            sig = getSignature(assoDeanSig);
            sig.scaleAbsolute(50, 25);
            document.add(sig);
        }
        if (rs.getInt("dean_Sig") > 0){
            document.add(new Paragraph("Dean Signature"));
            sig = getSignature(deanSig);
            sig.scaleAbsolute(50, 25);
            document.add(sig);
        }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
        }
        document.close();
    }
    
    /**
     * 
     * @param id
     * @throws SQLException 
     */
    void getNewResultSet(String id) throws SQLException{

        //open new connection
        
        DBConnection connection2 = new DBConnection(host, db, username, password);
        
        System.out.println(id);
        ResultSet rs;
        rs = connection2.getProject(id);
        rs.next();
        

        exportPDFLogic(rs);
    }
    
    /**
     * Used to get signature image
     * 
     * @param id
     * @throws SQLException 
     */
    private Image getSignature(int id) throws SQLException, BadElementException, IOException{

        //open new connection
        
        DBConnection connection2 = new DBConnection(host, db, username, password);
        
        System.out.println(id);
        ResultSet staffmember;
        staffmember = connection2.getUserByStaffID(id);
        staffmember.next();
        String temp = "\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\Signatures\\" + staffmember.getString("sig_name");
        Image temp1 = Image.getInstance(temp);
        return temp1;
    }

    /**
     * 
     * @param rs 
     */
    void exportPDFLogic(ResultSet rs){
        
        JFrame dialogFrame = new JFrame();

            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Documents"));
            fc.setFileFilter(new FileNameExtensionFilter("PDF Document", "pdf"));
            fc.setSelectedFile(new File("Project.pdf"));
            fc.setDialogTitle("Save file");

            int userSelection = fc.showSaveDialog(dialogFrame);

            switch (userSelection) {
                case JFileChooser.APPROVE_OPTION:
                    String downloadPath = fc.getCurrentDirectory().toString();
                    System.out.println(downloadPath);
                    String fileName = fc.getSelectedFile().getName();   
                    System.out.println(fileName);
                
                String savePath = (downloadPath + '/' + fileName);
            
                {
                    try {
                        createPdf(savePath,rs);
                    } catch (DocumentException ex) {
                        JOptionPane.showMessageDialog(SQLError, "PDF Writer Error", "PDF Writer Error", ERROR_MESSAGE);
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(SQLError, "PDF Writer Error", "PDF Writer Error", ERROR_MESSAGE);
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        
        
    }
}
