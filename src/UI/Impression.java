package UI;

import java.awt.event.WindowAdapter;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Impression extends javax.swing.JFrame {

    private ArrayList<FicheDeSoins> listeFiche;
    private String identifiant;
    private String statut;

    /**
     * Creates new form Impression
     */
    public Impression(ArrayList<FicheDeSoins> listeFiche, String identifiant, String statut) {
        initComponents();
        this.setTitle("Impression");
        this.setLocationRelativeTo(null);
        this.listeFiche = listeFiche;
        this.identifiant = identifiant;
        this.statut = statut;
        zoneImpression.setEditable(false);
        String s = "                 FICHES DE SOINS" + "\n" + "\n";
        if (this.statut.equals("SecAdm")) {
            for (int i = 0; i < listeFiche.size(); i++) {
                s += this.listeFiche.get(i).afficherPourImpressionFacture();
                s += "---------------------------------------------------------------------------------------------"
                        + "\n";
            }
        } else {
            for (int i = 0; i < listeFiche.size(); i++) {
                s += this.listeFiche.get(i).afficherPourImpression();
                s += "---------------------------------------------------------------------------------------------"
                        + "\n";
            }
        }
        s += "\n" + "Ecrit par " + this.identifiant;
        zoneImpression.setText(s);
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
        jPanel2 = new javax.swing.JPanel();
        jButtonImprimer = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        zoneImpression = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(200, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 50));

        jButtonImprimer.setText("Imprimer");
        jButtonImprimer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimerActionPerformed(evt);
            }
        });

        jButton2.setText("Annuler");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Bernard MT Condensed", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("Processir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(jButtonImprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImprimer)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        zoneImpression.setColumns(20);
        zoneImpression.setRows(5);
        zoneImpression.setMinimumSize(new java.awt.Dimension(200, 22));
        zoneImpression.setPreferredSize(new java.awt.Dimension(300, 94));
        jScrollPane1.setViewportView(zoneImpression);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimerActionPerformed
        try {
            zoneImpression.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Impression.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonImprimerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonImprimer;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea zoneImpression;
    // End of variables declaration//GEN-END:variables
}
