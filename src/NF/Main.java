package NF;

import UI.PageDeConnexion;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import library.interfaces.Patient;
import library.interfaces.ServeurHL7;
import library.structure.groupe.messages.Message;

public class Main {

    private static ConnexionBD connexionBD;

    public static void main(String[] args) throws ParseException {
        ServeurHL7 serveur;
        Integer port = 4444;
        String host = "130.190.108.227";
        serveur = new ServeurHL7();
        serveur.connection(port);
        library.interfaces.ClientHL7 c = new library.interfaces.ClientHL7();
        c.connexion(host, port);

        ConnexionBD connexionBD = new ConnexionBD("//localhost:3306/processir", "root", "SIR4");
        if (connexionBD.connect()) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2500);
                    } catch (Exception e) {
                    }
                    PageDeConnexion connexion = new PageDeConnexion();
                    connexion.setVisible(true);
                }
            }
            );
            while (true) {
                serveur.ecoute();
                serveur.protocole();
                Patient p = serveur.getPatient();
                Message m = serveur.getMessage();
                if (m.getName().equals("ADT_A01")) {
                    connexionBD.connect();
                    java.sql.Date date = new java.sql.Date(p.getBirth().getTime());
                    connexionBD.insererDB("INSERT INTO patients (id_p, nom_p, nom_naissance, prenom_p, date_naissance, genre) VALUES ("
                            + p.getID() + ", '"
                            + p.getFamillyName().toLowerCase() + "', '"
                            + p.getFamillyName().toLowerCase() + "', '"
                            + p.getFirstName().toLowerCase() + "', '"
                            + date + "', '"
                            + p.getCharSex() + "')");
                    System.out.println("-----------");

                }
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Problème de connection à la base de données");
        }
    }

    public static ConnexionBD getConnexionBD() {
        return connexionBD;
    }
}
