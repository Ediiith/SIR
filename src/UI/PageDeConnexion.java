
package UI;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;


public class PageDeConnexion extends javax.swing.JFrame {

    public PageDeConnexion() {
        initComponents();
        this.setTitle("Connexion");
        this.setLocationRelativeTo(null);
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
        ID = new javax.swing.JLabel();
        TextFieldID = new javax.swing.JTextField();
        MDP = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        PasswordFieldMDP = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Connection = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/princeton.png"))); // NOI18N
        image.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(image, java.awt.BorderLayout.EAST);

        layoutbutton.setBackground(new java.awt.Color(255, 255, 255));
        layoutbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));

        ID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ID.setText("ID:");

        TextFieldID.setText("taper votre identifiant");
        TextFieldID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextFieldIDMouseClicked(evt);
            }
        });
        TextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldIDActionPerformed(evt);
            }
        });

        MDP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MDP.setText("Mot de passe:");

        Valider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Valider.setText("Valider");
        Valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        PasswordFieldMDP.setText("jPasswordField1");
        PasswordFieldMDP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFieldMDPFocusGained(evt);
            }
        });
        PasswordFieldMDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordFieldMDPMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Processir");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hospital.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        Connection.setBackground(new java.awt.Color(255, 255, 255));
        Connection.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        Connection.setForeground(new java.awt.Color(153, 0, 0));
        Connection.setText("Connexion");

        jSeparator2.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout layoutbuttonLayout = new javax.swing.GroupLayout(layoutbutton);
        layoutbutton.setLayout(layoutbuttonLayout);
        layoutbuttonLayout.setHorizontalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layoutbuttonLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PasswordFieldMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MDP)
                            .addGroup(layoutbuttonLayout.createSequentialGroup()
                                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(Connection, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
        );
        layoutbuttonLayout.setVerticalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addComponent(Connection)
                .addGap(28, 28, 28)
                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layoutbuttonLayout.createSequentialGroup()
                        .addComponent(ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(MDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordFieldMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layoutbuttonLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(371, Short.MAX_VALUE)))
        );

        getContentPane().add(layoutbutton, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldIDActionPerformed

    }//GEN-LAST:event_TextFieldIDActionPerformed

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

    private void TextFieldIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldIDMouseClicked
        TextFieldID.setText("");
    }//GEN-LAST:event_TextFieldIDMouseClicked

    private void PasswordFieldMDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordFieldMDPMouseClicked
        PasswordFieldMDP.setText("");
    }//GEN-LAST:event_PasswordFieldMDPMouseClicked

    private void PasswordFieldMDPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFieldMDPFocusGained
        PasswordFieldMDP.setText("");
    }//GEN-LAST:event_PasswordFieldMDPFocusGained

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
            java.util.logging.Logger.getLogger(PageDeConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageDeConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageDeConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageDeConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageDeConnexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Connection;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel MDP;
    private javax.swing.JPasswordField PasswordFieldMDP;
    private javax.swing.JTextField TextFieldID;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel layoutbutton;
    // End of variables declaration//GEN-END:variables
}
