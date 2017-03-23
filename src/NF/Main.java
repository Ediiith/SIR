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
                    //this.dispose();
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
                    System.out.println("--");
                 //   if (p.getAdresse().getStreetName() != null) {
//                        connexionBD.insererDB("UPDATE patients SET adresse='" + p.getAdresse().getStreetName() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getAdresse().getPostalCode() != null) {
//                        connexionBD.insererDB("UPDATE patients SET code_postal='" + p.getAdresse().getPostalCode() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getAdresse().getCity() != null) {
//                        connexionBD.insererDB("UPDATE patients SET ville='" + p.getAdresse().getCity() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getAdresse().getCountry() != null) {
//                        connexionBD.insererDB("UPDATE patients SET pays='" + p.getAdresse().getCountry() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getEmailAddress() != null) {
//                        connexionBD.insererDB("UPDATE patients SET email='" + p.getEmailAddress() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getPhoneNumber() != null) {
//                        connexionBD.insererDB("UPDATE patients SET tel_1='" + p.getPhoneNumber() + "' WHERE id_p=" + p.getID());
//                    }
//                    if (p.getPhoneNumber2() != null) {
//                        connexionBD.insererDB("UPDATE patients SET tel_2='" + p.getPhoneNumber2() + "' WHERE id_p=" + p.getID());
                    
                }
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Problème de connection à la base de données");
        }
    }

    public static ConnexionBD getConnexionBD() {
        return connexionBD;
    }
//        //Test de liste DMR proches
//        Date d1 = new Date(05,12,1990);
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET", "Marie", d1.toString(), g1, 123);
//        DMR dmr2 = new DMR("MATIVE","Mary",d1.toString(),g1, 356);
//        DMR dmr3 = new DMR("Ferard","Julie",d1.toString(),g1, 532);
//        
//        ListeDMR LD=new ListeDMR();
//        
//        LD.ajouterDMR(dmr2);
//        LD.ajouterDMR(dmr1);
//        LD.ajouterDMR(dmr3);
//        
//        System.out.println(LD.afficher());
//        System.out.println(LD.afficherDMRproches(dmr1));

//        
//        //Test de la liste de DMR
//        Date d1 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-07 23h45");
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET", "Marie", d1, 334, "1 place dubedout", 001, g1,true);
//        DMR dmr2 = new DMR("MATIVE","Mary",d1,334,"1 place dubedout",001,g1,false);
//        
//        ListeDMR LD=new ListeDMR();
//        
//        LD.ajouterDMR(dmr2);
//        LD.ajouterDMR(dmr1);
//        
//        System.out.println(LD.nombreDMR());
//        System.out.println(LD.afficherDMRAdmis());
//        //Test d'affichage d'un DMR
//        Date d1 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-07 23h45");
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1,true);
//        
//        //Test de comparaison de deux DMR proches
//        Date d1 = new Date(System.currentTimeMillis()); 
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1,true);
//        
//        DMR dmr2 = new DMR("MATIVE","Mary",d1,334,"1 place dubedout",001,g1);
//        
//        System.out.println("Les deux DMR sont semblables : " +dmr1.procheDe(dmr2));
//        //Test de la fonction levenshtein
//        Date n1 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-07 23h45");
//        Date n2 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-05 23h00");
//        
//        String str1 = n1.toString();
//        String str2 = n2.toString();
//        
//        Levenshtein l = new Levenshtein();
//
//        int result = l.levenshtein(str2, str1);
//        System.out.println("Les deux phrases sont semblables à : " + result);
//        //Test de la fonction min(int,int,int)
//        int a=7;
//        int b=7;
//        int c=9;
//        Levenshtein l = new Levenshtein();
//        System.out.println("Le minimum entre "+a+", "+b+" et "+c+" est : "+l.min(a,b,c));
//        //Test de comparaison de 2 instances de DMR
//        Date d1 = new Date(System.currentTimeMillis()); 
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        DMR dmr2 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        System.out.println("Les deux DMR sont semblables : " +dmr1.equals(dmr2));
//        //Test de comparaison de 2 instances de Personnel
//        Statut t1 = Statut.MANIPULATEUR;
//        Personnel p1= new Personnel("JACOB","Edith","JE","edith",t1,true);
//              
//        Statut t2 = Statut.RADIOLOGUE;
//        Personnel p2= new Personnel("CAZAUX","Chloé","CC","choe",t2,false); 
//        
//        Personnel p3= new Personnel("CAZAUX","Chloé","CC","choe",t1,false); 
//        
//        System.out.println("P2 égal P3 : "+p2.equals(p3));
}
