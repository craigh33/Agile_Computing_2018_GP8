/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author craig
 */
public class GUI {
    
    Node test = new Node();
    
    void loginScreen() {
       
       JFrame login = new JFrame();
       JButton b = new JButton("login");//Creates new Button
       b.setBounds(130,100,100,40);//Sets size of button
       
       login.add(b);//Adds button to Frame
       
       login.setSize(400,500);//size of frame
       login.setLayout(null);//no layout manager
       login.setVisible(true);//makes it visible
       
       b.setMnemonic(KeyEvent.VK_A);
      b.setTransferHandler(new TransferHandler("text"));
      b.addActionListener((ActionEvent event) -> 
        {
            login.setVisible(false);//makes it visible
            mainScreen();
        }
        );
       }
    
     /*
    * @param 
    *
    * @return 
    *
    * @authot Craig
    */
    void mainScreen(){
      JFrame main = new JFrame();
      main.setSize(400,500);//size of frame
      main.setLayout(null);//no layout manager
      main.setVisible(true);//makes it visible
      
      JButton b = new JButton("Edit");//Creates new Button
      main.add(b);
      
      b.setBounds(130,100,100,40);//Sets size of button
      b.setMnemonic(KeyEvent.VK_A);
      b.setTransferHandler(new TransferHandler("text"));
      b.addActionListener((ActionEvent event) -> 
        {
            main.setVisible(false);//makes it visible
            editScreen();
        }
        );
    }
    
    /**
     * 
     */
    void editScreen(){
        JFrame edit = new JFrame();
        edit.setSize(1500,1000);//size of frame
        edit.setLayout(new GridLayout(10,10));//no layout manager
        edit.setVisible(true);//makes it visible
        
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(2,2,10,10));
        
        JTextArea projectID;
        JTextArea projectName;
        JTextArea researcher;
        JTextArea day;
        JTextArea month;
        JTextArea year;
        JTextArea downloadURL;
        JTextArea comments;
        JCheckBox researcherSig;
        JCheckBox risSig;
        JCheckBox depDeanSig;
        JCheckBox deanSig;
        
        /*
        * Converts String variables to int for JTextAreas
        */
        String id = Integer.toString(test.returnProjectID());
        String d = Integer.toString(test.returnDay());
        String m = Integer.toString(test.returnMonth());
        String y = Integer.toString(test.returnYear());
        
        projectID = new JTextArea(id,1,1);
        projectName = new JTextArea(test.returnProjectName(),10,10);
        researcher = new JTextArea(test.returnResearcher(),10,10);
        day = new JTextArea(d,10,10);
        month = new JTextArea(m,10,10);
        year = new JTextArea(y,10,10);
        downloadURL = new JTextArea(test.returnDownload_URL(),10,10);
        comments = new JTextArea(test.returnComments(),10,10);
        researcherSig = new JCheckBox("Researcher Signature", test.returnResearcherSig());
        risSig = new JCheckBox("RIS Signature", test.returnRISSig());
        depDeanSig = new JCheckBox("Deputy Dean Signature", test.returnDepDeanSig());
        deanSig = new JCheckBox("Deans Signature", test.returnDeanSig());
        
        JButton editButton = new JButton("Edit");
        
        
        fields.add(projectName);
        fields.add(researcher);
        fields.add(day);
        fields.add(month);
        fields.add(year);
        fields.add(downloadURL);
        fields.add(comments);
        fields.add(researcherSig);
        fields.add(depDeanSig);
        fields.add(deanSig);
        
        edit.add(fields);
        edit.add(buttons);
        
         buttons.add(editButton);
      
        editButton.setBounds(130,100,100,40);//Sets size of button
        editButton.setMnemonic(KeyEvent.VK_A);
        editButton.setTransferHandler(new TransferHandler("text"));
        editButton.addActionListener((ActionEvent event) -> 
        {
            int prID = Integer.parseInt(projectID.getText());
            int dy = Integer.parseInt(day.getText());
            int mh = Integer.parseInt(month.getText());
            int yr = Integer.parseInt(year.getText());
            
            test.editProjectID(prID);
            test.editProjectName(projectName.getText());
            test.editResearcher(researcher.getText());
            test.editDay(dy);
            test.editMonth(mh);
            test.editYear(yr);
            test.editDownload_URL(downloadURL.getText());
            test.editComments(comments.getText());
            test.editResearcherSig(researcherSig.isSelected());
            test.editRISSig(risSig.isSelected());
            test.editDepDeanSig(depDeanSig.isSelected());
            test.editDeanSig(deanSig.isSelected());
            
            editScreen();
        }
        );
        
    }
}
