
package gui;

import Oracle.OracleConnector;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private Connection conn;

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldPrihlasovaciJmeno = new javax.swing.JTextField();
        jPasswordHeslo = new javax.swing.JPasswordField();
        jButtonPrihlasitSe = new javax.swing.JButton();
        jButtonRegistrovatSe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Přihlašovací okno aplikace");
        setMinimumSize(new java.awt.Dimension(100, 50));
        setSize(new java.awt.Dimension(200, 150));
        getContentPane().setLayout(new java.awt.GridLayout(4, 0, 10, 5));

        jTextFieldPrihlasovaciJmeno.setBorder(javax.swing.BorderFactory.createTitledBorder("Přihlašovací jméno:"));
        jTextFieldPrihlasovaciJmeno.setName(""); // NOI18N
        jTextFieldPrihlasovaciJmeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrihlasovaciJmenoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPrihlasovaciJmeno);

        jPasswordHeslo.setBorder(javax.swing.BorderFactory.createTitledBorder("Heslo:"));
        getContentPane().add(jPasswordHeslo);

        jButtonPrihlasitSe.setText("Přihlásit se");
        jButtonPrihlasitSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrihlasitSeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPrihlasitSe);

        jButtonRegistrovatSe.setText("Registrovat se");
        jButtonRegistrovatSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrovatSeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrovatSe);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrihlasitSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrihlasitSeActionPerformed
        String username = "";
        char[] pass;
        username = jTextFieldPrihlasovaciJmeno.getText();
        pass = jPasswordHeslo.getPassword();
        String serverName = "fei-sql1.upceucebny.cz";
        
        String hesloS = "";
        
        for(int i = 0; i < pass.length;i++)
        {
            hesloS = hesloS + "" + pass[i];
        }
        
        try{
           OracleConnector.setUpConnection(serverName, 1521, "idas12", "C##"+username,hesloS);
           conn = OracleConnector.getConnection();
           new Aplikace().setVisible(true);
           hesloS = null;
           this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Přihlášení se nezdařilo.");
        }
        
    }//GEN-LAST:event_jButtonPrihlasitSeActionPerformed

    private void jTextFieldPrihlasovaciJmenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrihlasovaciJmenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrihlasovaciJmenoActionPerformed

    private void jButtonRegistrovatSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrovatSeActionPerformed
        new Registrace().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegistrovatSeActionPerformed

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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrihlasitSe;
    private javax.swing.JButton jButtonRegistrovatSe;
    private javax.swing.JPasswordField jPasswordHeslo;
    private javax.swing.JTextField jTextFieldPrihlasovaciJmeno;
    // End of variables declaration//GEN-END:variables
}
