/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.EcritureDMR.creerDMR;
import static BD.EcritureDMR.genererDMR;
import static BD.EcritureDPI.creerDPI;
import static BD.EcritureExamen.ajouterCompteRendu;
import static BD.EcritureExamen.ajouterLienPACS;
import static BD.EcritureExamen.creerExamen;
import static BD.LectureDMR.existenceDMR;
import static BD.LectureDPI.existenceDPI;
import static BD.LectureDPI.lireAdresse;
import static BD.LectureDPI.lireDateNaissance;
import static BD.LectureDPI.lireGenre;
import static BD.LectureDPI.lireIdDPI;
import static BD.LectureDPI.lireNomPatient;
import static BD.LectureDPI.lirePrenomPatient;


/**
 *
 * @author Chloé
 */
public class TestsBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creation de DMR
        //creerDMR(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        //test creation DMR avec meme idDMR
        //ne fonctionne pas
        //creerDMR(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");  
        
        //creation de DPI
        //creerDPI(1, "Cazaux", "Chloe", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        //creerDPI(2, "Ferard", "Julie", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        //creerDPI(3, "Jacob", "Edith", "03/12/1995", Genre.FEMME, "2 cours Liberation");
        //creerDPI(4, "Mathivet", "Marie", "03/12/1995", Genre.FEMME, "2 cours Liberation");  
        
        //lecture de DPI
        //System.out.println(lireIdDPI("Mathivet", "Marie", "03/12/1995","FEMME"));
        //System.out.println(lireNomPatient(3));
        //System.out.println(lirePrenomPatient(2));
        //System.out.println(lireDateNaissance(3));
        //System.out.println(lireGenre(1));
        //System.out.println(lireAdresse(3));
                
        //existence de DMR
        //true
        //System.out.println(existenceDMR("Cazaux","Chloe","03/12/1995","FEMME"));
        //false
        //System.out.println(existenceDMR("Ferard","Chloe","03/12/1995","FEMME"));
        
        //existence de DPI
        //true
        //System.out.println(existenceDPI("Cazaux","Chloe","03/12/1995","FEMME"));
        //false
        //System.out.println(existenceDPI("Ferard","Chloe","03/12/1995","FEMME"));

        //remplissage DMR a partir DPI
        //genererDMR(4);
        
        //creation d'un examen
        //creerExamen(1,1,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation patient avec meme idExamen
        //creerExamen(1,1,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation examen avec idPatient qui n'exsite pas
        //creerExamen(2,2,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation examen avec idResponsable qui n'exsite pas
        //creerExamen(2,1,"18/02/2016",100,TypeExamen.SCANNER);
        //creation d'un 2eme examen
        //creerExamen(2,1,"18/02/2016",1,TypeExamen.SCANNER);
        
        //ajout d'un compte rendu
        //ajouterCompteRendu(1,"Good");
        //ajout d'un lien PACS
        //ajouterLienPACS(1,"lien");
        
    }
    
}
