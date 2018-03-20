/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.TransferHandler;
/**
 *
 * @author User
 */
public class AdminView extends javax.swing.JFrame {

    /**
     * Creates new form AdminView
     */
    ImageIcon img = new ImageIcon("src/agile/computing/group/pkg8/uod_logo_small.jpg");
    DBConnection connection;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String newPass = "7632.at8.2367";
    FileHandler fh = new FileHandler();
    ResultSet rs;
    String selected;
    boolean UpdateButton_clicked = false;
    String SelectedID;
    
    public AdminView() {
        initComponents();
        setIconImage(img.getImage());
        //getContentPane().setBackground(new Color(255,255,255));
        connection = new DBConnection(host,db,username,newPass);
        getDataForLists();
        getProjectsForList();
    }
    
    //will need to do method for getting projects
    //figure out why list isn't displaying
    private void getDataForLists(){
        
        DefaultListModel listProgress = new DefaultListModel();
        
       ResultSet rs2 = connection.getStaff();
        try{
            while(rs2.next()){
            
              int id = rs2.getInt("staffID");
              //String idStaff = Integer.toString(id);
              
              //listProgress.addElement("ID: " + rs2.getInt("staffID") + " \t Password: " + rs2.getString("password") + " \t Name: " +rs2.getString("firstName") + " " + rs2.getString("lastName") + " \t Email: " + rs2.getString("email") + " \t Job Type: " + rs2.getString("jobType") + " \t Signature Path: " + rs2.getString("sig_path") + " \t Signature Name: " + rs2.getString("sig_name"));
              listProgress.addElement("ID: " + id + " \t Password: " + rs2.getString("password") + " \t Name: " +rs2.getString("firstName") + " " + rs2.getString("lastName") + " \t Email: " + rs2.getString("email") + " \t Job Type: " + rs2.getString("jobType") + " \t Signature Path: " + rs2.getString("sig_path") + " \t Signature Name: " + rs2.getString("sig_name"));
            }
            
        }
        
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
      
      staffList.setModel(listProgress);
      
      }
    
