
package UI;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;


public class Acces extends javax.swing.JFrame {

    public Acces() {
        initComponents();
        this.setTitle("Connexion");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JLabel();
        layoutbutton = new javax.swing.JPanel();
        Valider = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Connection = new javax.swing.JLabel();
        Connection1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/princeton.png"))); // NOI18N
        image.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(image, java.awt.BorderLayout.EAST);

        layoutbutton.setMaximumSize(new java.awt.Dimension(429, 184));
        layoutbutton.setPreferredSize(new java.awt.Dimension(429, 184));

        Valider.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Valider.setText("Retour");
        Valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Processir");

        Connection.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Connection.setForeground(new java.awt.Color(153, 0, 0));
        Connection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Connection.setText("accès à cette fonction ?");
        Connection.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Connection1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Connection1.setForeground(new java.awt.Color(153, 0, 0));
        Connection1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Connection1.setText("Vous n'avez pas");
        Connection1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layoutbuttonLayout = new javax.swing.GroupLayout(layoutbutton);
        layoutbutton.setLayout(layoutbuttonLayout);
        layoutbuttonLayout.setHorizontalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutbuttonLayout.createSequentialGroup()
                        .addComponent(Connection1)
                        .addGap(48, 48, 48))))
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addGroup(layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Connection)
                    .addGroup(layoutbuttonLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layoutbuttonLayout.setVerticalGroup(
            layoutbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutbuttonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Connection1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Connection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1))
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

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Connection;
    private javax.swing.JLabel Connection1;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel layoutbutton;
    // End of variables declaration//GEN-END:variables
}
