package UI;

import NF.CompteRendu;
import NF.DMR;
import NF.Examen;
import NF.Genre;
import NF.Personnel;
import NF.Statut;
import NF.TraitementImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Consulter_DMR extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new form PageAccueil
     */
    private Personnel personnel;
    private CompteRendu cr;
    private List<DMR> listeDMR;
    private ArrayList<java.awt.Image> images;
    private Examen e;
    private TraitementImage ti;
    private int i;
    private String date;
    private String[] columnNames;
    private Object[][] data;
    private DMR dmr;
    private String nomPatient;
    private String prenomPatient;
    private String genre;
    private String numSS;
    private Genre g;

    public Consulter_DMR(Personnel personnel, List<DMR> listeDMR) {
        initComponents();
        this.setTitle("Consulter DMR");
        this.setExtendedState(Consulter_DMR.MAXIMIZED_BOTH);
        this.personnel = personnel;
        this.listeDMR = listeDMR;
        this.setExtendedState(Consulter_DMR.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(personnel.toString());
        jTextFieldStatut.setText(personnel.getStatut().toString());
        this.jTablePatient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.date = "" + jj + "/" + mm + "/" + aa;
        this.dmr = new DMR(nomPatient, prenomPatient, date, g, Integer.parseInt(numSS));

        if (this.dmr.getIdDMR() != 0) {
            this.jTablePatient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.columnNames = new String[7];
            this.columnNames[0] = "Nom";
            this.columnNames[1] = "Prénom";
            this.columnNames[2] = "Genre";
            this.columnNames[3] = "Date de naissance";
            this.columnNames[4] = "Adresse";
            this.columnNames[5] = "Numéro de sécurité sociale";
            this.columnNames[6] = "Identifiant unique";

            int nbrligne = 1;
            int k = 0;
            data = new Object[nbrligne][7];
            for (int i = 0; i < nbrligne; i++) {
                data[k][0] = dmr.getNomPatient();
                data[k][1] = dmr.getPrenomPatient();
                data[k][2] = dmr.getGenre();
                data[k][3] = dmr.getDateNaissance();
                data[k][4] = dmr.getAdresse();
                data[k][5] = dmr.getNumSS();
                data[k][6] = dmr.getIdDMR();//examen
            }
            jTablePatient.setModel(new DefaultTableModel(data, columnNames));
        }

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
                    Consulter_DMR cDMR = new Consulter_DMR(this.personnel, this.listeDMR);
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
            case "Associer examen au DMR":
                if (personnel.getStatut().compareTo(Statut.MANIPULATEUR) == 0) {
                    AssocierDMR a = new AssocierDMR(this.personnel, this.listeDMR);
                    a.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Compte-rendu":
                if (personnel.getStatut().compareTo(Statut.RADIOLOGUE) == 0 || personnel.getStatut().compareTo(Statut.CHEF_SERVICE) == 0) {
                    CpR cr1 = new CpR(this.personnel, this.cr);
                    cr1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;

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
        jButtonDeco = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldStatut = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        NomPatient = new javax.swing.JTextField();
        PrenomPatient = new javax.swing.JTextField();
        LancerRecherche = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        NumSSPatient = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePatient = new javax.swing.JTable();
        VisualiserDMR = new javax.swing.JButton();
        jButtonTraiter = new javax.swing.JButton();
        jj = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mm = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        aa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 300));

        barreDuHaut.setPreferredSize(new java.awt.Dimension(30, 30));
        barreDuHaut.setLayout(new java.awt.BorderLayout());

        jButtonDeco.setText("Deconnexion");
        jButtonDeco.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecoActionPerformed(evt);
            }
        });
        barreDuHaut.add(jButtonDeco, java.awt.BorderLayout.EAST);

        jLabel1.setText("ID :");

        jLabel3.setText("Statut :");

        jLabel16.setFont(new java.awt.Font("Bernard MT Condensed", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("Processir");

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
                .addComponent(jTextFieldStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextFieldStatut, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
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
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Associer examen au DMR");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Compte-rendu");
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setMaximumSize(new java.awt.Dimension(170, 100));
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
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Consulter DMR");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Rechercher par nom, prénom et date de naissance :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nom :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Prénom :");

        NomPatient.setText("jTextField1");

        PrenomPatient.setText("jTextField2");

        LancerRecherche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LancerRecherche.setText("Rechercher");
        LancerRecherche.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        LancerRecherche.setMinimumSize(new java.awt.Dimension(110, 30));
        LancerRecherche.setPreferredSize(new java.awt.Dimension(130, 30));
        LancerRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LancerRechercheActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(153, 0, 0));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Numéro de Sécurité sociale :");

        NumSSPatient.setText("jTextField2");

        jTablePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePatientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePatient);

        VisualiserDMR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        VisualiserDMR.setText("Visualiser DMR");
        VisualiserDMR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        VisualiserDMR.setMinimumSize(new java.awt.Dimension(110, 30));
        VisualiserDMR.setPreferredSize(new java.awt.Dimension(130, 30));
        VisualiserDMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualiserDMRActionPerformed(evt);
            }
        });

        jButtonTraiter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTraiter.setText("Traiter Image");
        jButtonTraiter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonTraiter.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonTraiter.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonTraiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraiterActionPerformed(evt);
            }
        });

        jj.setText("31");
        jj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jjFocusGained(evt);
            }
        });
        jj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jjMouseClicked(evt);
            }
        });
        jj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjActionPerformed(evt);
            }
        });
        jj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jjKeyTyped(evt);
            }
        });

        jLabel14.setText("/");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Date de naissance :");

        mm.setText("12");
        mm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mmFocusGained(evt);
            }
        });
        mm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mmMouseClicked(evt);
            }
        });
        mm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmActionPerformed(evt);
            }
        });
        mm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mmKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mmKeyTyped(evt);
            }
        });

        jLabel18.setText("/");

        aa.setText("1965");
        aa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aaFocusGained(evt);
            }
        });
        aa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aaMouseClicked(evt);
            }
        });
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });
        aa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aaKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Rechercher par numéro de Sécurité sociale :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jScrollPane3)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NumSSPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                .addComponent(LancerRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(NomPatient))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(PrenomPatient))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VisualiserDMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTraiter, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LancerRecherche, VisualiserDMR, jButtonTraiter});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrenomPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel18)
                        .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jj, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumSSPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LancerRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VisualiserDMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTraiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
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

    private void LancerRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LancerRechercheActionPerformed
      while(i<listeDMR.size()){
        if (((listeDMR.get(i).getNomPatient()==0)&&(listeDMR.get(i).getPrenomPatient()==0)&&(listeDMR.get(i).getDateNaissance()==0))||(listeDMR.get(i).getNumSS()==0)){
              if(IdDMR==0){
                  this.dmr = new DMR(nomPatient, prenomPatient, date, g, Integer.parseInt(numSS));
              }
  
        }
    }//GEN-LAST:event_LancerRechercheActionPerformed

    private void jTablePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePatientMouseClicked
        int row = jTablePatient.getSelectedRow();
        int i = 0;
        int compteur = 0;
        boolean rep = false;
        // while ((i < listeDMR.size()) && (rep == false)) {
        compteur = 0;
        //if (listeDMR.get(i).getDate().toString().equals(jTable.getValueAt(row, 0))
        //  && listeDMR.get(i).getMedecin().toString().equals(jTable.getValueAt(row, 1))
        //                && listeFiche.get(i).getPatient().getNumSecu().equals(jTable.getValueAt(row, 3))) {
        //                for (int j = 0; j < listeFiche.get(i).getActes().size(); j++) {
        //                    if (listeFiche.get(i).getActe(j).getCode().toString().equals(jTable.getValueAt(row + j, 5))) {
        //                        compteur++;
        //                    }
        //
        //                }
        //                if (compteur == listeFiche.get(i).getActes().size()) {
        //                    rep = true;
        //                    AffichageFiche f = new AffichageFiche(listeFiche.get(i),this.statut);
        //                    f.setVisible(true);
        //                }
        //
        //            }
        //            i++;
        //        }
    }//GEN-LAST:event_jTablePatientMouseClicked

    private void VisualiserDMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualiserDMRActionPerformed
        AfficherDMR aDMR = new AfficherDMR(listeDMR.get(jTablePatient.getSelectedRow()));
        aDMR.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VisualiserDMRActionPerformed

    private void jButtonTraiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraiterActionPerformed
        Image i = new Image(this.personnel, this.images, this.i, this.e);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonTraiterActionPerformed

    private void jjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jjFocusGained
        jj.setText("");
    }//GEN-LAST:event_jjFocusGained

    private void jjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jjMouseClicked
        jj.setText("");
    }//GEN-LAST:event_jjMouseClicked

    private void jjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjActionPerformed

    }//GEN-LAST:event_jjActionPerformed

    private void jjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jjKeyTyped
        if (jj.getText().length() == 1) {
            mm.requestFocus();
        }
    }//GEN-LAST:event_jjKeyTyped

    private void mmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mmFocusGained
        mm.setText("");
    }//GEN-LAST:event_mmFocusGained

    private void mmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mmMouseClicked
        mm.setText("");
    }//GEN-LAST:event_mmMouseClicked

    private void mmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmActionPerformed

    }//GEN-LAST:event_mmActionPerformed

    private void mmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mmKeyPressed

    }//GEN-LAST:event_mmKeyPressed

    private void mmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mmKeyTyped
        if (mm.getText().length() == 1) {
            aa.requestFocus();
        }
    }//GEN-LAST:event_mmKeyTyped

    private void aaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aaFocusGained
        aa.setText("");
    }//GEN-LAST:event_aaFocusGained

    private void aaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aaMouseClicked
        aa.setText("");
    }//GEN-LAST:event_aaMouseClicked

    private void aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaActionPerformed

    }//GEN-LAST:event_aaActionPerformed

    private void aaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aaKeyPressed

    }//GEN-LAST:event_aaKeyPressed

    private void aaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aaKeyTyped
        if (aa.getText().length() == 3) {
            LancerRecherche.requestFocus();
        }
    }//GEN-LAST:event_aaKeyTyped

    /**
     *
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LancerRecherche;
    private javax.swing.JTextField NomPatient;
    private javax.swing.JTextField NumSSPatient;
    private javax.swing.JTextField PrenomPatient;
    private javax.swing.JButton VisualiserDMR;
    private javax.swing.JTextField aa;
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JButton jButtonTraiter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTable jTablePatient;
    private javax.swing.JLabel jTextFieldID;
    private javax.swing.JLabel jTextFieldStatut;
    private javax.swing.JTree jTree;
    private javax.swing.JTextField jj;
    private javax.swing.JTextField mm;
    // End of variables declaration//GEN-END:variables

}
