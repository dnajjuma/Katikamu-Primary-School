package UserSetting;

import SomeFunctions.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserSetting extends javax.swing.JFrame {

   
    public UserSetting() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccount = new javax.swing.JTable();
        jButtonLO = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableAccount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Password", "LoginAs"
            }
        ));
        jTableAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableAccount.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTableAccount.setRowHeight(25);
        jScrollPane1.setViewportView(jTableAccount);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 470, 170));

        jButtonLO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLO.setText("LOG OUT");
        jButtonLO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLOActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 40));

        jButtonNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNew.setText("New Accout");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 120, 40));

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDelete.setText("Delete Accout");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 130, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 90, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/lock.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User Setting");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 280, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultTableModel modele = (DefaultTableModel) jTableAccount.getModel();
        String Query = "SELECT userName, userpassword, loginAs FROM login";
        PreparedStatement ps;
        ResultSet rs;
        try{
        ps = MyConnection.getConnection().prepareStatement(Query);
        rs = ps.executeQuery();
        while(rs.next()){
            Object o[] = {rs.getString("userName"),
                          rs.getString("userpassword"),
                          rs.getString("loginAs")};
            if(jTableAccount.getRowCount()!= getRowNumber())    
            modele.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"SomeThing Went Wrong Please Try Later!");
        }
    }//GEN-LAST:event_formWindowOpened

    public int getRowNumber(){

    int numberRow = 0;
    PreparedStatement ps;
    ResultSet rs;
    String query = "select count(*) from login";
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                numberRow = rs.getInt("count(*)");
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error ");
        }
    return numberRow;
}
    
    
    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed

        Admin admin = new Admin();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if(jTableAccount.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Please Select A user to be deleted!");
        }else{
        DefaultTableModel modele = (DefaultTableModel) jTableAccount.getModel();
        String UserName = jTableAccount.getValueAt(jTableAccount.getSelectedRow(), 0).toString();
        String Query = "DELETE FROM login WHERE(userName ="+'"'+UserName+'"'+")";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = MyConnection.getConnection().prepareStatement(Query);
            ps.executeUpdate();
            modele.removeRow(jTableAccount.getSelectedRow());
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can Not Delete At this Moment! Try Later"+e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonLOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLOActionPerformed

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
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSetting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSetting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonLO;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAccount;
    // End of variables declaration//GEN-END:variables
}
