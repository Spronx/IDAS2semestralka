/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author User
 */
public class Registrace extends javax.swing.JFrame {

    /**
     * Creates new form Registrace
     */
    public Registrace() {
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

        jPasswordField2 = new javax.swing.JPasswordField();
        jTextFieldPrihlasovaciJmeno = new javax.swing.JTextField();
        jPasswordFieldHeslo = new javax.swing.JPasswordField();
        jPasswordHesloZnovu = new javax.swing.JPasswordField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldJmeno = new javax.swing.JTextField();
        jTextFieldPrijmeni = new javax.swing.JTextField();
        jTextFieldTelefon = new javax.swing.JTextField();
        jButtonRegistrovat = new javax.swing.JButton();

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(8, 1));

        jTextFieldPrihlasovaciJmeno.setBorder(javax.swing.BorderFactory.createTitledBorder("Přihlašovací jméno:"));
        getContentPane().add(jTextFieldPrihlasovaciJmeno);

        jPasswordFieldHeslo.setBorder(javax.swing.BorderFactory.createTitledBorder("Heslo:"));
        getContentPane().add(jPasswordFieldHeslo);

        jPasswordHesloZnovu.setBorder(javax.swing.BorderFactory.createTitledBorder("Heslo ještě jednou:"));
        getContentPane().add(jPasswordHesloZnovu);

        jTextFieldEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        getContentPane().add(jTextFieldEmail);

        jTextFieldJmeno.setBorder(javax.swing.BorderFactory.createTitledBorder("Jméno:"));
        getContentPane().add(jTextFieldJmeno);

        jTextFieldPrijmeni.setBorder(javax.swing.BorderFactory.createTitledBorder("Příjmení:"));
        getContentPane().add(jTextFieldPrijmeni);

        jTextFieldTelefon.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefonní číslo:"));
        getContentPane().add(jTextFieldTelefon);

        jButtonRegistrovat.setText("Registrovat se");
        getContentPane().add(jButtonRegistrovat);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Registrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrovat;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordFieldHeslo;
    private javax.swing.JPasswordField jPasswordHesloZnovu;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldJmeno;
    private javax.swing.JTextField jTextFieldPrihlasovaciJmeno;
    private javax.swing.JTextField jTextFieldPrijmeni;
    private javax.swing.JTextField jTextFieldTelefon;
    // End of variables declaration//GEN-END:variables
}