    public void getProjectsForList(){
        
        DefaultListModel projList = new DefaultListModel();
   
       ResultSet rs = connection.getProjects();
      
        try{
            while(rs.next()){

                projList.addElement("Project ID: " + rs.getString("id") + " \t Name: " + rs.getString("name") + " \t Researcher: " + rs.getString("researcher") + " \t Date: " + rs.getString("date") + " \t File Name: " + rs.getString("file_name") + " \t File Path: " + rs.getString("file_path"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        projectList.setModel(projList);
    }
    
    public void clear(){
         staffID.setText("");
         email.setText("");
         password.setText("");
         firstname.setText("");
         lastName.setText("");
         jobType.setText("");
         
    }
    
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        staffList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectList = new javax.swing.JList<>();
        refreshButton = new javax.swing.JButton();
        editStaffPanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        fnameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jobTypeLabel = new javax.swing.JLabel();
        staffID = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jobType = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        deleteStaffIDLabel = new javax.swing.JLabel();
        deleteStaffID = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        deleteLabel = new javax.swing.JLabel();
        projectLabel = new javax.swing.JLabel();
        deleteProjectID = new javax.swing.JTextField();
        deleteProjectButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        staffIDField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        UpdateButton = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        change_password_button = new javax.swing.JMenuItem();
        change_sig_image_button = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        topPane.setBackground(new java.awt.Color(255, 255, 255));

        staffList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        staffList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(staffList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        topPane.addTab("Staff", jPanel1);

        projectList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(projectList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        topPane.addTab("Projects", jPanel2);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        editStaffPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        idLabel.setText("Staff ID:");

        passwordLabel.setText("Password:");

        fnameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        emailLabel.setText("Email:");

        jobTypeLabel.setText("Job Type:");

        jobType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTypeActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Upload Signature");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Note: Add user first before uploading the signature.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(26, 26, 26)
                        .addComponent(staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addGap(18, 18, 18)
                                .addComponent(password))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(fnameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLabel)
                                    .addComponent(emailLabel)
                                    .addComponent(jobTypeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jobType)
                                    .addComponent(email)
                                    .addComponent(lastName))))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(staffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fnameLabel)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobTypeLabel)
                            .addComponent(jobType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        editStaffPanel.addTab("Add Staff", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Delete by:");

        deleteStaffIDLabel.setText("Staff ID:");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(deleteStaffIDLabel)
                            .addGap(27, 27, 27)
                            .addComponent(deleteStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(444, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteStaffIDLabel)
                    .addComponent(deleteStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        editStaffPanel.addTab("Delete Staff", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        deleteLabel.setText("Delete by:");

        projectLabel.setText("Project ID:");

        deleteProjectButton.setText("Delete");
        deleteProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProjectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteProjectButton)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(deleteLabel)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(projectLabel)
                            .addGap(18, 18, 18)
                            .addComponent(deleteProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteProjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(deleteLabel)
                        .addGap(18, 18, 18)
                        .addComponent(projectLabel)))
                .addGap(18, 18, 18)
                .addComponent(deleteProjectButton)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        editStaffPanel.addTab("Delete Project", jPanel5);

        jLabel3.setText("Staff ID :");

        jLabel4.setText("Email :");

        jLabel5.setText("Password:");

        passwordField.setText("jPasswordField1");

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(57, 57, 57)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(62, 62, 62)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(staffIDField)
                                .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                    .addComponent(UpdateButton))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(UpdateButton)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        editStaffPanel.addTab("Edit Staff", jPanel6);

        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        change_password_button.setText("Change Password");
        jMenu1.add(change_password_button);

        change_sig_image_button.setText("Change Signature Image");
        jMenu1.add(change_sig_image_button);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(editStaffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(topPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout_button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(logout_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editStaffPanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTypeActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        
        //gets username and password from textboxes.
            int uname = Integer.parseInt(staffID.getText());
            char[] pwd = password.getPassword();
            String pass = new String(pwd);
            String firstName = firstname.getText();
            String lastname = lastName.getText();
            String emailAddress = email.getText();
            String job = jobType.getText();
            
            connection.addStaff(uname,pass,firstName,lastname,emailAddress,job);
            
            
            
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        int uname = Integer.parseInt(deleteStaffID.getText());
        connection.removeUserById(uname);
        
        deleteStaffID.setText("");
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        
        staffList.clearSelection();
        projectList.clearSelection();
        getDataForLists();
        getProjectsForList();
        clear();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProjectButtonActionPerformed
        
        int id = Integer.parseInt(deleteProjectID.getText());
       // connection.removeProjectById(id);
        
        deleteProjectID.setText("");
    }//GEN-LAST:event_deleteProjectButtonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
       AdminView.this.dispose();
       StartScreen startScreen = new StartScreen();
       startScreen.setLocationRelativeTo(null);
       startScreen.setVisible(true);
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //selects the image
        File file =  fh.imageSelect();
        int uname = Integer.parseInt(deleteStaffID.getText());
        //uploads the image 
        Boolean success = fh.uploadSignature(new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\Signatures"), file, uname);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:
        //UpdateButton_clicked = true;
        PushUpdate();
     
     
       // int StaffID = Integer.parseInt(staffIDField.getText());
       // String Password = passwordField.getText();
        //String emailAddress = emailField.getText();
        //connection.editStaff(StaffID, Password, FirstName, LastName, emailAddress, JobType, sig_path, sig_name);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void staffListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffListMouseClicked
        // TODO add your handling code here:
         try {
            selected = staffList.getSelectedValue();
            getSelectedStaffDetails();
        } catch (SQLException ex) {
            Logger.getLogger(ResearcherView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_staffListMouseClicked

     private ResultSet getSelectedStaffDetails() throws SQLException
    {
        String updatedEmail;
        String updatedPassword;
        
        //ResultSet selectedStaffResultSet = connection.getUserByStaffID(idselected);
         String s = selected.split(" ")[1];
        
        SelectedID = s;
        System.out.println(s);
        
        int idselected;
        idselected = Integer.parseInt(s);
        ResultSet selectedStaffResultSet = connection.getUserByStaffID(idselected);
        selectedStaffResultSet.next();
        String FirstName = selectedStaffResultSet.getString("FirstName");
        String LastName = selectedStaffResultSet.getString("LastName");
        String JobType = selectedStaffResultSet.getString("JobType");
        String sig_path = selectedStaffResultSet.getString("sig_path");
        String sig_name = selectedStaffResultSet.getString("sig_name");
        
         if (UpdateButton_clicked == true){
            updatedEmail = emailField.getText();
            updatedPassword = passwordField.getText();
            
            System.out.println(updatedEmail + updatedPassword);
            
        //connection.editStaff(id, updatedPassword, FirstName, LastName, updatedEmail, JobType, sig_path, sig_name);
        }else{
             
         }
        int id = selectedStaffResultSet.getInt("staffID");
        String ids;
        ids = Integer.toString(id);
        String Password = selectedStaffResultSet.getString("Password");

        String emailAddress = selectedStaffResultSet.getString("email");
       
        
        staffIDField.setText(ids);
        passwordField.setText(Password);
        emailField.setText(emailAddress);
        
        
        
        
        UpdateButton_clicked = false;
        return selectedStaffResultSet;
    }
   
    public void PushUpdate(){
        int id;
        String updatedEmail;
        String updatedPassword;
        
        id = Integer.parseInt(deleteStaffID.getText());
        System.out.println(id);
       updatedPassword = passwordField.getText();
        updatedEmail = emailField.getText();
        
        //ResultSet rs = connection.getUserByStaffID(idselected);
        connection.updateStaffDetails(id, updatedPassword, updatedEmail);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem change_password_button;
    private javax.swing.JMenuItem change_sig_image_button;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JButton deleteProjectButton;
    private javax.swing.JTextField deleteProjectID;
    private javax.swing.JTextField deleteStaffID;
    private javax.swing.JLabel deleteStaffIDLabel;
    private javax.swing.JTabbedPane editStaffPanel;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel fnameLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jobType;
    private javax.swing.JLabel jobTypeLabel;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton logout_button;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel projectLabel;
    private javax.swing.JList<String> projectList;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField staffID;
    private javax.swing.JTextField staffIDField;
    private javax.swing.JList<String> staffList;
    private javax.swing.JTabbedPane topPane;
    // End of variables declaration//GEN-END:variables
}
