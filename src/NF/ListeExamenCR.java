/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chloé
 */

public class ListeExamenCR {
    
    public static List<Examen> listeExamenCR;

    //constructeur
    public ListeExamenCR() {
        listeExamenCR = new ArrayList<Examen>();
    }

    //ajoute un examen a listeExamenCR
    public static void ajouterExamenCR(Examen examen) {
        listeExamenCR.add(examen);
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
            s = s+ examen.toString() + "\n--------------------------------------------------------------------------------------------\n";
        }
        return s;
    }
    
}
