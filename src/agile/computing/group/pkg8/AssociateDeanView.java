/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agile.computing.group.pkg8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;


/**
 *
 * @author Ryan
 */
public class AssociateDeanView extends javax.swing.JFrame {
    
    
    JOptionPane warningWindow = new JOptionPane();
    
    DBConnection connection;
    String selected;
    String host = "silva.computing.dundee.ac.uk";
    String db = "17agileteam8db";
    String username = "17agileteam8";
    String password = "7632.at8.2367";
    String SelectedID;
    boolean sign_button_clicked = false;
    
    
    /**
     * Creates new form AssociateDeanView
     */
    public AssociateDeanView() {
        initComponents();
        connection = new DBConnection(host,db,username,password);
        getDataForList();
    }
    
    public AssociateDeanView(DBConnection dbconnect){
        initComponents();
        //connection = dbconnect;
        //getDataForList();
    }
    
    
    private void getDataForList()
    {
        
        DefaultListModel listProgress = new DefaultListModel();
        ResultSet rs2 = connection.getProjects();
        try {
            while (rs2.next()) {
                
                //getting projects to display that only associate dean needs to see.
                if (rs2.getString("ris_sig").equals("1") && rs2.getString("dean_sig").equals("0"))
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
        projects_List.setModel(listProgress);
        
        
    }
    
    
    
    private void getSelectedProjectDetails() throws SQLException
    {
        boolean researcherSig_bool;
        boolean risSig_bool;
        boolean assoSig_bool;
        boolean deanSig_bool;
        
        selected = projects_List.getSelectedValue();
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
        String downloadURL = selectedProjectResultSet.getString("file_path");
        String comments = selectedProjectResultSet.getString("comments");
        String researcherSig = selectedProjectResultSet.getString("researcher_Sig");
        String risSig = selectedProjectResultSet.getString("ris_Sig");
        String depDeanSig = selectedProjectResultSet.getString("depDean_Sig");
        String deanSig = selectedProjectResultSet.getString("dean_Sig");
        
        projectName_txtbox.setText(projectName);
        
        researcher_txtbox.setText(researcher);
        date_txtbox.setText(dateBox);
        download_txtbox.setText(downloadURL);
        comments_txtbox.setText(comments);
        
        
        if (sign_button_clicked == true){
            
            
            
            //change associsate dean signature to true
            
            //does some nice validation with a are u sure box
            
            
            
            //convert signatures to boolean
            researcherSig_bool = researcherSig.equals("1");
            risSig_bool = risSig.equals("1");
            assoSig_bool = depDeanSig.equals("1");
            deanSig_bool = deanSig.equals("1");
            
            assoSig_bool = true;
            
            System.out.println(researcherSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(risSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(assoSig_bool + "   <<<<<<<<<<<< sig");
            System.out.println(deanSig_bool + "   <<<<<<<<<<<< sig");
            
            
            connection.editProject(id, projectName, comments, researcherSig_bool, risSig_bool, assoSig_bool, deanSig_bool);
            
            sign_button_clicked = false;
        }
        
        
        
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        projects_List = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        projectName_txtbox = new javax.swing.JTextField();
        researcher_txtbox = new javax.swing.JTextField();
        date_txtbox = new javax.swing.JTextField();
        download_txtbox = new javax.swing.JTextField();
        comments_txtbox = new javax.swing.JTextField();
        export_PDF_btn = new javax.swing.JButton();
        sign_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        projects_List.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        projects_List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        projects_List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projects_List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projects_ListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(projects_List);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Active projects to be reviewed - ");

        jLabel6.setText("Comments: ");

        jLabel2.setText("Project Name: ");

        jLabel4.setText("Creation Date:");

        jLabel3.setText("Researcher: ");

        jLabel5.setText("Download URL:");

        projectName_txtbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectName_txtboxActionPerformed(evt);
            }
        });

        export_PDF_btn.setText("Export PDF");
        export_PDF_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                export_PDF_btnMouseClicked(evt);
            }
        });

        sign_button.setBackground(new java.awt.Color(0, 102, 51));
        sign_button.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 12)); // NOI18N
        sign_button.setText("Sign Selected Project");
        sign_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sign_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sign_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(360, 360, 360))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(researcher_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(projectName_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comments_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(download_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addComponent(export_PDF_btn)
                        .addGap(149, 149, 149)
                        .addComponent(sign_button)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(projectName_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(researcher_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(date_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(download_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(export_PDF_btn)
                    .addComponent(sign_button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comments_txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projects_ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projects_ListMouseClicked
        try {
            // TODO add your handling code here:

            getSelectedProjectDetails();
        } catch (SQLException ex) {
            Logger.getLogger(AssociateDeanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_projects_ListMouseClicked

    private void projectName_txtboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectName_txtboxActionPerformed
        
    }//GEN-LAST:event_projectName_txtboxActionPerformed

    private void export_PDF_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_PDF_btnMouseClicked
        
        //initilize pdf export 
        if (SelectedID == null){
                JOptionPane.showMessageDialog(warningWindow, "No project selected, select one before exporting.", "No Selected Project", WARNING_MESSAGE);
        }
        else
        {

           GUI newGUI_PDF = new GUI();
            try {
           
                newGUI_PDF.getNewResultSet(SelectedID);
            } catch (SQLException ex) {
                Logger.getLogger(AssociateDeanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_export_PDF_btnMouseClicked

   
    private void sign_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sign_buttonMouseClicked
        ///adding ability to sign document
        
        if (SelectedID == null){
                JOptionPane.showMessageDialog(warningWindow, "No project selected, select one before signing.", "No Selected Project", WARNING_MESSAGE);
        }
        else{
            sign_button_clicked = true;
        
            try {
                getSelectedProjectDetails();
            } catch (SQLException ex) {
                Logger.getLogger(AssociateDeanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_sign_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(AssociateDeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssociateDeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssociateDeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssociateDeanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AssociateDeanView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField comments_txtbox;
    private javax.swing.JTextField date_txtbox;
    private javax.swing.JTextField download_txtbox;
    private javax.swing.JButton export_PDF_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField projectName_txtbox;
    private javax.swing.JList<String> projects_List;
    private javax.swing.JTextField researcher_txtbox;
    private javax.swing.JButton sign_button;
    // End of variables declaration//GEN-END:variables
}
