
package com.deemababyfairtest.ui;

import com.deemababyfairtest.connecor.JavaConnect;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class Login extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;   
    public static String id;
    String password;
    
    
    public Login() throws SQLException {
        initComponents();
        conn = JavaConnect.ConnectorDb();
        fillId();
        setBackground(new Color(0,0,0,0));
        background.setBackground(new Color(0,0,0,0));
    }
public void fillId() throws SQLException{
        String sql = "SELECT `Emp_ID` FROM `employee` ";
        pst = conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
            String id = rs.getString("Emp_ID");
            jComboBox1.addItem(id);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        passwordTxt = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBounds(new java.awt.Rectangle(600, 450, 450, 450));
        setFocusTraversalPolicyProvider(true);
        setMaximizedBounds(new java.awt.Rectangle(600, 450, 450, 450));
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimize - light.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 10, 30, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close - light.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 10, 40, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login-button.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login-button-pressed.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(408, 283, 78, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 225, 200, 30);
        getContentPane().add(passwordTxt);
        passwordTxt.setBounds(200, 282, 200, 30);

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-bg.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(600, 450));
        background.setMinimumSize(new java.awt.Dimension(600, 450));
        background.setPreferredSize(new java.awt.Dimension(600, 450));
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundMousePressed(evt);
            }
        });
        getContentPane().add(background);
        background.setBounds(10, 11, 600, 384);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
      int pX,pY ; 
    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
      int x1,y1;
        
       x1 =this.getLocation().x + evt.getX()- pX;
       y1 =this.getLocation().y + evt.getY()- pY;
       this.setLocation(x1,y1);        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundMouseDragged

    private void backgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMousePressed
       pX=evt.getX();
       pY=evt.getY();
    }//GEN-LAST:event_backgroundMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed
  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setExtendedState(JFrame.ICONIFIED); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            String pass=null;
            int admin = 2;
            String sql1 = "select * from employee where Emp_ID like ?";
            pst = conn.prepareStatement(sql1);
            pst.setString(1, (String) jComboBox1.getSelectedItem());
            rs=pst.executeQuery();

            while (rs.next()){
                pass= rs.getString("Password");
                admin = Integer.parseInt(rs.getString("Is_A_Admin"));
            }

            if ( passwordTxt.getText().equals(pass) && admin == 1){
                id = (String) jComboBox1.getSelectedItem();
                AdminScreen ad = new AdminScreen();
                ad.setVisible(true);
                this.setVisible(false);
            }
            else if(passwordTxt.getText().equals(pass)){

                //System.out.println(pass);
                id = (String) jComboBox1.getSelectedItem();
                EmployeeScreen es = new EmployeeScreen();
                es.setVisible(true);
                this.setVisible(false);

            }else {
                JOptionPane.showMessageDialog(null, "Invalid Password", "", WARNING_MESSAGE);
            }
        } catch(SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPasswordField passwordTxt;
    // End of variables declaration//GEN-END:variables
}
