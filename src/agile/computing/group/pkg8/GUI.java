/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.List;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfImage;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author craig
 */
public class GUI {

    EmailNotification email = new EmailNotification();
    Node test = new Node(); // used for manipulating variables see craig for info
    FileHandler fh = new FileHandler();
    PrintHandler print = new PrintHandler();
    DBConnection connection;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";
    String selected;
    String recipient = "craighutcheon333@hotmail.com";
    String content = "This is a test";
    String subject = "New Notification";
    JOptionPane SQLError = new JOptionPane();
    int id;
    
    void startScreen(){
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (InstantiationException e) {
            e.printStackTrace(System.out);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.out);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace(System.out);
        }
        
        JFrame startScreen = new JFrame();
        startScreen.setSize(400, 500);
        startScreen.setLocationRelativeTo(null);
        
        JPanel buttons = new JPanel();
        startScreen.add(buttons);
        
        
        startScreen.setVisible(true);//makes it visible
        
        JButton signIn = new JButton("Sign in");//Creates new Button
        buttons.add(signIn);

        signIn.setBounds(130, 100, 100, 40);//Sets size of button
        signIn.setMnemonic(KeyEvent.VK_A);
        signIn.setTransferHandler(new TransferHandler("text"));
        signIn.addActionListener((ActionEvent event)
                -> {
            startScreen.dispose();
           loginScreen();
           //FAQScreen();
        }
        );
        
        JButton signUp = new JButton("Sign up");//Creates new Button
        buttons.add(signUp);
        
        signUp.setBounds(130, 100, 100, 40);//Sets size of button
        signUp.setMnemonic(KeyEvent.VK_A);
        signUp.setTransferHandler(new TransferHandler("text"));
        signUp.addActionListener((ActionEvent event)
                -> {
            startScreen.dispose();
            //signUpScreen();
        }
        );
        
    }
    
