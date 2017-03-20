
package UI;

import NF.DMR;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;


public class Patient4 extends javax.swing.JFrame {

    private DMR dmr;
    public Patient4() {
        initComponents();
        this.setTitle("Patient4");
        this.setLocationRelativeTo(null);
        jLabelInfoPatient.setText(this.dmr.afficherInfoPatient());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        image = new javax.swing.JLabel();
        layoutbutton = new javax.swing.JPanel();
        Valider = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelInfoPatient = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Valider1 = new javax.swing.JButton();

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/princeton.png"))); // NOI18N
        image.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(image, java.awt.BorderLayout.EAST);

        layoutbutton.setBackground(new java.awt.Color(255, 255, 255));
        layoutbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));

        Valider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Valider.setText("Retour");
        Valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Processir");

        jLabelInfoPatient.setText("info patient");
        jLabelInfoPatient.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Voulez vous créer le dossier du patient ?");

        Valider1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Valider1.setText("Admission");
        Valider1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Valider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layoutbuttonLayout = new javax.swing.GroupLayout(layoutbutton);
        layoutbutton.setLayout(layoutbuttonLayout);
        layoutbuttonLayout.setHorizontalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabelInfoPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(Valider1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layoutbuttonLayout.setVerticalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelInfoPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Valider1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(layoutbutton, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        //------------identification a partir de la base de donnees

           /** PageAccueil accueil = new PageAccueil(li.getListeType().get(i), li.getListeIdentifiant().get(i), dm,
                    listePatient, listeFiche);
            accueil.setVisible(true);
            this.dispose();
        } else {
            System.out.println("error");
            javax.swing.JOptionPane.showMessageDialog(null, "mot de passe ou identifiant incorrect");
        }**/
        //----------------------------------------------------
    }//GEN-LAST:event_ValiderActionPerformed

    private void Valider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Valider1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Valider;
    private javax.swing.JButton Valider1;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelInfoPatient;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel layoutbutton;
    // End of variables declaration//GEN-END:variables
}
