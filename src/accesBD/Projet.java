/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesBD;

import static accesBD.EcritureDMR.creerDMR;
import static accesBD.EcritureDPI.creerDPI;
import static accesBD.EcritureExamen.ajouterCompteRendu;
import static accesBD.EcritureExamen.ajouterLienPACS;
import static accesBD.EcritureExamen.creerExamen;
import static accesBD.LectureDPI.lireAdresse;
import static accesBD.LectureDPI.lireDateNaissance;
import static accesBD.LectureDPI.lireGenre;
import static accesBD.LectureDPI.lireIdDPI;
import static accesBD.LectureDPI.lireNomPatient;
import static accesBD.LectureDPI.lirePrenomPatient;


/**
 *
 * @author Chloé
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //ajout de DPI
        creerDPI(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        creerDPI(2, "Ferard", "Julie", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        creerDPI(3, "Jacob", "Edith", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        creerDPI(4, "Mathivet", "Marie", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        
        //lecture de DPI
        System.out.println(lireIdDPI("Mathivet", "Marie", "03/12/1995","FEMME"));
        System.out.println(lireNomPatient(3));
        System.out.println(lirePrenomPatient(2));
        System.out.println(lireDateNaissance(3));
        System.out.println(lireGenre(1));
        System.out.println(lireAdresse(3));
        
        //creation d'un DMR
        creerDMR(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        //test creation DMR avec meme idDMR
        //creerDMR(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        
        //creation d'un examen
        creerExamen(1,1,"18/02/2016",50,TypeExamen.SCANNER);
        //test creation patient avec meme idExamen
        //creerExamen(1,1,"18/02/2016",50,TypeExamen.SCANNER);
        //test creation examen avec idPatient qui n'exsite pas
        //creerExamen(2,2,"18/02/2016",50,TypeExamen.SCANNER);
        //test creation examen avec idResponsable qui n'exsite pas
        //creerExamen(2,1,"18/02/2016",100,TypeExamen.SCANNER);
        //creation d'un 2eme examen
        creerExamen(2,1,"18/02/2016",50,TypeExamen.SCANNER);
        
//        ajout d'un compte rendu
        ajouterCompteRendu(1,"Good");
//        ajout d'un lien PACS
        ajouterLienPACS(1,"lien");
        
    }
    
}
