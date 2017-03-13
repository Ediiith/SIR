/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.List;
import java.util.Vector;

public class ListeDMR {

    private List<DMR> ListeDMR; 	// contient des objets de classe 'DMR'

    public ListeDMR() {
        ListeDMR = new Vector<DMR>(); //liste vide
    }

    //ajoute un DMR à la liste
    public void ajouterDMR(DMR dmr) {
        getDMR().add(dmr);
    }

    //retourne sous forme de liste l'ensemble des dmr
    public List<DMR> getDMR() {
        return ListeDMR;
    }

    //retourne le nombre de DMR enregistrés dans le système
    public String nombreDMR() {
        int nb = 0;
        String s;
        s = "> Nombre de DMR : ";
        return s + ListeDMR.size() + "\n";
    }
    
    //renvoie toutes les DMR
    public String afficher() {
        String s;
        s = ("Dossier medical radiologique :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < getDMR().size(); i++) {
            DMR dmr = getDMR().get(i);
            s = s + dmr.AfficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
        }
        return s;
    }
    
    //renvoie toutes les DMR admis
    public String afficherDMRAdmis() {
        String s;
        s = ("Patients admis en radiologie :\n--------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < getDMR().size(); i++) {
            if(getDMR().get(i).getEstAdmis()){
                DMR dmr = getDMR().get(i);
                s = s + dmr.AfficherInfoPatient() + "--------------------------------------------------------------------------------------------\n";
            }     
        }
        return s;
    }

}
