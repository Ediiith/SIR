package UI;

import NF.CompteRendu;
import NF.DMR;
import NF.Examen;
import NF.Personnel;
import NF.Statut;
import NF.TraitementImage;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Image extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new form PageAccueil
     */
    private Personnel personnel;
    private CompteRendu cr;
    private List<DMR> listeDMR;
    private Examen e;
    private TraitementImage ti;
    private int i;
    private ArrayList<java.awt.Image> images;
    private final DefaultListModel model;
    private final ArrayList<ImageIcon> icons;
    private ArrayList<String> paths;
    private int util;


    public Image(ArrayList<java.awt.Image> images, int i, Examen e) {
        model = new DefaultListModel();
        icons = new ArrayList<>();
        paths = new ArrayList<>();
        this.util = i;
        this.e = e;

        initComponents();
        this.setTitle("Traiter image");
        this.setExtendedState(Image.MAXIMIZED_BOTH);
        this.setExtendedState(Image.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(Integer.toString(personnel.getIdPersonnel()));
        jTextFieldStatut.setText(personnel.getStatut().toString());

    }

    /**
     * public PageAccueil(String statut, String identifiant, DossierMedical dm,
     * ArrayList<Patient> listePatient, ArrayList<FicheDeSoins> listeFiche) {
     * initComponents(); this.setTitle("Page d'Accueil");
     * this.setExtendedState(this.MAXIMIZED_BOTH); this.statut = statut;
     * this.identifiant = identifiant; //this.dm = dm; //this.listePatient =
     * listePatient; //this.listeFiche = listeFiche;
     * this.setExtendedState(this.MAXIMIZED_BOTH);
     * this.setLocationRelativeTo(null); jTree.addTreeSelectionListener(this);
     * jTextFieldID.setText(identifiant); jTextFieldStatut.setText(statut); }*
     */
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
            case "Création d'un CMR"://pas de restriction d'accès

                DMRTemporaire dmrt = new DMRTemporaire(this.personnel, this.listeDMR);
                dmrt.setVisible(true);
                this.dispose();

                break;
            case "Procéder à un examen":
                if (personnel.getStatut().equals("Radiologue") || personnel.getStatut().equals("Manipulateur")) {
                    Examen2 e1 = new Examen2(this.personnel);
                    e1.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
                break;
            case "Associer à un DMR":
                if (personnel.getStatut().equals("Radiologue")) {
                    Associer a = new Associer(this.personnel);
                    a.setVisible(true);
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
                }
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
                if ( personnel.getStatut().equals("Manipulateur")) {
                    Image i1 = new Image(this.images, this.i, this.e);
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
        jButtonContrastePlus = new javax.swing.JButton();
        jButtonNegative = new javax.swing.JButton();
        jButtonZoomPlus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonRotation = new javax.swing.JButton();
        jButtonMiroir = new javax.swing.JButton();
        jButtonContrasteMoins1 = new javax.swing.JButton();
        jButtonReset1 = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        imageList = new JList(model);
        jButtonZoomMoins = new javax.swing.JButton();
        jButtonDeco1 = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 400));

        jButtonContrastePlus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonContrastePlus.setText("Contraste +");
        jButtonContrastePlus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonContrastePlus.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonContrastePlus.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonContrastePlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContrastePlusActionPerformed(evt);
            }
        });

        jButtonNegative.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNegative.setText("Négative");
        jButtonNegative.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonNegative.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonNegative.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNegativeActionPerformed(evt);
            }
        });

        jButtonZoomPlus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonZoomPlus.setText("Zoom +");
        jButtonZoomPlus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonZoomPlus.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonZoomPlus.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonZoomPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomPlusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Traiter l'image");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        jButtonRotation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRotation.setText("Rotation");
        jButtonRotation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonRotation.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonRotation.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonRotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotationActionPerformed(evt);
            }
        });

        jButtonMiroir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonMiroir.setText("Miroir");
        jButtonMiroir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonMiroir.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonMiroir.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonMiroir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMiroirActionPerformed(evt);
            }
        });

        jButtonContrasteMoins1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonContrasteMoins1.setText("Contraste -");
        jButtonContrasteMoins1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonContrasteMoins1.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonContrasteMoins1.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonContrasteMoins1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContrasteMoins1ActionPerformed(evt);
            }
        });

        jButtonReset1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonReset1.setText("Reset");
        jButtonReset1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonReset1.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonReset1.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReset1ActionPerformed(evt);
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        imageList.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        imageList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        imageList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imageListValueChanged(evt);
            }
        });
        scrollPane.setViewportView(imageList);

        jButtonZoomMoins.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonZoomMoins.setText("Zoom -");
        jButtonZoomMoins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonZoomMoins.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonZoomMoins.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonZoomMoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomMoinsActionPerformed(evt);
            }
        });

        jButtonDeco1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDeco1.setText("Ajouter");
        jButtonDeco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButtonDeco1.setMinimumSize(new java.awt.Dimension(110, 30));
        jButtonDeco1.setPreferredSize(new java.awt.Dimension(130, 30));
        jButtonDeco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeco1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonContrastePlus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonContrasteMoins1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonZoomPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonZoomMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRotation, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMiroir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonDeco1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(179, 179, 179)
                        .addComponent(jButtonReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonReset1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonContrastePlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonContrasteMoins1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonZoomPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonZoomMoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMiroir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE)))
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

    private void jButtonContrasteMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco6ActionPerformed
        // Ne rien rentrer ici, erreur de code généré
    }//GEN-LAST:event_jButtonDeco6ActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContrastePlus1ActionPerformed
        // Ne rien rentrer ici, erreur de code généré
    }//GEN-LAST:event_jButtonContrastePlus1ActionPerformed

    private void jButtonDeco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeco1ActionPerformed
