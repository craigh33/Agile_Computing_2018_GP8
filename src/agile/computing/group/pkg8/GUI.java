/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import com.itextpdf.text.DocumentException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author craig
 */
public class GUI {

    Node test = new Node(); // used for manipulating variables see craig for info
    FileHandler fh = new FileHandler();
    PrintHandler print = new PrintHandler();
    DBConnection connection;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";
    int id;

    void loginScreen() {

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

        connection = new DBConnection(host, db, username, password);

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

        login.add(usernamelabel);
        login.add(username);
        login.add(passwordlabel);
        login.add(password);
        login.add(b);//Adds button to Frame

        login.setSize(400, 500);//size of frame
        login.setLayout(null);//no layout manager
        login.setVisible(true);//makes it visible

        b.setMnemonic(KeyEvent.VK_A);
        b.setTransferHandler(new TransferHandler("text"));
        b.addActionListener((ActionEvent event)
                -> {

            int uname = Integer.parseInt(username.getText());
            char[] pwd = password.getPassword();
            String pass = new String(pwd);
            System.out.println(pass);

            ResultSet result = connection.getUserByStaffID(uname);

            try {
                if (uname == 0 || pwd == null) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid username or password", "Login Error", ERROR_MESSAGE);
                } else if (result.getString("Password") == null) {
                    JOptionPane.showMessageDialog(frame, "Username not found. Please try again.");
                } else if (result.getString("Password").equals(pass)) {

                    if (result.getString("JobType").equals("Researcher")) {
                        login.dispose();
                        mainScreen();
                    } else if (result.getString("JobType").equals("RIS")) {
                        login.dispose();
                        mainScreen();
                    } else if (result.getString("JobType").equals("Admin")) {
                        login.dispose();
                        mainScreen();
                    } else if (result.getString("JobType").equals("Associate Dean")) {
                        login.dispose();
                        mainScreen();
                    } else if (result.getString("JobType").equals("Dean")) {
                        login.dispose();
                        mainScreen();
                    }

                } else {
                    //things should probably go here but idk.
                    JOptionPane.showMessageDialog(frame, "The password you have entered is wrong. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
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
    void mainScreen() {
        JFrame main = new JFrame();
        main.setSize(400, 500);//size of frame
        main.setLocationRelativeTo(null);
        main.setLayout(new GridLayout(10, 10));//no layout manager
        main.setVisible(true);//makes it visible
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel dlm = new DefaultListModel();
        ResultSet rs = connection.getProjects();
        try {
            while (rs.next()) {
                dlm.addElement(rs.getString("id") + " " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        JList mlist = new JList(dlm); //data has type Object[]
        mlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        mlist.setLayoutOrientation(JList.VERTICAL_WRAP);
        mlist.setVisibleRowCount(-1);

        main.add(mlist);

        JButton newP = new JButton("New Project");//Creates new Button
        main.add(newP);

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
        main.add(edit);

        edit.setBounds(130, 100, 100, 40);//Sets size of button
        edit.setMnemonic(KeyEvent.VK_A);
        edit.setTransferHandler(new TransferHandler("text"));
        edit.addActionListener((ActionEvent event)
                -> {
            main.dispose();
            editScreen();
        }
        );

        JButton exit = new JButton("Logout");//Creates new Button
        main.add(exit);

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
    void editScreen() {
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

        projectID = new JTextArea(id, 1, 1);
        projectName = new JTextArea(test.returnProjectName(), 10, 10);
        researcher = new JTextArea(test.returnResearcher(), 10, 10);
        day = new JTextArea(d, 10, 10);
        month = new JTextArea(m, 10, 10);
        year = new JTextArea(y, 10, 10);
        downloadURL = new JTextArea(test.returnDownload_URL(), 10, 10);
        comments = new JTextArea(test.returnComments(), 10, 10);
        researcherSig = new JCheckBox("Researcher Signature", test.returnResearcherSig());
        risSig = new JCheckBox("RIS Signature", test.returnRISSig());
        depDeanSig = new JCheckBox("Deputy Dean Signature", test.returnDepDeanSig());
        deanSig = new JCheckBox("Deans Signature", test.returnDeanSig());

        /*
        Button Variables
         */
        JButton editButton = new JButton("Edit");
        JButton backButton = new JButton("Back");
        JButton printButton = new JButton("Print");

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
        buttons.add(printButton);

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

            try {
                print.createPdf(test.returnProjectName());
            } catch (DocumentException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        JButton uploadButton = new JButton("Upload File");
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
        buttons.add(uploadButton);
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

            int reply = JOptionPane.showConfirmDialog(null, "This action will create new project. Are you sure?", "warning", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {

                connection.newProject(id, projectName.getText(), researcher.getText(), comments.getText(), fc.getSelectedFile().getName(), "\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files");
                fh.uploadFile(new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\files"), fc.getSelectedFile(), id);
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

        uploadButton.setBounds(130, 100, 100, 40);//Sets size of button
        uploadButton.setMnemonic(KeyEvent.VK_A);
        uploadButton.setTransferHandler(new TransferHandler("text"));
        uploadButton.addActionListener((ActionEvent event)
                -> {

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
            //Also change this to something else
            editScreen();
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
            //Also change this to something else
            editScreen();
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

}