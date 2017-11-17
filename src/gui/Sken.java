/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author tova0210
 */
public class Sken extends javax.swing.JFrame {

    private Image image = null;
    private Connection conn;
    private int idSkenu;
    /**
     * Creates new form NewJFrame
     * @param idSkenu ID skenu který chceme vykreslit
     */
    public Sken(int idSkenu) {
        initComponents();
        this.idSkenu = idSkenu;
        try {
            conn = Oracle.OracleConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Sken.class.getName()).log(Level.SEVERE, null, ex);
        }
        zobrazitSken(idSkenu);
    }

    private Sken() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPridatSken = new javax.swing.JButton();
        jPanelVykreslovaciOkno = new javax.swing.JPanel();
        jButtonVymazSken = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sken knihy");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jButtonPridatSken.setText("Přidat sken");
        jButtonPridatSken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPridatSkenActionPerformed(evt);
            }
        });

        jPanelVykreslovaciOkno.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jPanelVykreslovaciOknoAncestorResized(evt);
            }
        });

        javax.swing.GroupLayout jPanelVykreslovaciOknoLayout = new javax.swing.GroupLayout(jPanelVykreslovaciOkno);
        jPanelVykreslovaciOkno.setLayout(jPanelVykreslovaciOknoLayout);
        jPanelVykreslovaciOknoLayout.setHorizontalGroup(
            jPanelVykreslovaciOknoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        jPanelVykreslovaciOknoLayout.setVerticalGroup(
            jPanelVykreslovaciOknoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonVymazSken.setText("Vymaž sken");
        jButtonVymazSken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVymazSkenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelVykreslovaciOkno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPridatSken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVymazSken, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPridatSken)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVymazSken)
                        .addGap(0, 221, Short.MAX_VALUE))
                    .addComponent(jPanelVykreslovaciOkno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPridatSkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPridatSkenActionPerformed

        PreparedStatement ps = null;
        String insert = "UPDATE C##ST49620.SEM_SKENY SET Sken=? WHERE ID_SKENU = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(insert);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                   return (f.isFile() || f.isDirectory()) && (f.getName().toLowerCase().endsWith(".jpg")
                           || f.getName().toLowerCase().endsWith(".png")
                           || f.getName().toLowerCase().endsWith(".bmp")
                           || f.getName().toLowerCase().endsWith(".jpeg")
                           || f.getName().toLowerCase().endsWith(".gif")
                           || f.isDirectory());
                }

                @Override
                public String getDescription() {
                    return "Filtr obrázků";
                }
            });
            fileChooser.showOpenDialog(this);
            
            File file = fileChooser.getSelectedFile();
            if(file!=null)
            {
                InputStream is = new FileInputStream(file);
                ps.setBinaryStream(1, is, file.length());
                ps.setInt(2, idSkenu);
                ps.executeUpdate();
            
                conn.commit();
            }

        } catch (SQLException ex) {
            System.err.println(ex.getLocalizedMessage());
            if(conn!=null)
            {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Sken.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sken.class.getName()).log(Level.SEVERE, null, ex);
        }
        zobrazitSken(idSkenu);
        vykresliObrazek(image);

    }//GEN-LAST:event_jButtonPridatSkenActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        
    }//GEN-LAST:event_formComponentResized

    private void jPanelVykreslovaciOknoAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jPanelVykreslovaciOknoAncestorResized
       if(image!=null)
        {
            vykresliObrazek(image);
        }
    }//GEN-LAST:event_jPanelVykreslovaciOknoAncestorResized

    private void jButtonVymazSkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVymazSkenActionPerformed
        String deleteSQL = "";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(deleteSQL);
            ps.executeUpdate();
            conn.commit();
            
        }catch(SQLException | NumberFormatException ex)
        {
            Logger.getLogger(Sken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVymazSkenActionPerformed

    private void zobrazitSken(int idSkenu){
        
        PreparedStatement ps = null;
        String select = "SELECT Sken FROM C##ST49620.SEM_SKENY"
                + " WHERE ID_skenu = ?";
        try {
            ps = conn.prepareStatement(select);
            ps.setInt(1, idSkenu);
            ResultSet rs = ps.executeQuery();

            Blob blob = conn.createBlob();
            while (rs.next()) {
                blob = rs.getBlob("Sken");
            }

            InputStream is = blob.getBinaryStream();
            image = ImageIO.read(is);

            vykresliObrazek(image);
            
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Sken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void vykresliObrazek(Image obrazek)
    {
        
        try {
            float widthPomer;
            float heightPomer;
            int x;
            int y;
            float pomer;
        
            // Poměr šířky okna ku obrázku
            widthPomer = jPanelVykreslovaciOkno.getWidth() / (float) obrazek.getWidth(null); 
                    
            // Poměr výšky okna ku obrázku
            heightPomer = jPanelVykreslovaciOkno.getHeight() / (float) obrazek.getHeight(null); 
                    
            // Math.min() vrací nejmenší z čísel
            pomer = Math.min(heightPomer, widthPomer); 
                    
            x=Math.round(pomer * obrazek.getWidth(null)); 
            y=Math.round(pomer * obrazek.getHeight(null));
            
            jPanelVykreslovaciOkno.update(jPanelVykreslovaciOkno.getGraphics());
            jPanelVykreslovaciOkno.getGraphics().drawImage(obrazek, 0 ,0 ,x ,y, this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tento objekt nelze vykreslit.");
        }
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
            java.util.logging.Logger.getLogger(Sken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sken().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPridatSken;
    private javax.swing.JButton jButtonVymazSken;
    private javax.swing.JPanel jPanelVykreslovaciOkno;
    // End of variables declaration//GEN-END:variables
}