//        JFileChooser choix = new JFileChooser();
//        FilenameFilter fileNameFilter;
//        String[] imageTypes = ImageIO.getReaderFileSuffixes();
//        FileNameExtensionFilter fnf = new FileNameExtensionFilter("Images", imageTypes);
//        choix.setFileFilter(fnf);
//        File userHome = new File(System.getProperty("user.home"));
//        choix.setSelectedFile(userHome);
//
//        fileNameFilter = new FilenameFilter() {
//            @Override
//            public boolean accept(File file, String name) {
//                return true;
//            }
//        };
//
//        int op = choix.showOpenDialog(null);
//        if (op == JFileChooser.APPROVE_OPTION) {
//            File eg = choix.getSelectedFile();
//            // sélectionne tout le dossier dans lequel se situe l'image
//            File dir = eg.getParentFile();
//            try {
//                File[] imageFiles = dir.listFiles(fileNameFilter);
//                BufferedImage[] images = new BufferedImage[imageFiles.length];
//                model.removeAllElements();
//                for (int ii = 0; ii < images.length; ii++) {
//                    paths.add(imageFiles[ii].getPath());
//                    icons.add(new ImageIcon(imageFiles[ii].getPath()));
//                    model.addElement(ImageIO.read(imageFiles[ii]));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(gui, "Erreur lors du chargement des images", "Erreur", JOptionPane.ERROR_MESSAGE);
//            }
//        }
    }//GEN-LAST:event_jButtonDeco1ActionPerformed

    private void jButtonZoomMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZoomMoinsActionPerformed
        ti.zoomOut();
        ti.repaint();
    }//GEN-LAST:event_jButtonZoomMoinsActionPerformed

    private void imageListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imageListValueChanged
        //        i = imageList.getSelectedIndex();
        //        try {
        //            Image image = (Image) model.get(i);
        //            if (image.getWidth(null) > image.getHeight(null)) {
        //                image = image.getScaledInstance(imageViewContainer.getWidth(), -1, Image.SCALE_DEFAULT);
        //            } else {
        //                image = image.getScaledInstance(-1, imageViewContainer.getHeight(), Image.SCALE_DEFAULT);
        //            }
        //            displayPanel = new Manip_Image(image);
        //        } catch (ClassCastException ex) {
        //            Image image2 = icons.get(i).getImage();
        //            if (image2.getWidth(null) > image2.getHeight(null)) {
        //                image2 = image2.getScaledInstance(imageViewContainer.getWidth(), -1, Image.SCALE_DEFAULT);
        //            } else {
        //                image2 = image2.getScaledInstance(-1, imageViewContainer.getHeight(), Image.SCALE_DEFAULT);
        //            }
        //            displayPanel = new Manip_Image(image2);
        //        }
        //        imageViewContainer.add(displayPanel);
        //        displayPanel.repaint();
    }//GEN-LAST:event_imageListValueChanged

    private void jButtonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReset1ActionPerformed
        ti.reset();
        ti.repaint();
        ti.createBufferedImage();
        this.updateUI();
    }//GEN-LAST:event_jButtonReset1ActionPerformed

    private void jButtonContrasteMoins1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContrasteMoins1ActionPerformed
        ti.contrastDecLUT();
        ti.applyFilter();
        ti.repaint();
    }//GEN-LAST:event_jButtonContrasteMoins1ActionPerformed

    private void jButtonMiroirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMiroirActionPerformed
        ti.symetrieVerticale();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_jButtonMiroirActionPerformed

    private void jButtonRotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotationActionPerformed
        ti.rotation();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_jButtonRotationActionPerformed

    private void jButtonZoomPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZoomPlusActionPerformed
        ti.zoomIn();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_jButtonZoomPlusActionPerformed

    private void jButtonNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNegativeActionPerformed
        ti.reverseLUT();
        ti.applyFilter();
        ti.repaint();
    }//GEN-LAST:event_jButtonNegativeActionPerformed

    private void jButtonContrastePlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContrastePlusActionPerformed
        ti.contrastIncLUT();
        ti.applyFilter();
        ti.repaint();
    }//GEN-LAST:event_jButtonContrastePlusActionPerformed
    public void updateUI() {
        BufferedImage bi = ti.getBi();
        icons.set(i, new ImageIcon(bi));
        java.awt.Image img = (java.awt.Image) bi;
        img = img.getScaledInstance(100, -1, java.awt.Image.SCALE_DEFAULT);
        model.setElementAt(new ImageIcon(img), i);
        scrollPane.repaint();
    }
    /**
     *
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JList<String> imageList;
    private javax.swing.JButton jButtonContrasteMoins1;
    private javax.swing.JButton jButtonContrastePlus;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JButton jButtonDeco1;
    private javax.swing.JButton jButtonMiroir;
    private javax.swing.JButton jButtonNegative;
    private javax.swing.JButton jButtonReset1;
    private javax.swing.JButton jButtonRotation;
    private javax.swing.JButton jButtonZoomMoins;
    private javax.swing.JButton jButtonZoomPlus;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

}
