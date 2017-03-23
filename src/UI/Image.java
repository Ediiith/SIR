package UI;

import NF.DMR;
import NF.Examen;
import NF.Personnel;
import NF.Statut;
import NF.TraitementImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.awt.Desktop;
/**
 *
 * @author JEMCare Solution
 */

public class Image extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new form PageAccueil
     */
    private Personnel personnel;
    private List<DMR> listeDMR;
    private DMR dmr;
    private Examen e;
    private TraitementImage ti;
    private int i;
    private ArrayList<String> paths;
    private java.awt.Image im;
    private final DefaultListModel model;
    private final ArrayList<ImageIcon> icons;
    private ArrayList<java.awt.Image> ims;

    public Image(Personnel personnel, DMR dmr, java.awt.Image im, Examen e) {
        this.paths = new ArrayList<>();
        this.model = new DefaultListModel();
        this.icons = new ArrayList<>();
        this.e = e;
        this.dmr = dmr;
        this.personnel = personnel;
        this.im = im;
        this.ti = new TraitementImage(im);
        initComponents();
        this.setTitle("Traiter image");
        this.setExtendedState(Image.MAXIMIZED_BOTH);
        this.setExtendedState(Image.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(this.personnel.getIdPersonnel());
        jTextFieldStatut.setText(this.personnel.getStatut().toString());

        this.icons.add(new ImageIcon(this.im));
        this.im = this.im.getScaledInstance(600, -1, java.awt.Image.SCALE_DEFAULT);
        model.addElement(new ImageIcon(this.im));
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
        jLabel17 = new javax.swing.JLabel();
        jSplitPane = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ContrastePlus = new javax.swing.JButton();
        Negatif = new javax.swing.JButton();
        ZoomPlus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Rotation = new javax.swing.JButton();
        Miroir = new javax.swing.JButton();
        ContrasteMoins1 = new javax.swing.JButton();
        jButtonReset1 = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        imageList = new JList(model);
        ZoomMoins = new javax.swing.JButton();
        Retour = new javax.swing.JButton();
        Rogner = new javax.swing.JButton();
        Eclaircir = new javax.swing.JButton();

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

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/image/Aide-SZ-icon.png"))); // NOI18N
        jLabel17.setToolTipText("Aide");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel17.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel17.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel17.setPreferredSize(new java.awt.Dimension(30, 30));

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
                .addGap(44, 44, 44)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 400));

        ContrastePlus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ContrastePlus.setText("Contraste +");
        ContrastePlus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        ContrastePlus.setMinimumSize(new java.awt.Dimension(110, 30));
        ContrastePlus.setPreferredSize(new java.awt.Dimension(130, 30));
        ContrastePlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrastePlusActionPerformed(evt);
            }
        });

        Negatif.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Negatif.setText("Négatif");
        Negatif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Negatif.setMinimumSize(new java.awt.Dimension(80, 30));
        Negatif.setPreferredSize(new java.awt.Dimension(130, 30));
        Negatif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegatifActionPerformed(evt);
            }
        });

        ZoomPlus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ZoomPlus.setText("Zoom +");
        ZoomPlus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        ZoomPlus.setMinimumSize(new java.awt.Dimension(110, 30));
        ZoomPlus.setPreferredSize(new java.awt.Dimension(130, 30));
        ZoomPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomPlusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Traiter l'image");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        Rotation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rotation.setText("Rotation");
        Rotation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Rotation.setMinimumSize(new java.awt.Dimension(110, 30));
        Rotation.setPreferredSize(new java.awt.Dimension(130, 30));
        Rotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RotationActionPerformed(evt);
            }
        });

        Miroir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Miroir.setText("Miroir");
        Miroir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Miroir.setMinimumSize(new java.awt.Dimension(110, 30));
        Miroir.setPreferredSize(new java.awt.Dimension(130, 30));
        Miroir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiroirActionPerformed(evt);
            }
        });

        ContrasteMoins1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ContrasteMoins1.setText("Contraste -");
        ContrasteMoins1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        ContrasteMoins1.setMinimumSize(new java.awt.Dimension(110, 30));
        ContrasteMoins1.setPreferredSize(new java.awt.Dimension(130, 30));
        ContrasteMoins1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrasteMoins1ActionPerformed(evt);
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

        ZoomMoins.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ZoomMoins.setText("Zoom -");
        ZoomMoins.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        ZoomMoins.setMinimumSize(new java.awt.Dimension(110, 30));
        ZoomMoins.setPreferredSize(new java.awt.Dimension(130, 30));
        ZoomMoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomMoinsActionPerformed(evt);
            }
        });

        Retour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Retour.setText("Retour");
        Retour.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Retour.setMinimumSize(new java.awt.Dimension(110, 30));
        Retour.setPreferredSize(new java.awt.Dimension(130, 30));
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });

        Rogner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rogner.setText("Rogner");
        Rogner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Rogner.setMinimumSize(new java.awt.Dimension(110, 30));
        Rogner.setPreferredSize(new java.awt.Dimension(130, 30));
        Rogner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RognerActionPerformed(evt);
            }
        });

        Eclaircir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Eclaircir.setText("Eclaircir");
        Eclaircir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Eclaircir.setMinimumSize(new java.awt.Dimension(110, 30));
        Eclaircir.setPreferredSize(new java.awt.Dimension(130, 30));
        Eclaircir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EclaircirActionPerformed(evt);
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
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ZoomPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ZoomMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Miroir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Rogner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ContrastePlus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ContrasteMoins1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Negatif, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Eclaircir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
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
                            .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(scrollPane)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ContrastePlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContrasteMoins1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Negatif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZoomPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZoomMoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Miroir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rogner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eclaircir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))))
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

    private void ZoomMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomMoinsActionPerformed
        ti.zoomOut();
        ti.repaint();
        BufferedImage bi = ti.getBi();
        icons.set(i, new ImageIcon(bi));
        java.awt.Image img = (java.awt.Image) bi;
        model.setElementAt(new ImageIcon(img), i);
        scrollPane.repaint();
    }//GEN-LAST:event_ZoomMoinsActionPerformed

    private void imageListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imageListValueChanged

    }//GEN-LAST:event_imageListValueChanged

    private void jButtonReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReset1ActionPerformed
        ti.reset();
        ti.repaint();
        ti.createBufferedImage();
        this.updateUI();
    }//GEN-LAST:event_jButtonReset1ActionPerformed

    private void ContrasteMoins1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrasteMoins1ActionPerformed
        ti.contrastDecLUT();
        ti.applyFilter();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_ContrasteMoins1ActionPerformed

    private void MiroirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiroirActionPerformed
        ti.symetrieHorizontale();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_MiroirActionPerformed

    private void RotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RotationActionPerformed
        ti.rotation();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_RotationActionPerformed

    private void ZoomPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomPlusActionPerformed
        ti.zoomIn();
        ti.repaint();
        BufferedImage bi = ti.getBi();
        icons.set(i, new ImageIcon(bi));
        java.awt.Image img = (java.awt.Image) bi;
        model.setElementAt(new ImageIcon(img), i);
        scrollPane.repaint();
    }//GEN-LAST:event_ZoomPlusActionPerformed

    private void NegatifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegatifActionPerformed
        ti.reverseLUT();
        ti.applyFilter();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_NegatifActionPerformed

    private void ContrastePlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrastePlusActionPerformed
        ti.contrastIncLUT();
        ti.applyFilter();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_ContrastePlusActionPerformed

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_RetourActionPerformed

    private void RognerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RognerActionPerformed
        BufferedImage bi = ti.getBi();
        double x=bi.getWidth()-bi.getWidth()*0.9;
        int xi= (int)x;
        double y=bi.getHeight()-bi.getHeight()*0.9;
        int yi= (int)y;
        double w= bi.getWidth()*0.9;
        int wi=(int)w;
        double h=bi.getHeight()*0.9;
        int hi = (int)h;
        bi = bi.getSubimage(xi, yi, wi, hi);
        icons.set(i, new ImageIcon(bi));
        java.awt.Image img = (java.awt.Image) bi;
        img = img.getScaledInstance(400, -1, java.awt.Image.SCALE_DEFAULT);
        model.setElementAt(new ImageIcon(img), i);
        ti.repaint();
        scrollPane.repaint();
    }//GEN-LAST:event_RognerActionPerformed

    private void EclaircirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EclaircirActionPerformed
        ti.brightenLUT();
        ti.applyFilter();
        ti.repaint();
        this.updateUI();
    }//GEN-LAST:event_EclaircirActionPerformed
    public void updateUI() {
        BufferedImage bi = ti.getBi();
        icons.set(i, new ImageIcon(bi));
        java.awt.Image img = (java.awt.Image) bi;
        img = img.getScaledInstance(600, -1, java.awt.Image.SCALE_DEFAULT);
        model.setElementAt(new ImageIcon(img), i);
        scrollPane.repaint();
    }
    /**
     *
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContrasteMoins1;
    private javax.swing.JButton ContrastePlus;
    private javax.swing.JButton Eclaircir;
    private javax.swing.JButton Miroir;
    private javax.swing.JButton Negatif;
    private javax.swing.JButton Retour;
    private javax.swing.JButton Rogner;
    private javax.swing.JButton Rotation;
    private javax.swing.JButton ZoomMoins;
    private javax.swing.JButton ZoomPlus;
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JList<String> imageList;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JButton jButtonReset1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
