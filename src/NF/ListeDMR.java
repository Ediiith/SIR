package NF;

/**
 *
 * @author JEMCare Solution
 */

import static BD.LectureDMR.listeIdDMR;
import java.util.ArrayList;
import java.util.List;

public class ListeDMR {

    public List<DMR> listeDMR;

    //constructeur
    public ListeDMR() {
        listeDMR = new ArrayList<DMR>();
    }

    //remplissage listeDMR avec tous les dmr de la base de données
    public void remplissageListeDMR() {
        for (int i = 0; i < listeIdDMR().size(); i++) {
            DMR dmr = new DMR(listeIdDMR().get(i));
            ajouterDMR(dmr);
        }
    }

    //ajoute un DMR à listeDMR
    public void ajouterDMR(DMR dmr) {
        listeDMR.add(dmr);
    }

    //retourne listeDMR
    public List<DMR> getListeDMR() {
        return listeDMR;
    }
    
    //retourne la liste des DMR admis
    public List<DMR> getListeDMRadmis() {
        List<DMR> listeDMRadmis = new ArrayList<DMR>();
        for (int i = 0; i < listeDMR.size(); i++) {
            DMR dmr = listeDMR.get(i);
            if(dmr.getEstAdmis()){
                listeDMRadmis.add(dmr);
            }
        }
        return listeDMRadmis;
    }

    //retourne le nombre de DMR enregistrés dans le système
    public String nombreDMR() {
        String s;
        s = "> Nombre de DMR : ";
        return s + listeDMR.size() + "\n";
    }

    //retourne tous les DMR
    public String afficherListeDMR() {
        String s;
        s = (listeDMR.size() + " dossiers medicaux radiologiques :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < listeDMR.size(); i++) {
            DMR dmr = listeDMR.get(i);
            s = s + dmr.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
        }
        return s;
    }

    //retourne la liste des DMR proches de la recherche
    public String afficherListeDMRproches(DMR dmr) {
        String s;
        s = ("Liste des DMR proches de la recherche :\n-----------------------------------------------------------------------------------------\n");
        for (int i = 0; i < listeDMR.size(); i++) {
            if (listeDMR.get(i).procheDe(dmr)) {
                DMR dmrP = listeDMR.get(i);
                s = s + dmrP.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
            }
        }
        return s;
    }

    //retourne tous les DMR admis
    public String afficherListeDMRAdmis() {
        String s;
        s = ("Patients admis en radiologie :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < listeDMR.size(); i++) {
            if (listeDMR.get(i).getEstAdmis() == true) {
                DMR dmrA = listeDMR.get(i);
                s = s + dmrA.afficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
            }
        }
        return s;
    }

}
