package UI;

import NF.DMR;
import NF.Examen;
import NF.IconCellRenderer;
import NF.Personnel;
import NF.Statut;
import NF.TraitementImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PreImage extends javax.swing.JFrame implements TreeSelectionListener {

    /**
     * Creates new form PageAccueil
     */
    private Personnel personnel;
    private DMR dmr;
    private String date;
    private List<DMR> listeDMR;
    private Examen e;
    private TraitementImage ti;
    private int idExamen;
    private ArrayList<java.awt.Image> ims;
    private final DefaultListModel model;
    private final ArrayList<ImageIcon> icons;
    private ArrayList<String> paths;
    private int i;

    public PreImage(Personnel personnel,ArrayList<ImageIcon> icons,int index, DMR dmr, Examen e) {
        this.model = new DefaultListModel();
        this.paths = new ArrayList<>();
        if(index==-1){
            this.icons = new ArrayList<>();
        }
        else {
            this.icons=icons;
        }
        this.personnel = personnel;
        this.dmr = dmr;
        this.e = e;
        initComponents();
        this.setTitle("Visualiser image");
        this.setExtendedState(PreImage.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        jTree.addTreeSelectionListener(this);
        jTextFieldID.setText(this.personnel.toString());
        jTextFieldStatut.setText(this.personnel.getStatut().toString());
        Images.setCellRenderer(new IconCellRenderer());

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
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        scrollPane = new javax.swing.JScrollPane();
        Images = new JList(model);
        jPanel3 = new javax.swing.JPanel();
        Traiter = new javax.swing.JButton();
        Enregistrer = new javax.swing.JButton();
        ChoisirFichier = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Image");

        jSeparator1.setForeground(new java.awt.Color(153, 0, 0));

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Images.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        Images.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Images.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ImagesValueChanged(evt);
            }
        });
        scrollPane.setViewportView(Images);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Traiter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Traiter.setText("Traiter");
        Traiter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Traiter.setMinimumSize(new java.awt.Dimension(110, 30));
        Traiter.setPreferredSize(new java.awt.Dimension(130, 30));
        Traiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraiterActionPerformed(evt);
            }
        });

        Enregistrer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Enregistrer.setText("Enregistrer");
        Enregistrer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Enregistrer.setMinimumSize(new java.awt.Dimension(110, 30));
        Enregistrer.setPreferredSize(new java.awt.Dimension(130, 30));
        Enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(Traiter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Traiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        ChoisirFichier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChoisirFichier.setText("Fichier");
        ChoisirFichier.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        ChoisirFichier.setMinimumSize(new java.awt.Dimension(110, 30));
        ChoisirFichier.setPreferredSize(new java.awt.Dimension(130, 30));
        ChoisirFichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoisirFichierActionPerformed(evt);
            }
        });

        Quitter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Quitter.setText("Quitter");
        Quitter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        Quitter.setMinimumSize(new java.awt.Dimension(110, 30));
        Quitter.setPreferredSize(new java.awt.Dimension(130, 30));
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ChoisirFichier, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChoisirFichier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerActionPerformed
      for (int j = 1; j < paths.size(); j++) {
            try {
                BufferedImage bi = (BufferedImage) icons.get(j).getImage();
                File file = new File(paths.get(j));
                try {
                    ImageIO.write(bi, "png", file);
                    System.out.println("File saved!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des images", "Enregistrement", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassCastException ex) {
            }
            this.e.setLienPACS(paths.get(j));
        }
        JOptionPane.showMessageDialog(this, "Les images ont bien été enregistrées", "Enregistrement", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_EnregistrerActionPerformed

    private void ImagesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ImagesValueChanged
        this.i = Images.getSelectedIndex();
    }//GEN-LAST:event_ImagesValueChanged

    private void TraiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraiterActionPerformed
        if (this.personnel.getStatut().compareTo(Statut.MANIPULATEUR) == 0) {
            java.awt.Image im = (java.awt.Image) model.get(this.i);
            Image ima = new Image(this.personnel, this.dmr,this.icons, im, this.i,this.e);
            ima.setVisible(true);
            this.dispose();
        } else {
            String pasAutoriser = "Vous n'etes pas autorise a acceder a cette fonction";
            javax.swing.JOptionPane.showMessageDialog(null, pasAutoriser);
        }

    }//GEN-LAST:event_TraiterActionPerformed

    private void ChoisirFichierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoisirFichierActionPerformed
        JFileChooser choix = new JFileChooser();
        FilenameFilter fileNameFilter;
        String[] imageTypes = {"png", "jpg"};
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("Images", imageTypes);
        choix.setFileFilter(fnf);
        File userHome = new File(System.getProperty("user.home"));
        choix.setSelectedFile(userHome);

        fileNameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return true;
            }
        };

        int op = choix.showOpenDialog(null);
        if (op == JFileChooser.APPROVE_OPTION) {
            File eg = choix.getSelectedFile();
            // sélectionne tout le dossier dans lequel se situe l'image
            File dir = eg.getParentFile();
            try {
                File[] imageFiles = dir.listFiles(fileNameFilter);
                BufferedImage[] im = new BufferedImage[imageFiles.length];
                model.removeAllElements();
                for (int ii = 0; ii < im.length; ii++) {
                    paths.add(imageFiles[ii].getPath());
                    icons.add(new ImageIcon(imageFiles[ii].getPath()));
                    model.addElement(ImageIO.read(imageFiles[ii]));
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(jSplitPane, "Erreur lors du chargement des images", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_ChoisirFichierActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        PageAccueil p = new PageAccueil(this.personnel);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_QuitterActionPerformed
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
    private javax.swing.JButton ChoisirFichier;
    private javax.swing.JButton Enregistrer;
    private javax.swing.JList<String> Images;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Traiter;
    private javax.swing.JPanel barreDuHaut;
    private javax.swing.JButton jButtonDeco;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
