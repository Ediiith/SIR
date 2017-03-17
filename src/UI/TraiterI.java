
package UI;

import NF.CompteRendu;
import NF.DMR;
import NF.Examen;
import NF.Personnel;
import NF.Statut;
import NF.TraitementImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;


public class TraiterI extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new form PageAccueil
     */
    private Personnel personnel;
    private CompteRendu cr;
    private List<DMR> listeDMR;
    private Examen e;
    private TraitementImage ti;

  

  /**  public PageAccueil(String statut, String identifiant, DossierMedical dm, ArrayList<Patient> listePatient, ArrayList<FicheDeSoins> listeFiche) {
        initComponents();
        this.setTitle("Page d'Accueil");
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.statut = statut;
        this.identifiant = identifiant;
        //this.dm = dm;
        //this.listePatient = listePatient;
        //this.listeFiche = listeFiche;
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(identifiant);
        jTextFieldStatut.setText(statut);
    }**/
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object obj = jTree.getLastSelectedPathComponent();
        String pasAutoriser = "Vous n'etes pas autorise a acceder a cette fonction";
        switch (obj.toString()) {
            case "Admission patient": //pas de restriction
                //if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateur")) {
                Patient p = new Patient(this.personnel);
                p.setVisible(true);
                this.dispose();
//                } else {
//                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
//                }
//                break;

            case "Consultation d'un DMR":
                if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateur")) {
                    Consulter_DMR cDMR = new Consulter_DMR(this.personnel, this.listeDMR);
                    cDMR.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Procéder à un examen":
                if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateur")) {
                    Exam e1 = new Exam(this.personnel, this.e);
                    e1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Création d'un CMR"://pas de restriction d'accès

                DMRTemporaire dmrt = new DMRTemporaire(this.personnel, this.listeDMR);
                dmrt.setVisible(true);
                this.dispose();

                break;
            case "Compte Rendu":
                if (personnel.getStatut().equals("Radiologue")) {
                    CpR cr1 = new CpR(this.personnel, this.cr);
                    cr1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Image":
                if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateur")) {
                    Image i1 = new Image(this.personnel);
                    i1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
//            case "Appareil":
//                if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateurulateur")) {
//                    //FacturationSpeMed fsm = new FacturationSpeMed(this.statut, this.identifiant, this.dm, this.listePatient, this.listeFiche);
//                    //fsm.setVisible(true);
//                    this.dispose();
//                } else {
//                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
//                }
//                break;
//            case "Compte personnel":
//                //ListeMedecin lm = new ListeMedecin(this.statut, this.identifiant, this.dm, this.listePatient, this.listeFiche);
//                //lm.setVisible(true);
//                this.dispose();
//                break;

            default:
                break;
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        barreDuHaut = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldStatut = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonDeco = new javax.swing.JButton();
        jSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonDeco1 = new javax.swing.JButton();
        jButtonDeco2 = new javax.swing.JButton();
        jButtonDeco3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButtonDeco4 = new javax.swing.JButton();
        jButtonDeco5 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 300));

        barreDuHaut.setPreferredSize(new java.awt.Dimension(30, 30));
        barreDuHaut.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jLabel1.setText("ID :");

        jLabel3.setText("Statut :");

        jLabel16.setFont(new java.awt.Font("Bernard MT Condensed", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("Processir");

        jButtonDeco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDeco.setText("Deconnexion");
        jButtonDeco.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButtonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        barreDuHaut.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(barreDuHaut, java.awt.BorderLayout.NORTH);

        jTree.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Processir");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Admission patient");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DMR");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Consultation d'un DMR");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Création d'un CMR");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Examen");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Procéder à un examen");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Associer à un DMR");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Compte-rendu");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Image");
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree);
        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Princeton-Plainsboro");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Admission patients");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("DMR");
        treeNode3.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Creation DMR");
        treeNode3.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Consulter DMR");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Compte rendu");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Image");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Compte personnel");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Associer à un DMR");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Saisir");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Imprimer");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Traiter");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Numériser");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        jTree.setPreferredSize(new java.awt.Dimension(230, 80));

        jSplitPane.setLeftComponent(jTree);

        jSplitPane.setLeftComponent(jScrollPane1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/princeton.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));

        jButtonDeco1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco1.setText("Contraste");
        jButtonDeco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco1.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco1.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco1ActionPerformed(evt);
            }
        });

        jButtonDeco2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco2.setText("Négative");
        jButtonDeco2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco2.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco2.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco2ActionPerformed(evt);
            }
        });

        jButtonDeco3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco3.setText("Zoom");
        jButtonDeco3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco3.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco3.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Traiter l'image");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel4.setText("Image");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));

        jButtonDeco4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco4.setText("Rotation");
        jButtonDeco4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco4.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco4.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco4ActionPerformed(evt);
            }
        });

        jButtonDeco5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco5.setText("Miroir");
        jButtonDeco5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco5.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco5.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel6)
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonDeco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonDeco4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonDeco5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonDeco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeco4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeco5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane.setRightComponent(jPanel5);

        getContentPane().add(jSplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecoActionPerformed
        PageDeConnexion connexion = new PageDeConnexion();
        connexion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonDecoActionPerformed

    private void jButtonDeco5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeco5ActionPerformed

    private void jButtonDeco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeco4ActionPerformed

    private void jButtonDeco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeco3ActionPerformed

    private void jButtonDeco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeco2ActionPerformed

    private void jButtonDeco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeco1ActionPerformed

    /**
     *
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JButton jButtonDeco1;
    private javax.swing.JButton jButtonDeco2;
    private javax.swing.JButton jButtonDeco3;
    private javax.swing.JButton jButtonDeco4;
    private javax.swing.JButton jButtonDeco5;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JLabel jTextFieldID;
    private javax.swing.JLabel jTextFieldStatut;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables

}
