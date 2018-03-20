/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.awt.Color;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author craig
 */
public class DeanView extends javax.swing.JFrame {
    
    ImageIcon img = new ImageIcon("src/agile/computing/group/pkg8/uod_logo_small.jpg");
    private String downloadURL;
    ResultSet rs;
    JOptionPane warningWindow = new JOptionPane();
    DBConnection connection;
    String selected;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";
    String SelectedID;
    int staffID;
    String staffIDString;
    String fullName;
    boolean sign_button_clicked = false;
    FileHandler fh = new FileHandler();

    /**
     * Creates new form TestTemplate
     */
    public DeanView() {
        initComponents();
        setIconImage(img.getImage());
        getContentPane().setBackground(new Color(255,255,255));
        connection = new DBConnection(host,db,username,password);
        getDataForUnsignedProjectsList();
        project_name_field.setEditable(false);
        researcher_name_field.setEditable(false);
        date_of_creation_field.setEditable(false);
        //download_txtbox.setText(downloadURL);
        comments_field.setEditable(false);
        comments_field_update.setEditable(false);
        project_name_field_Update.setEditable(false);
        date_of_creation_field_update.setEditable(false);
        //new_download_link_field.setEditable(false);
        researcher_name_field_update.setEditable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        notifications_list = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        unsigned_projects_list = new javax.swing.JList<>();
        refresh_button = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        project_name_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        researcher_name_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date_of_creation_field = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        comments_field = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        download_excel_button = new javax.swing.JButton();
        export_to_pdf_button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        project_name_field_Update = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        researcher_name_field_update = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        date_of_creation_field_update = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        comments_field_update = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        sign_project_button = new javax.swing.JButton();
        help_button = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        sign_in_details = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        change_password_button = new javax.swing.JMenuItem();
        change_sig_image_button = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));

        notifications_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(notifications_list);

        jTabbedPane5.addTab("Notifications", jScrollPane6);

        unsigned_projects_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        unsigned_projects_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unsigned_projects_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(unsigned_projects_list);

        jTabbedPane5.addTab("Unsigned Projects", jScrollPane1);

        refresh_button.setText("Refresh Lists");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Project Name");

        project_name_field.setText("Project Name");
        project_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                project_name_fieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Researcher");

        researcher_name_field.setText("Researcher Name");
        researcher_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcher_name_fieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Date of Creation");

        date_of_creation_field.setText("Date of Creation");

        comments_field.setColumns(20);
        comments_field.setRows(5);
        jScrollPane4.setViewportView(comments_field);

        jLabel6.setText("Comments");

        download_excel_button.setText("Download Current Excel");
        download_excel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download_excel_buttonActionPerformed(evt);
            }
        });

        export_to_pdf_button.setText("Export Project Data to PDF");
        export_to_pdf_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_to_pdf_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(project_name_field, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(researcher_name_field)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_of_creation_field))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(212, 212, 212))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(export_to_pdf_button, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(download_excel_button)
                                .addGap(26, 26, 26))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(project_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(researcher_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(date_of_creation_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(download_excel_button)
                        .addGap(29, 29, 29)
                        .addComponent(export_to_pdf_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Project Data", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Project Name");

        project_name_field_Update.setText("Project Name");
        project_name_field_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                project_name_field_UpdateActionPerformed(evt);
            }
        });

        jLabel9.setText("Researcher");

        researcher_name_field_update.setText("Researcher Name");
        researcher_name_field_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcher_name_field_updateActionPerformed(evt);
            }
        });

        jLabel10.setText("Date of Creation");

        date_of_creation_field_update.setText("Date of Creation");

        comments_field_update.setColumns(20);
        comments_field_update.setRows(5);
        jScrollPane5.setViewportView(comments_field_update);

        jLabel11.setText("Comments");

        sign_project_button.setText("Sign Project");
        sign_project_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_project_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(project_name_field_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(researcher_name_field_update)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_of_creation_field_update))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(450, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addGap(29, 29, 29)
                        .addComponent(sign_project_button, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(project_name_field_Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(researcher_name_field_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_of_creation_field_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sign_project_button, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sign Project", jPanel1);

        help_button.setText("Help");

        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        sign_in_details.setText("Signed in as: Dean");

        jMenu1.setText("File");

        change_password_button.setText("Change Password");
        jMenu1.add(change_password_button);

        change_sig_image_button.setText("Change Signature Image");
        change_sig_image_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_sig_image_buttonActionPerformed(evt);
            }
        });
        jMenu1.add(change_sig_image_button);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(refresh_button)
                .addGap(98, 98, 98)
                .addComponent(help_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sign_in_details))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sign_in_details)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(help_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void project_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_project_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_project_name_fieldActionPerformed

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        getDataForUnsignedProjectsList();
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void researcher_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_researcher_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_researcher_name_fieldActionPerformed

    private void download_excel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_download_excel_buttonActionPerformed
       // add ability to download excel file
        if (SelectedID == null){
            JOptionPane.showMessageDialog(warningWindow, "No project selected, select one before signing.", "No Selected Project", WARNING_MESSAGE);
        }
        else{
            downloadExcel();
        }
    }//GEN-LAST:event_download_excel_buttonActionPerformed

    private void export_to_pdf_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_to_pdf_buttonActionPerformed
       //initilize pdf export
        if (SelectedID == null){
            JOptionPane.showMessageDialog(warningWindow, "No project selected, select one before exporting.", "No Selected Project", WARNING_MESSAGE);
        }
        else
        {

            PrintHandler newPDF = new PrintHandler();
            try {

                newPDF.getNewResultSet(SelectedID);
            } catch (SQLException ex) {
                Logger.getLogger(RISView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_export_to_pdf_buttonActionPerformed

    private void project_name_field_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_project_name_field_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_project_name_field_UpdateActionPerformed

    private void researcher_name_field_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_researcher_name_field_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_researcher_name_field_updateActionPerformed

    private void sign_project_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_project_buttonActionPerformed
        ///adding ability to sign document

        if (SelectedID == null){
            JOptionPane.showMessageDialog(warningWindow, "No project selected, select one before signing.", "No Selected Project", WARNING_MESSAGE);
        }
        else{
            sign_button_clicked = true;

            try {
                getSelectedProjectDetails();
            } catch (SQLException ex) {
                Logger.getLogger(DeanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sign_project_buttonActionPerformed

    private void unsigned_projects_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unsigned_projects_listMouseClicked
        try {
            selected = unsigned_projects_list.getSelectedValue();
            getSelectedProjectDetails();
        } catch (SQLException ex) {
            Logger.getLogger(DeanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_unsigned_projects_listMouseClicked

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        DeanView.this.dispose();
        StartScreen startScreen = new StartScreen();
        startScreen.setLocationRelativeTo(null);
        startScreen.setVisible(true);
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void change_sig_image_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_sig_image_buttonActionPerformed
        // TODO add your handling code here:
        File file =  fh.imageSelect();
        Boolean success = fh.uploadSignature(new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2017-agileteam8\\Signatures"), file, staffID);
    }//GEN-LAST:event_change_sig_image_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(DeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeanView().setVisible(true);
            }
        });
    }
    
    
     private void getDataForUnsignedProjectsList()
    {
        
        DefaultListModel listProgress = new DefaultListModel();
        ResultSet rs2 = connection.getProjects();
        try {
            while (rs2.next()) {
                
                //getting projects to display that only associate dean needs to see.
                if (rs2.getString("depDean_sig").equals("1") && rs2.getString("dean_sig").equals("0"))
                    {
                    //add to list in here 
                   // listProgress.addElement(rs2.getString("id") + "\n\n " + rs2.getString("name") + " .--->      Signed by:  Researcher: " + rs2.getString("researcher_sig") + " RIS: " +rs2.getString("ris_sig") + " Associate Dean: " + rs2.getString("depDean_sig") + " Dean: " + rs2.getString("dean_sig"));
                        listProgress.addElement("ID: "+ rs2.getString("id") + "       Project Name:   "+ rs2.getString("name") + ".");
                    
                    } else {
                    
                    //cry
                    
                    }
             
                }
            } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
   
        //setting list model to listProgress
        unsigned_projects_list.setModel(listProgress);
        
        
    }
     
     private void getSelectedProjectDetails() throws SQLException
    {
        boolean researcherSig_bool;
        boolean risSig_bool;
        boolean assoSig_bool;
        boolean deanSig_bool;
        
        //get id of selected list element
        
       
        String s = selected.split(" ")[1];
        
        SelectedID = s;
        System.out.println(s);
        
        
        ResultSet selectedProjectResultSet = connection.getProject(s); 
        
        selectedProjectResultSet.next();
        String id = selectedProjectResultSet.getString("id");
        String projectName = selectedProjectResultSet.getString("name");
        String researcher = selectedProjectResultSet.getString("researcher");
        String dateBox = selectedProjectResultSet.getDate("date").toString();
        downloadURL = selectedProjectResultSet.getString("file_path");
        String comments = selectedProjectResultSet.getString("comments");
        String researcherSig = selectedProjectResultSet.getString("researcher_Sig");
        String risSig = selectedProjectResultSet.getString("ris_Sig");
        String depDeanSig = selectedProjectResultSet.getString("depDean_Sig");
        String deanSig = selectedProjectResultSet.getString("dean_Sig");
        String signedResearcher = selectedProjectResultSet.getString("signed_researcher_id");
        String signedRis = selectedProjectResultSet.getString("signed_ris_id");
        String signedAssoDean = selectedProjectResultSet.getString("signed_assodean_id");
        String signedDean = selectedProjectResultSet.getString("signed_dean_id");
        
        project_name_field.setText(projectName);
        project_name_field_Update.setText(projectName);
        researcher_name_field.setText(researcher);
        researcher_name_field_update.setText(researcher);
        date_of_creation_field.setText(dateBox);
        date_of_creation_field_update.setText(dateBox);
        //download_txtbox.setText(downloadURL);
        comments_field_update.setText(comments);
        comments_field.setText(comments);
        
         //convert signatures to boolean
            researcherSig_bool = researcherSig.equals("1");
            risSig_bool = risSig.equals("1");
            assoSig_bool = depDeanSig.equals("1");
            deanSig_bool = deanSig.equals("1");
        
        
        if (sign_button_clicked == true){
            
            
            if (deanSig_bool == false) {
            //change associsate dean signature to true
            
            //does some nice validation with a are u sure box
            
            int reply = JOptionPane.showConfirmDialog(null, "This action will sign the currently selected project. Are you sure?", "warning", JOptionPane.YES_NO_OPTION);
            
            if (reply == JOptionPane.YES_OPTION) {
  
            
            deanSig_bool = true;
            signedDean = staffIDString;
            
            System.out.println(researcherSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(risSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(assoSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(deanSig_bool + "   <<<<<<<<<<<< sig");
            
            
            connection.editProject(id, projectName, comments, researcherSig_bool, risSig_bool, assoSig_bool, deanSig_bool, signedResearcher, signedRis, signedAssoDean, signedDean);
            
            getDataForUnsignedProjectsList();
        }
            }
            else
            {
                JOptionPane.showMessageDialog(warningWindow, "This Project cannot be signed. it is signed by the Dean", "ALREADY SIGNED", WARNING_MESSAGE);
            }
        }
        
        
        sign_button_clicked = false;
        
        
        //refresh the list of valid projects
        
        
    }
     
     private void downloadExcel(){
        
        fh.downloadFile(new File(downloadURL));
    }
     
     public void getDetailsOnActiveLogin() throws SQLException{
    
        rs = connection.getUserByStaffID(staffID);
        rs.next();
        
        String firstname = rs.getString("FirstName");
        String lastName = rs.getString("LastName");
        
        fullName = firstname + " " + lastName;
        
        System.out.println(fullName + " <<>>");   
        //getDataForList();
    }
     
     /**
      * 
      * @param idno
      * @return 
      */
     public int getStaffID(int idno)
     {
         staffID = idno;
         staffIDString = Integer.toString(staffID);
         System.out.println(staffID);
         return idno;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem change_password_button;
    private javax.swing.JMenuItem change_sig_image_button;
    private javax.swing.JTextArea comments_field;
    private javax.swing.JTextArea comments_field_update;
    private javax.swing.JTextField date_of_creation_field;
    private javax.swing.JTextField date_of_creation_field_update;
    private javax.swing.JButton download_excel_button;
    private javax.swing.JButton export_to_pdf_button;
    private javax.swing.JButton help_button;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JButton logout_button;
    private javax.swing.JList<String> notifications_list;
    private javax.swing.JTextField project_name_field;
    private javax.swing.JTextField project_name_field_Update;
    private javax.swing.JButton refresh_button;
    private javax.swing.JTextField researcher_name_field;
    private javax.swing.JTextField researcher_name_field_update;
    private javax.swing.JLabel sign_in_details;
    private javax.swing.JButton sign_project_button;
    private javax.swing.JList<String> unsigned_projects_list;
    // End of variables declaration//GEN-END:variables
}
