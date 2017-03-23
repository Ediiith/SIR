/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import NF.DMR;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.awt.Desktop;

/**
 *
 * @author JEMCare Solution
 */

public class AfficherDMR extends javax.swing.JFrame {

    /**
     * Creates new form affichageFiche
     */
    private DMR dmr;

    public AfficherDMR(DMR dmr) {
        initComponents();
        this.dmr = dmr;
        zoneAffichage.setText(this.dmr.afficherDMR());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        RetourArrière = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButtonImprimer1 = new javax.swing.JButton();
        aide = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        zoneAffichage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 50));

        RetourArrière.setText("Fermer");
        RetourArrière.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourArrièreActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Bernard MT Condensed", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("Processir");

        jButtonImprimer1.setText("Imprimer");
        jButtonImprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimer1ActionPerformed(evt);
            }
        });

        aide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/image/Aide-SZ-icon.png"))); // NOI18N
        aide.setToolTipText("Aide");
        aide.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        aide.setMaximumSize(new java.awt.Dimension(30, 30));
        aide.setMinimumSize(new java.awt.Dimension(30, 30));
        aide.setPreferredSize(new java.awt.Dimension(30, 30));
        aide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aideMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(aide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonImprimer1)
                .addGap(53, 53, 53)
                .addComponent(RetourArrière)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RetourArrière)
                        .addComponent(jButtonImprimer1)))
                .addContainerGap())
        );

        zoneAffichage.setColumns(20);
        zoneAffichage.setRows(5);
        jScrollPane1.setViewportView(zoneAffichage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetourArrièreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourArrièreActionPerformed
        this.dispose();
    }//GEN-LAST:event_RetourArrièreActionPerformed

    private void jButtonImprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimer1ActionPerformed
        try {
            zoneAffichage.print();
        } catch (PrinterException ex) {
            Logger.getLogger(AfficherCR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonImprimer1ActionPerformed

    private void aideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aideMousePressed
        try {
            File f = new File("ManuelUtilisation.pdf");
            FileUtils.copyURLToFile(PageDeConnexion.class.getResource("ManuelUtilisation.pdf"), f);
            Desktop d = Desktop.getDesktop();
            d.open(f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur d'ouverture du manuel, veuillez contacter le service maintenance");
        }    }//GEN-LAST:event_aideMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RetourArrière;
    private javax.swing.JLabel aide;
    private javax.swing.JButton jButtonImprimer1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea zoneAffichage;
    // End of variables declaration//GEN-END:variables
}
