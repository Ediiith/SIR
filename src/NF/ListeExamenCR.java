/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import static NF.ListeDMR.getListeDMR;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chloé
 */
public class ListeExamenCR {

    public static List<Examen> listeExamenCR;  
    private ListeDMR ldmr;

    //constructeur
    public ListeExamenCR() {
        listeExamenCR = new ArrayList<Examen>();
        ldmr=new ListeDMR();
        for (int i = 0; i < getListeDMR().size(); i++) {
            for (int j = 0; j < getListeDMR().get(i).getListeExamens().size(); j++) {
                if (getListeDMR().get(i).getListeExamens().get(j).getCompteRendu()==null) {                    
                    ajouterExamenCR(getListeDMR().get(i).getListeExamens().get(j));
                }
            }
        }
    }

    //ajoute un examen a listeExamenCR
    public static void ajouterExamenCR(Examen examen) {
        listeExamenCR.add(examen);
    }

    //supprime un examen de listeExamenCR
    public static void supprimeExamenCR(Examen examen) {
        listeExamenCR.remove(examen);
    }

    //retourne listeDMR
    public static List<Examen> getListeExamenCR() {
        return listeExamenCR;
    }

    //retourne le nombre de DMR enregistrés dans le système
    public static String nombreExamenCR() {
        String s;
        s = listeExamenCR.size() + " comptes rendus d'examens à associer : \n--------------------------------------------------------------------------------------------\n";
        return s;
    }

    //retourne tous les DMR
    public static String afficherListeExamenCR() {
        String s;
        s = nombreExamenCR();
        for (int i = 0; i < listeExamenCR.size(); i++) {
            Examen examen = listeExamenCR.get(i);
            s = s + examen.toString() + "\n--------------------------------------------------------------------------------------------\n";
        }
        return s;
    }

}
