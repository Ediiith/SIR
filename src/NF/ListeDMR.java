package NF;

/**
 *
 * @author JEMCare Solution
 */

import static BD.LectureDMR.listeIdDMR;
import java.util.ArrayList;
import java.util.List;

public class ListeDMR {

    public static List<DMR> listeDMR;

    //constructeur
    public ListeDMR() {
        this.listeDMR = new ArrayList<DMR>();
        for (int i = 0; i < listeIdDMR().size(); i++) {
            DMR dmr = new DMR(listeIdDMR().get(i));
            ajouterDMR(dmr);
        }
    }

    //ajoute un DMR à listeDMR
    public static void ajouterDMR(DMR dmr) {
        getListeDMR().add(dmr);
    }

    //retourne listeDMR
    public static List<DMR> getListeDMR() {
        return listeDMR;
    }
    
    //retourne la liste des DMR admis
    public static List<DMR> getListeDMRadmis() {
        List<DMR> listeDMRadmis = new ArrayList<DMR>();
        for (int i = 0; i < getListeDMR().size(); i++) {
            DMR dmr = getListeDMR().get(i);
            if(dmr.getEstAdmis()){
                listeDMRadmis.add(dmr);
            }
        }
        return listeDMRadmis;
    }

    //ajoute un DMR a listeDMRadmis
    public static void ajouterDMRadmis(DMR dmr) {
        getListeDMRadmis().add(dmr);
    }
    
    //supprime un DMR de listeDMRadmis
    public static void supprimerDMRadmis(DMR dmr) {
        getListeDMRadmis().remove(dmr);
    }
    
    //retourne la liste des DMR proches
    public static List<DMR> getListeDMRproches(String nom, String prenom, String date) {
        List<DMR> listeDMRproches = new ArrayList<DMR>();
        for (int i = 0; i < getListeDMR().size(); i++) {
            DMR dmr = getListeDMR().get(i);
            if(dmr.procheDe(nom, prenom, date)){
                listeDMRproches.add(dmr);
            }
        }
        return listeDMRproches;
    }
    
    //retourne le nombre de DMR enregistrés dans le système
    public static String nombreDMR() {
        String s;
        s = "> Nombre de DMR : ";
        return s + getListeDMR().size() + "\n";
    }

    //retourne tous les DMR
    public static String afficherListeDMR() {
        String s;
        s = (getListeDMR().size() + " dossiers medicaux radiologiques :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < getListeDMR().size(); i++) {
            DMR dmr = getListeDMR().get(i);
            s = s + dmr.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
        }
        return s;
    }

    //retourne la liste des DMR proches de la recherche
    public static String afficherListeDMRproches(DMR dmr) {
        String s;
        s = ("Liste des DMR proches de la recherche :\n-----------------------------------------------------------------------------------------\n");
        for (int i = 0; i < getListeDMR().size(); i++) {
            if (getListeDMR().get(i).procheDe(dmr.getNomPatient(),dmr.getPrenomPatient(),dmr.getDateNaissance())) {
                DMR dmrP = getListeDMR().get(i);
                s = s + dmrP.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
            }
        }
        return s;
    }

    //retourne tous les DMR admis
    public static String afficherListeDMRAdmis() {
        String s;
        s = ("Patients admis en radiologie :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < getListeDMR().size(); i++) {
            if (getListeDMR().get(i).getEstAdmis() == true) {
                DMR dmrA = getListeDMR().get(i);
                s = s + dmrA.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
            }
        }
        return s;
    }

}
