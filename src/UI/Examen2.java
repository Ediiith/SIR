package UI;

import NF.DMR;
import static NF.ListeDMR.getListeDMRadmis;
import NF.Personnel;
import NF.Statut;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Examen2 extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new Examen2
     *
     * @author Julie
     */
    
    private Personnel personnel;
    
    private String[] columnNames;
    private Object[][] data;

    public Examen2(Personnel personnel) {
        
        this.personnel = personnel;
        
        initComponents();
        this.setTitle("Procéder à un examen");
        this.setExtendedState(this.MAXIMIZED_BOTH);
                
        this.setLocationRelativeTo(null);
        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(this.personnel.getIdPersonnel());
        jTextFieldStatut.setText(this.personnel.getStatut().toString());

        this.jTablePatient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.columnNames = new String[7];
        this.columnNames[0] = "Nom";
        this.columnNames[1] = "Prénom";
        this.columnNames[2] = "Genre";
        this.columnNames[3] = "Date de naissance";
        this.columnNames[4] = "Adresse";
        this.columnNames[5] = "Numéro de sécurité sociale";
        this.columnNames[6] = "Identifiant unique";

        int nbrligne = getListeDMRadmis().size();
        data = new Object[nbrligne][7];
        
        for (int i = 0; i < nbrligne; i++) {
            data[i][0] = getListeDMRadmis().get(i).getNomPatient();
            data[i][1] = getListeDMRadmis().get(i).getPrenomPatient();
            data[i][2] = getListeDMRadmis().get(i).getGenre();
            data[i][3] = getListeDMRadmis().get(i).getDateNaissance();
            data[i][4] = getListeDMRadmis().get(i).getAdresse();
            data[i][5] = getListeDMRadmis().get(i).getNumSS();
            data[i][6] = getListeDMRadmis().get(i).getIdDMR();
        }
        
        jTablePatient.setModel(new DefaultTableModel(data, columnNames));
        
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object obj = jTree.getLastSelectedPathComponent();
        String pasAutoriser = "Vous n'etes pas autorise a acceder a cette fonction";
        switch (obj.toString()) {
            case "Admission patient": //secretaire
                if (personnel.getStatut().compareTo(Statut.SECRETAIRE) == 0) {
                    Patient p = new Patient(this.personnel);
                    p.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Consultation d'un DMR":
                if (personnel.getStatut().compareTo(Statut.RADIOLOGUE) == 0 || personnel.getStatut().compareTo(Statut.MANIPULATEUR) == 0 || personnel.getStatut().compareTo(Statut.CHEF_SERVICE) == 0) {
                    Consulter_DMR cDMR = new Consulter_DMR(this.personnel);
                    cDMR.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Procéder à un examen":
                if (personnel.getStatut().compareTo(Statut.RADIOLOGUE) == 0 || personnel.getStatut().compareTo(Statut.MANIPULATEUR) == 0 || personnel.getStatut().compareTo(Statut.CHEF_SERVICE) == 0) {
                    Examen2 e1 = new Examen2(this.personnel);
                    e1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Compte-rendu":
                if (personnel.getStatut().compareTo(Statut.RADIOLOGUE) == 0 || personnel.getStatut().compareTo(Statut.CHEF_SERVICE) == 0) {
                    CpR cr1 = new CpR(this.personnel);
                    cr1.setVisible(true);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePatient = new javax.swing.JTable();

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
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
                .addGap(22, 22, Short.MAX_VALUE))
        );

        barreDuHaut.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(barreDuHaut, java.awt.BorderLayout.NORTH);

        jTree.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Processir");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Admission patient");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Consultation d'un DMR");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Procéder à un examen");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Compte-rendu");
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setMaximumSize(new java.awt.Dimension(170, 100));
        jTree.setPreferredSize(new java.awt.Dimension(170, 100));
        jScrollPane1.setViewportView(jTree);

        jSplitPane.setLeftComponent(jScrollPane1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("l'hopital Princeton Plainsboro");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("d'Information Radiologique de ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Bienvenue sur le Systeme ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Procéder à un examen");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Liste des patients admis :");

        Valider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Valider.setText("Sélectionner");
        Valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Valider.setMinimumSize(new java.awt.Dimension(110, 30));
        Valider.setPreferredSize(new java.awt.Dimension(130, 30));
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        jTablePatient.setPreferredSize(new java.awt.Dimension(700, 150));
        jTablePatient.setSelectionBackground(new java.awt.Color(153, 0, 0));
        jTablePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePatientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePatient);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(611, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(83, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
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

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        int row = jTablePatient.getSelectedRow();
        int idDMR = (int) jTablePatient.getValueAt(row, 6);
        DMR dmr;
        dmr = new DMR(idDMR);
        Exam e1 = new Exam(this.personnel, dmr);
        e1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ValiderActionPerformed

    private void jTablePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePatientMouseClicked
        
    }//GEN-LAST:event_jTablePatientMouseClicked

    /**
     *
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Valider;
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTable jTablePatient;
    private javax.swing.JLabel jTextFieldID;
    private javax.swing.JLabel jTextFieldStatut;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables

}
