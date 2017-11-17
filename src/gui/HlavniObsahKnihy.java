
package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class HlavniObsahKnihy extends javax.swing.JPanel {

    Connection conn;
    
    public HlavniObsahKnihy() {
        initComponents();
        myInit();
    }
    
    private void myInit(){
         
        try {
            conn = Oracle.OracleConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(HlavniObsahKnihy.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();
        JOptionPane.showMessageDialog(this, Oracle.OracleConnector.getConnectionString());
        
        jTableObsah.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
            if(jTableObsah.getSelectedRow() > -1){
                 jTextFieldIDKnihy.setText(jTableObsah.getValueAt( jTableObsah.getSelectedRow(), 0).toString());
                 jTextFieldNazev.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),1).toString());
                 jTextFieldSignatura.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),2).toString());
                 jTextFieldCarovyKod.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),3).toString());
                 jTextFieldMistoVydani.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),4).toString());
                 jTextFieldPopis.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),5).toString());
                 jTextFieldRokVydani.setText(jTableObsah.getValueAt(jTableObsah.getSelectedRow(),6).toString());
            }
        });
    }
    
     private void refresh() {
        try {
            String str = jTextFieldVyhledavani.getText();
            String selectSQL = "SELECT ID_Kniha, Nazev, Signatura, Carovy_kod, Misto_vydani, Popis, "
                    + "Rok_vydani FROM C##ST49620.SEM_KNIHY "
                    + "where (LOWER(Nazev) LIKE LOWER(?) or LOWER(Signatura) LIKE LOWER(?)"
                    + "or LOWER(Carovy_kod) LIKE LOWER(?) "
                    + "or LOWER(Misto_vydani) LIKE LOWER(?) "
                    + "or LOWER(popis) LIKE LOWER(?) "
                    + "or LOWER(Rok_vydani) LIKE LOWER(?))";
            PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
            preparedStatement.setString(1, "%" + str + "%");
            preparedStatement.setString(2, "%" + str + "%");
            preparedStatement.setString(3, "%" + str + "str");
            preparedStatement.setString(4, "%" + str + "%");
            preparedStatement.setString(5, "%" + str + "%");
            preparedStatement.setString(6, "%" + str + "%");
            
            ResultSet rset = preparedStatement.executeQuery();

            String[] sloupce = {"ID","Název knihy", "Signatura", "Čárový kód", "Místo vydání", "Popis", "Rok vydání"};
            DefaultTableModel model = new DefaultTableModel(sloupce, 0);
            jTableObsah.setModel(model);
            while (rset.next()) {
                int id = rset.getInt("ID_Kniha");
                String jmeno = rset.getString("Nazev");
                String signatura = rset.getString("Signatura");
                int carovy_kod = rset.getInt("Carovy_kod");
                String misto_vydani = rset.getString("Misto_vydani");
                String popis = rset.getString("Popis");
                int rok_vydani = rset.getInt("Rok_vydani");

                Vector<Object> radek = new Vector<>();
                radek.add(id);
                radek.add(jmeno);
                radek.add(signatura);
                radek.add(carovy_kod);
                radek.add(misto_vydani);
                radek.add(popis);
                radek.add(rok_vydani);
                model.addRow(radek);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableObsah = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldIDKnihy = new javax.swing.JTextField();
        jTextFieldNazev = new javax.swing.JTextField();
        jTextFieldSignatura = new javax.swing.JTextField();
        jTextFieldCarovyKod = new javax.swing.JTextField();
        jTextFieldMistoVydani = new javax.swing.JTextField();
        jTextFieldPopis = new javax.swing.JTextField();
        jTextFieldRokVydani = new javax.swing.JTextField();
        jButtonZobrazitSkenTitulni = new javax.swing.JButton();
        jButtonZobrazitSkenUvodni = new javax.swing.JButton();
        jButtonUpravit = new javax.swing.JButton();
        jButtonVymazat = new javax.swing.JButton();
        jTextFieldVyhledavani = new javax.swing.JTextField();
        jButtonVyhledat = new javax.swing.JButton();

        jTableObsah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableObsah);
        if (jTableObsah.getColumnModel().getColumnCount() > 0) {
            jTableObsah.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTableObsah.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTableObsah.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTableObsah.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jTextFieldIDKnihy.setBorder(javax.swing.BorderFactory.createTitledBorder("ID knihy:"));
        jPanel2.add(jTextFieldIDKnihy);

        jTextFieldNazev.setBorder(javax.swing.BorderFactory.createTitledBorder("Název:"));
        jPanel2.add(jTextFieldNazev);

        jTextFieldSignatura.setBorder(javax.swing.BorderFactory.createTitledBorder("Signatura:"));
        jPanel2.add(jTextFieldSignatura);

        jTextFieldCarovyKod.setBorder(javax.swing.BorderFactory.createTitledBorder("Čárový kód:"));
        jPanel2.add(jTextFieldCarovyKod);

        jTextFieldMistoVydani.setBorder(javax.swing.BorderFactory.createTitledBorder("Místo vydání: "));
        jPanel2.add(jTextFieldMistoVydani);

        jTextFieldPopis.setBorder(javax.swing.BorderFactory.createTitledBorder("Popis:"));
        jPanel2.add(jTextFieldPopis);

        jTextFieldRokVydani.setBorder(javax.swing.BorderFactory.createTitledBorder("Rok vydání: "));
        jPanel2.add(jTextFieldRokVydani);

        jButtonZobrazitSkenTitulni.setText("Zobrazit sken titulní strany");
        jButtonZobrazitSkenTitulni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZobrazitSkenTitulniActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonZobrazitSkenTitulni);

        jButtonZobrazitSkenUvodni.setText("Zobrazit sken úvodní strany");
        jPanel2.add(jButtonZobrazitSkenUvodni);

        jButtonUpravit.setText("Upravit");
        jPanel2.add(jButtonUpravit);

        jButtonVymazat.setText("Vymazat");
        jPanel2.add(jButtonVymazat);

        jButtonVyhledat.setText("Vyhledat");
        jButtonVyhledat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVyhledatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldVyhledavani)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVyhledat, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldVyhledavani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonVyhledat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVyhledatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVyhledatActionPerformed
        refresh();
    }//GEN-LAST:event_jButtonVyhledatActionPerformed

    private void jButtonZobrazitSkenTitulniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZobrazitSkenTitulniActionPerformed
         int idSkenu = -1;
        try {
            String selectSQL = "SELECT ID_skenu_uvodni FROM C##ST49620.SEM_KNIHY where ID_kniha=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
            preparedStatement.setInt(1, Integer.parseInt(jTextFieldIDKnihy.getText()));
            
            ResultSet rset = preparedStatement.executeQuery();

            while (rset.next()) {
                idSkenu = rset.getInt("ID_skenu_uvodni");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        Sken sken = new Sken(idSkenu);
        sken.setVisible(true);
        
    }//GEN-LAST:event_jButtonZobrazitSkenTitulniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUpravit;
    private javax.swing.JButton jButtonVyhledat;
    private javax.swing.JButton jButtonVymazat;
    private javax.swing.JButton jButtonZobrazitSkenTitulni;
    private javax.swing.JButton jButtonZobrazitSkenUvodni;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableObsah;
    private javax.swing.JTextField jTextFieldCarovyKod;
    private javax.swing.JTextField jTextFieldIDKnihy;
    private javax.swing.JTextField jTextFieldMistoVydani;
    private javax.swing.JTextField jTextFieldNazev;
    private javax.swing.JTextField jTextFieldPopis;
    private javax.swing.JTextField jTextFieldRokVydani;
    private javax.swing.JTextField jTextFieldSignatura;
    private javax.swing.JTextField jTextFieldVyhledavani;
    // End of variables declaration//GEN-END:variables
}