/*    WIP
    void signUpScreen(){
        JFrame signupScreen = new JFrame();
        signupScreen.setSize(400, 500);
        signupScreen.setLocationRelativeTo(null);
        signupScreen.setVisible(true);
        
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(4,2));
        
        JLabel firstName = new JLabel("First Name:");
        JLabel lastName = new JLabel("Last name(s):");
        JLabel staffID = new JLabel("Staff ID:");
        JLabel jobType = new JLabel("Job Type:");
        
        JTextField firstNameData = new JTextField();
        JTextField lastNameData = new JTextField();
        JTextField staffIDData = new JTextField();
        JTextField jobTypeData = new JTextField();
        
        fields.add(firstName);
        fields.add(firstNameData);
        fields.add(lastName);
        fields.add(lastNameData);
        fields.add(staffID);
        fields.add(staffIDData);
        fields.add(jobType);
        fields.add(jobTypeData);
        
        signupScreen.add(fields);
        
        
        
        //need 4 labels and 4 text fields
        //
        //first name
        //last name
        //staff id
        //job type
        
    }
*/
    
    void loginScreen() {

        //commented out for the moment
        //email.sendEmail(subject, content, recipient);

        
        //Sets up a new database connection
        connection = new DBConnection(host, db, username, password);

        //LOGIN labels, text boxes and buttons.
        JFrame login = new JFrame();
        login.setSize(400, 500);
        login.setLocationRelativeTo(null);
        JOptionPane frame = new JOptionPane();
        JLabel usernamelabel = new JLabel("Staff ID: ");
        usernamelabel.setBounds(40, 40, 120, 23);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel passwordlabel = new JLabel("password: ");
        passwordlabel.setBounds(40, 70, 120, 23);

        JTextField username = new JTextField();
        username.setBounds(200, 40, 150, 25);

        JPasswordField password = new JPasswordField();
        password.setBounds(200, 70, 150, 25);

        JButton b = new JButton("login");//Creates new Button
        b.setBounds(130, 100, 100, 40);//Sets size of button
        login.getRootPane().setDefaultButton(b);

        login.add(usernamelabel);
        login.add(username);
        login.add(passwordlabel);
        login.add(password);
        login.add(b);//Adds button to Frame

        login.setSize(400, 500);//size of frame
        login.setLayout(null);//no layout manager
        login.setVisible(true);//makes it visible

        //Action handler for when login button is clicked
        b.setMnemonic(KeyEvent.VK_A);
        b.setTransferHandler(new TransferHandler("text"));
        b.addActionListener((ActionEvent event)
                -> {
            
            //gets username and password from textboxes.
            int uname = Integer.parseInt(username.getText());
            char[] pwd = password.getPassword();
            String pass = new String(pwd);

            //calls the getUserByStaffID method in the DBConnection class
            ResultSet result = connection.getUserByStaffID(uname);

            try {
                result.next();
                //input validation 
                if (uname == 0 || pwd == null) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid username or password", "Login Error", ERROR_MESSAGE);
                } else if (result.getString("Password") == null) {
                    JOptionPane.showMessageDialog(frame, "Username not found. Please try again.");
                } else if (result.getString("Password").equals(pass)) {
                    //These if statements will be for when we implement views. Right now they all go to the same place.
                    if (result.getString("JobType").equals("Researcher")) {
                        login.dispose();
                        mainScreen();
                        //launch view
                        ResearcherView reView = new ResearcherView(uname);
                        reView.setVisible(true);
                        
                    } else if (result.getString("JobType").equals("RIS")) {
                        login.dispose();
                        mainScreen();
                        //launch view
                        RISView risView = new RISView();
                        risView.setVisible(true);
                        
                    } else if (result.getString("JobType").equals("Admin")) {
                        login.dispose();
                        mainScreen();
                    } else if (result.getString("JobType").equals("Associate Dean")) {
                        login.dispose();
                        mainScreen();
                        
                        // launch view
                        AssociateDeanView assoView = new AssociateDeanView();
                        assoView.setVisible(true);
                    } else if (result.getString("JobType").equals("Dean")) {
                        login.dispose();
                        mainScreen();
                        DeanView deanView = new DeanView();
                        deanView.setVisible(true);
                    }

                } else {
                    
                    JOptionPane.showMessageDialog(frame, "The password you have entered is wrong. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(SQLError, "Sign in Error. No Connection to server.", "MySQL Error", ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(SQLError, "Please enter valid sign in details.", "MySQL Error", ERROR_MESSAGE);
            }
        }
        );             
    }

    /**
    * @param 
    *
    * @return 
    *
    * @authot Craig
    **/
    void mainScreen() {
        
        
        JOptionPane notSelectedErrorMSG = new JOptionPane();
        JFrame main = new JFrame();
        main.setSize(500, 600);//size of frame
        main.setLocationRelativeTo(null);
        main.setLayout(new GridLayout(4, 1));//no layout manager
        main.setVisible(true);//makes it visible
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        //obsolete below vvvvv
        
        /*DefaultListModel dlm = new DefaultListModel();
        ResultSet rs = connection.getProjects();
        try {
        while (rs.next()) {
        dlm.addElement(rs.getString("id") + " " + rs.getString("name"));
        }
        } catch (SQLException e) {
        e.printStackTrace(System.out);
        }
        
        /*JList mlist = new JList(dlm); //data has type Object[]
        mlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        mlist.setLayoutOrientation(JList.VERTICAL_WRAP);
        mlist.setVisibleRowCount(-1);
        
        main.add(mlist);*/
        
        
        DefaultListModel listProgress = new DefaultListModel();
        ResultSet rs2 = connection.getProjects();
        try {
            while (rs2.next()) {
                
                
                // implement checkboxes to indicate progress --> sprint2.
                JCheckBox researcherSig; 
                JCheckBox risSig;
                JCheckBox depDeanSig;
                JCheckBox deanSig;
                
                if (rs2.getString("ris_sig").equals("1"))
                {
                    //sprint2
                    
                } else {
                    
                }
                
                // getting data from database 
                listProgress.addElement(rs2.getString("id") + "\n\n " + rs2.getString("name") + " .--->      Signed by:  Researcher: " + rs2.getString("researcher_sig") + " RIS: " +rs2.getString("ris_sig") + " Associate Dean: " + rs2.getString("depDean_sig") + " Dean: " + rs2.getString("dean_sig"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        
        JList mlist2 = new JList(listProgress); //data has type Object[]
        
        // using JScrollPane to create a scrolling list that displays projects 
        JScrollPane scrollerPane = new JScrollPane(mlist2);
        mlist2.setLayoutOrientation(JList.VERTICAL);
        main.add(scrollerPane);

        JPanel button = new JPanel();
        main.add(button);
        
        JButton newP = new JButton("New Project");//Creates new Button
        button.add(newP);

        newP.setBounds(130, 100, 100, 40);//Sets size of button
        newP.setMnemonic(KeyEvent.VK_A);
        newP.setTransferHandler(new TransferHandler("text"));
        newP.addActionListener((ActionEvent event)
                -> {
            main.dispose();
            newProject();
        }
        );

        JButton edit = new JButton("Edit");//Creates new Button
        button.add(edit);

        edit.setBounds(130, 100, 100, 100);//Sets size of button
        edit.setMnemonic(KeyEvent.VK_A);
        edit.setTransferHandler(new TransferHandler("text"));
        edit.addActionListener((ActionEvent event)
                -> {   
            try {
                selected = mlist2.getSelectedValue().toString();
                System.out.println(selected);
                
                main.dispose();
                editScreen();   
               
                //catching selected if it gets a response null, i.e. no project is selected
            } catch (NullPointerException  ex) {
               
                JOptionPane.showMessageDialog(notSelectedErrorMSG, "Please select a project", "No project Selected", WARNING_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
            }
        }
        );
        JButton help = new JButton("Help");
        button.add(help);
        
        help.setBounds(130, 100, 100, 40);
        help.setMnemonic(KeyEvent.VK_A);
        help.setTransferHandler(new TransferHandler("text"));
        help.addActionListener((ActionEvent event)
                -> {
            main.dispose();
            helpScreen();
        }
        );
                
        JButton exit = new JButton("Logout");//Creates new Button
        button.add(exit);

        exit.setBounds(130, 100, 100, 40);//Sets size of button
        exit.setMnemonic(KeyEvent.VK_A);
        exit.setTransferHandler(new TransferHandler("text"));
        exit.addActionListener((ActionEvent event)
                -> {
            main.dispose();
            loginScreen();
        }
        );
        
          
    }

    /**
     * Swing Screen to allow user to edit fields
     */
    void editScreen() throws SQLException {
        JFrame edit = new JFrame();
        edit.setSize(400, 500);//size of frame
        edit.setLocationRelativeTo(null);
        edit.setLayout(new GridLayout(2, 2));//change this to change edit screen layout
        edit.setVisible(true);//makes it visible

        /*
        *JPanels to strore java swing content
         */
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(10, 1, 5, 5)); //edit this to change layout of fields

        JTextArea projectID;
        JTextArea projectName;
        JTextArea researcher;
        JTextArea dateBox;
        JTextArea downloadURL;
        JTextArea comments;
        JCheckBox researcherSig;
        JCheckBox risSig;
        JCheckBox depDeanSig;
        JCheckBox deanSig;

        /*
        * Converts String variables to int for JTextAreas
         */
        
        ResultSet rs = connection.getProject(selected.split(" ")[0]);
        rs.next();
        id = rs.getInt("id");
        projectID = new JTextArea(Integer.toString(rs.getInt("id")), 1, 1);
        projectName = new JTextArea(rs.getString("name"), 10, 10);
        researcher = new JTextArea(rs.getString("researcher"), 10, 10);
        dateBox = new JTextArea((rs.getDate("date")).toString(), 10, 10);
        downloadURL = new JTextArea(rs.getString("file_path"), 10, 10);
        comments = new JTextArea(rs.getString("comments"), 10, 10);
        researcherSig = new JCheckBox("Researcher Signature", rs.getInt("researcher_sig") > 0);
        risSig = new JCheckBox("RIS Signature", rs.getInt("ris_sig") > 0);
        depDeanSig = new JCheckBox("Deputy Dean Signature", rs.getInt("depDean_sig") > 0);
        deanSig = new JCheckBox("Deans Signature", rs.getInt("dean_sig") > 0);

        /*
        Button Variables
         */
        JButton editButton = new JButton("Edit");
        JButton backButton = new JButton("Back");
        JButton printButton = new JButton("Export to PDF");
        JButton uploadButton = new JButton("Upload new File");
        JButton downloadButton = new JButton("Download excel");

        JLabel prIDName = new JLabel("Project ID");
        JLabel prName = new JLabel("Project Name");
        JLabel rsName = new JLabel("Reasearcher Name");
        JLabel dayName = new JLabel("Date of Creation");
        JLabel urlName = new JLabel("Download URL");
        JLabel commentName = new JLabel("Comments");

        // Adds Text areas to fields panel
        fields.add(prIDName);
        fields.add(projectID);
        projectID.setEditable(false);
        fields.add(prName);
        fields.add(projectName);
        fields.add(rsName);
        fields.add(researcher);
        researcher.setEditable(false);
        fields.add(dayName);
        fields.add(dateBox);
        dateBox.setEditable(false);
        fields.add(urlName);
        fields.add(downloadURL);
        downloadURL.setEditable(false);
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
        buttons.add(printButton);
        buttons.add(downloadButton);
        /*
         This following code handles how the edit button will react when clicked
         
         I have it pulling the information from the text boxes then pushing them to the test Code class instance
         */
        editButton.setBounds(130, 100, 100, 40);//Sets size of button
        editButton.setMnemonic(KeyEvent.VK_A);
        editButton.setTransferHandler(new TransferHandler("text"));
        editButton.addActionListener((ActionEvent event)
                -> {
            int reply = JOptionPane.showConfirmDialog(null, "This action will edit the project. Are you sure?", "warning", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                connection.editProject(projectID.getText(), projectName.getText(), comments.getText(), researcherSig.isSelected(), risSig.isSelected(), depDeanSig.isSelected(), deanSig.isSelected());
                edit.dispose();
                mainScreen(); //New Instance of edit screen
            }

        }
        );
        backButton.setBounds(130, 100, 100, 40);//Sets size of button
        backButton.setMnemonic(KeyEvent.VK_A);
        backButton.setTransferHandler(new TransferHandler("text"));
        backButton.addActionListener((ActionEvent event)
                -> {
            edit.dispose();
            mainScreen();
        }
        );

        printButton.setBounds(130, 100, 100, 40);//Sets size of button
        printButton.setMnemonic(KeyEvent.VK_A);
        printButton.setTransferHandler(new TransferHandler("text"));
        printButton.addActionListener((ActionEvent event)
                -> {
                    //calling logic on button press
                    
                    exportPDFLogic(rs);
        }
            );
        
        buttons.add(uploadButton);
        uploadButton.setBounds(130, 100, 100, 40);//Sets size of button
        uploadButton.setMnemonic(KeyEvent.VK_A);
        uploadButton.setTransferHandler(new TransferHandler("text"));
        uploadButton.addActionListener((ActionEvent event)
                -> {
              File file =  uploadFile();
              fh.uploadFile(new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files"), file, id);
        }
        );
        
        downloadButton.setBounds(130, 100, 100, 40);//Sets size of button
        downloadButton.setMnemonic(KeyEvent.VK_A);
        downloadButton.setTransferHandler(new TransferHandler("text"));
        downloadButton.addActionListener((ActionEvent event)
                -> {
            fh.downloadFile(new File(downloadURL.getText()));
        }
        );  
    }
    
    // for testing, ignore for now
    void getNewResultSet(String id) throws SQLException{

        //open new connection
        
        DBConnection connection2 = new DBConnection(host, db, username, password);
        
        System.out.println(id);
        ResultSet rs;
        rs = connection2.getProject(id);
        rs.next();
        

        exportPDFLogic(rs);
    }
    
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
    void helpScreen() {
        
        JFrame helpScreen = new JFrame();
        helpScreen.setSize(400, 500);
        helpScreen.setLocationRelativeTo(null);
        helpScreen.setLayout(new GridLayout(0, 1));//change this to change edit screen layout
        helpScreen.setVisible(true);//makes it visible
        
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(4,1));
        
        JLabel subjectLabel;
        subjectLabel = new JLabel("Subject:");
        
        JTextArea subjectArea;
        subjectArea = new JTextArea(5,20);
        subjectArea.setLineWrap(true);
        
        JLabel queryLabel;
        queryLabel = new JLabel("Body:");
        
        JTextArea queryArea;
        queryArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(queryArea);
        queryArea.setLineWrap(true);
        
        fields.add(subjectLabel);
        fields.add(subjectArea);
        fields.add(queryLabel);
        fields.add(scrollPane);
        
        helpScreen.add(fields);
        
        
        JButton sendButton = new JButton("Send");
        JButton backButton = new JButton("Back");
        
        buttons.add(sendButton);
        buttons.add(backButton);
        helpScreen.add(buttons);
        
        
        sendButton.setBounds(130, 100, 100, 40);//Sets size of button
        sendButton.setMnemonic(KeyEvent.VK_A);
        sendButton.setTransferHandler(new TransferHandler("text"));
        sendButton.addActionListener((ActionEvent event)
                -> {
            //send query to email
            EmailNotification email = new EmailNotification();
            String subject = subjectArea.getText();
            String content = queryArea.getText();
            String recipient = "andreilins96@gmail.com";
            
            email.sendEmail(subject, content, recipient);
            
            subjectArea.setText("");
            queryArea.setText("");
            
            JOptionPane.showMessageDialog(helpScreen, "Your message has been sent.");
        }
        );
        
        backButton.setBounds(130, 100, 100, 40);//Sets size of button
        backButton.setMnemonic(KeyEvent.VK_A);
        backButton.setTransferHandler(new TransferHandler("text"));
        backButton.addActionListener((ActionEvent event)
                -> {
            helpScreen.dispose();
            mainScreen();
        }
        );
        
        
        
        
    }

    void newProject() {

        JFrame newProject = new JFrame();
        newProject.setSize(400, 500);//size of frame
        newProject.setLocationRelativeTo(null);
        newProject.setLayout(new GridLayout(2, 2));//change this to change edit screen layout
        newProject.setVisible(true);//makes it visible

        /*
        *JPanels to strore java swing content
         */
        JPanel buttons = new JPanel();
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(10, 1, 5, 5)); //edit this to change layout of fields

        JTextArea projectName;
        JTextArea researcher;
        JTextArea comments;

        projectName = new JTextArea("", 10, 10);
        researcher = new JTextArea("", 10, 10);
        comments = new JTextArea("", 10, 10);

        /*
        Button Variables
         */
        JButton editButton = new JButton("Create");
        JButton backButton = new JButton("Back");

        JLabel prName = new JLabel("Project Name");
        JLabel rsName = new JLabel("Reasearcher Name");
        JLabel commentName = new JLabel("Comments");

        fields.add(prName);
        fields.add(projectName);
        fields.add(rsName);
        fields.add(researcher);
        fields.add(commentName);
        fields.add(comments);

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
        editButton.setBounds(130, 100, 100, 40);//Sets size of button
        editButton.setMnemonic(KeyEvent.VK_A);
        editButton.setTransferHandler(new TransferHandler("text"));
        editButton.addActionListener((ActionEvent event)
                -> {

            File file = uploadFile();

            int reply = JOptionPane.showConfirmDialog(null, "This action will create new project. Are you sure?", "warning", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {

                connection.newProject(id, projectName.getText(), researcher.getText(), comments.getText(), file.getName(), "\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
                fh.uploadFile(new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files"), file, id);
                newProject.dispose();
                mainScreen(); //New Instance of edit screen

            }
        }
        );

        backButton.setBounds(130, 100, 100, 40);//Sets size of button
        backButton.setMnemonic(KeyEvent.VK_A);
        backButton.setTransferHandler(new TransferHandler("text"));
        backButton.addActionListener((ActionEvent event)
                -> {
            newProject.dispose();
            mainScreen();
        }
        );

       
    }

    void risPanel() {
        JFrame risPanel = new JFrame();

        risPanel.setSize(400, 500);//size of frame
        risPanel.setLocationRelativeTo(null);
        risPanel.setLayout(new GridLayout(10, 10));//no layout manager
        risPanel.setVisible(true);//makes it visible
        risPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton viewP = new JButton("View Projects");//Creates new Button
        risPanel.add(viewP);

        viewP.setBounds(130, 100, 100, 40);//Sets size of button
        viewP.setMnemonic(KeyEvent.VK_A);
        viewP.setTransferHandler(new TransferHandler("text"));
        viewP.addActionListener((ActionEvent event)
                -> {
            risPanel.dispose();
            //Change this to something else
            newProject();
        }
        );

        JButton exit = new JButton("Logout");//Creates new Button
        risPanel.add(exit);

        exit.setBounds(130, 100, 100, 40);//Sets size of button
        exit.setMnemonic(KeyEvent.VK_A);
        exit.setTransferHandler(new TransferHandler("text"));
        exit.addActionListener((ActionEvent event)
                -> {
            risPanel.dispose();
            loginScreen();
        }
        );

    }

    void adminScreen() {
        JFrame admin = new JFrame();
        admin.setSize(400, 500);//size of frame
        admin.setLocationRelativeTo(null);
        admin.setLayout(new GridLayout(10, 10));//no layout manager
        admin.setVisible(true);//makes it visible
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton search = new JButton("Search");//Creates new Button
        admin.add(search);

        search.setBounds(130, 100, 100, 40);//Sets size of button
        search.setMnemonic(KeyEvent.VK_A);
        search.setTransferHandler(new TransferHandler("text"));
        search.addActionListener((ActionEvent event)
                -> {
            admin.dispose();
            //change this to something else
            newProject();
        }
        );

        JButton add = new JButton("Add");//Creates new Button
        admin.add(add);

        add.setBounds(130, 100, 100, 40);//Sets size of button
        add.setMnemonic(KeyEvent.VK_A);
        add.setTransferHandler(new TransferHandler("text"));
        add.addActionListener((ActionEvent event)
                -> {
            admin.dispose();
            try {
                //Also change this to something else
                editScreen();
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
            }
        }
        );

        JButton edit = new JButton("Edit");//Creates new Button
        admin.add(edit);

        edit.setBounds(130, 100, 100, 40);//Sets size of button
        edit.setMnemonic(KeyEvent.VK_A);
        edit.setTransferHandler(new TransferHandler("text"));
        edit.addActionListener((ActionEvent event)
                -> {
            admin.dispose();
            try {
                //Also change this to something else
                editScreen();
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
                
            }
        }
        );

        JButton exit = new JButton("Logout");//Creates new Button
        admin.add(exit);

        exit.setBounds(130, 100, 100, 40);//Sets size of button
        exit.setMnemonic(KeyEvent.VK_A);
        exit.setTransferHandler(new TransferHandler("text"));
        exit.addActionListener((ActionEvent event)
                -> {
            admin.dispose();
            loginScreen();
        }
        );

    }

    void associateDeanScreen() {
        JFrame aDean = new JFrame();
        aDean.setSize(400, 500);//size of frame
        aDean.setLocationRelativeTo(null);
        aDean.setLayout(new GridLayout(10, 10));//no layout manager
        aDean.setVisible(true);//makes it visible
        aDean.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton view = new JButton("View Projects");//Creates new Button
        aDean.add(view);

        view.setBounds(130, 100, 100, 40);//Sets size of button
        view.setMnemonic(KeyEvent.VK_A);
        view.setTransferHandler(new TransferHandler("text"));
        view.addActionListener((ActionEvent event)
                -> {
            aDean.dispose();
            //change this to something else
            newProject();
        }
        );

        JButton exit = new JButton("Logout");//Creates new Button
        aDean.add(exit);

        exit.setBounds(130, 100, 100, 40);//Sets size of button
        exit.setMnemonic(KeyEvent.VK_A);
        exit.setTransferHandler(new TransferHandler("text"));
        exit.addActionListener((ActionEvent event)
                -> {
            aDean.dispose();
            loginScreen();
        }
        );

    }
    
    File uploadFile(){
        JFrame dialogFrame = new JFrame();

            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Excel file", "xls", "xlsx"));
            fc.setDialogTitle("Choose file");

            int userSelection = fc.showSaveDialog(dialogFrame);
            File file = null;
            switch (userSelection) {
                case JFileChooser.APPROVE_OPTION:
                    //File file = new File(fc.getSelectedFile().getName());
                    file = new File(fc.getSelectedFile().toString());
                    break;
            }
            return file;
    }
    
 public void createPdf(String filename, ResultSet rs)
         
	throws DocumentException, IOException {
        Image image = Image.getInstance("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\University of Dundee (logo).png");
        Image sigTest = Image.getInstance("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\testSig.png");
        // step 1
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        document.add(new Chunk(""));
        // step 4
        try{
        ListItem iD = new ListItem(Integer.toString(rs.getInt("id")));
        ListItem name = new ListItem(rs.getString("name"));
        ListItem researcher = new ListItem(rs.getString("researcher"));
        ListItem date = new ListItem(rs.getDate("date").toString());
        ListItem filePath = new ListItem(rs.getString("file_path"));
        ListItem comments = new ListItem(rs.getString("comments"));
        image.scaleAbsolute(200, 75);
        sigTest.scaleAbsolute(50, 25);        
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
            document.add(sigTest);
        }
        if (rs.getInt("ris_sig") > 0){
            document.add(new Paragraph("RIS Signature"));
            document.add(sigTest);
        }
        if (rs.getInt("depDean_Sig") > 0){
            document.add(new Paragraph("Associate Dean Signature"));
            document.add(sigTest);
        }
        if (rs.getInt("dean_Sig") > 0){
            document.add(new Paragraph("Dean Signature"));
            document.add(sigTest);
        }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(SQLError, "MySQL Error", "MySQL Error", ERROR_MESSAGE);
        }
        // step 5
        document.close();
    }
 
    void FAQScreen(){
        
        JFrame faq = new JFrame();
        faq.setSize(400, 500);//size of frame
        faq.setLocationRelativeTo(null);
        faq.setVisible(true);
        faq.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel information = new JPanel();
        
        JTextArea text = new JTextArea(25,40);
        //faq.add(information);
        
        text.setEditable(false);
        text.setText("This area is for questions and answers");
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        
        //JScrollPane scrollbar = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scrollbar = new JScrollPane(text);

        information.add(scrollbar,BorderLayout.CENTER);
        faq.add(information);
        
        
        
    }
    
}

