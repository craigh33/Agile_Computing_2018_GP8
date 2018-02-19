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
    
    Node test = new Node(); // used for manipulating variables see craig for info
    
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
            login.dispose();
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
      main.setLayout(new GridLayout(10,10));//no layout manager
      main.setVisible(true);//makes it visible
      
      JButton newP = new JButton("New Project");//Creates new Button
      main.add(newP);
      
      newP.setBounds(130,100,100,40);//Sets size of button
      newP.setMnemonic(KeyEvent.VK_A);
      newP.setTransferHandler(new TransferHandler("text"));
      newP.addActionListener((ActionEvent event) -> 
        {
            main.dispose();
            newProject();
        }
        );
      
      JButton edit = new JButton("Edit");//Creates new Button
      main.add(edit);
      
      edit.setBounds(130,100,100,40);//Sets size of button
      edit.setMnemonic(KeyEvent.VK_A);
      edit.setTransferHandler(new TransferHandler("text"));
      edit.addActionListener((ActionEvent event) -> 
        {
            main.dispose();
            editScreen();
        }
        );
      
      JButton exit = new JButton("Logout");//Creates new Button
      main.add(exit);
      
      exit.setBounds(130,100,100,40);//Sets size of button
      exit.setMnemonic(KeyEvent.VK_A);
      exit.setTransferHandler(new TransferHandler("text"));
      exit.addActionListener((ActionEvent event) -> 
        {
            main.dispose();
            loginScreen();
        }
        );
      
      
    }
    
    /**
     * Swing Screen to allow user to edit fields
     */
    void editScreen(){
        JFrame edit = new JFrame();
        edit.setSize(1500,1000);//size of frame
        edit.setLayout(new GridLayout(10,10));//change this to change edit screen layout
        edit.setVisible(true);//makes it visible
        
        /*
        *JPanels to strore java swing content
        */
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(2,2,10,10)); //edit this to change layout of fields
        
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
        
        /*
        Button Variables
        */
        JButton editButton = new JButton("Edit");
        JButton backButton = new JButton("Back");
        
        JLabel prIDName = new JLabel("Project ID");
        JLabel prName = new JLabel("Project Name");
        JLabel rsName = new JLabel("Reasearcher Name");
        JLabel dayName = new JLabel("Day of Creation");
        JLabel monthName = new JLabel("Month of Creation");
        JLabel yearName = new JLabel("Year of Creation");
        JLabel urlName = new JLabel("Download URL");
        JLabel commentName = new JLabel("Comments");
        
        // Adds Text areas to fields panel
        fields.add(prIDName);
        fields.add(projectID);
        fields.add(prName);
        fields.add(projectName);
        fields.add(rsName);
        fields.add(researcher);
        fields.add(dayName);
        fields.add(day);
        fields.add(monthName);
        fields.add(month);
        fields.add(yearName);
        fields.add(year);
        fields.add(urlName);
        fields.add(downloadURL);
        fields.add(commentName);
        fields.add(comments);
        fields.add(researcherSig);
        fields.add(risSig);
        fields.add(depDeanSig);
        fields.add(deanSig);
        
        //adds panels to fields
        edit.add(fields);
        edit.add(buttons);
        
        //adds buttons to buttons panel
         buttons.add(editButton);
         buttons.add(backButton);
      
         
        /*
         This following code handles how the edit button will react when clicked
         
         I have it pulling the information from the text boxes then pushing them to the test Code class instance
         */ 
        editButton.setBounds(130,100,100,40);//Sets size of button
        editButton.setMnemonic(KeyEvent.VK_A);
        editButton.setTransferHandler(new TransferHandler("text"));
        editButton.addActionListener((ActionEvent event) -> 
        {
            /*
            * Coverts Strings from JTextAreas int integer values
            */
            int prID = Integer.parseInt(projectID.getText());
            int dy = Integer.parseInt(day.getText());
            int mh = Integer.parseInt(month.getText());
            int yr = Integer.parseInt(year.getText());
            
            /*
            This following set of methods updates the test node with variables from JTextAreas
            */
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
            
            edit.dispose();
            editScreen(); //New Instance of edit screen
        }
        ); 
        backButton.setBounds(130,100,100,40);//Sets size of button
        backButton.setMnemonic(KeyEvent.VK_A);
        backButton.setTransferHandler(new TransferHandler("text"));
        backButton.addActionListener((ActionEvent event) -> 
        {
            edit.dispose();
            mainScreen();
        }
        );
    }
    
    void newProject(){
        JFrame newProject = new JFrame();
        newProject.setSize(1500,1000);//size of frame
        newProject.setLayout(new GridLayout(10,10));//change this to change edit screen layout
        newProject.setVisible(true);//makes it visible
        
        /*
        *JPanels to strore java swing content
        */
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(2,2,10,10)); //edit this to change layout of fields
        
        JTextArea projectID;
        JTextArea projectName;
        JTextArea researcher;
        JTextArea day;
        JTextArea month;
        JTextArea year;
        JTextArea downloadURL;
        JTextArea comments;
        JCheckBox researcherSig;

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
        
        /*
        Button Variables
        */
        JButton editButton = new JButton("Create");
        JButton backButton = new JButton("Back");
        
        JLabel prIDName = new JLabel("Project ID");
        JLabel prName = new JLabel("Project Name");
        JLabel rsName = new JLabel("Reasearcher Name");
        JLabel dayName = new JLabel("Day of Creation");
        JLabel monthName = new JLabel("Month of Creation");
        JLabel yearName = new JLabel("Year of Creation");
        JLabel urlName = new JLabel("Download URL");
        JLabel commentName = new JLabel("Comments");
        
        
        // Adds Text areas to fields panel
        fields.add(prIDName);
        fields.add(projectID);
        fields.add(prName);
        fields.add(projectName);
        fields.add(rsName);
        fields.add(researcher);
        fields.add(dayName);
        fields.add(day);
        fields.add(monthName);
        fields.add(month);
        fields.add(yearName);
        fields.add(year);
        fields.add(urlName);
        fields.add(downloadURL);
        fields.add(commentName);
        fields.add(comments);
        fields.add(researcherSig);
        
        //adds panels to fields
        newProject.add(fields);
        newProject.add(buttons);
        
        //adds buttons to buttons panel
         buttons.add(editButton);
         buttons.add(backButton);
      
         
        /*
         This following code handles how the edit button will react when clicked
         
         I have it pulling the information from the text boxes then pushing them to the test Code class instance
         */ 
        editButton.setBounds(130,100,100,40);//Sets size of button
        editButton.setMnemonic(KeyEvent.VK_A);
        editButton.setTransferHandler(new TransferHandler("text"));
        editButton.addActionListener((ActionEvent event) -> 
        {
            /*
            * Coverts Strings from JTextAreas int integer values
            */
            int prID = Integer.parseInt(projectID.getText());
            int dy = Integer.parseInt(day.getText());
            int mh = Integer.parseInt(month.getText());
            int yr = Integer.parseInt(year.getText());
            
            /*
            This following set of methods updates the test node with variables from JTextAreas
            */
            test.editProjectID(prID);
            test.editProjectName(projectName.getText());
            test.editResearcher(researcher.getText());
            test.editDay(dy);
            test.editMonth(mh);
            test.editYear(yr);
            test.editDownload_URL(downloadURL.getText());
            test.editComments(comments.getText());
            test.editResearcherSig(researcherSig.isSelected());
            
            newProject.dispose();
            newProject(); //New Instance of edit screen
           }
        ); 
        
        backButton.setBounds(130,100,100,40);//Sets size of button
        backButton.setMnemonic(KeyEvent.VK_A);
        backButton.setTransferHandler(new TransferHandler("text"));
        backButton.addActionListener((ActionEvent event) -> 
        {
            newProject.dispose();
            mainScreen();
        }
        );
    }
}
