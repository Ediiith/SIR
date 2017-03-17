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
import static BD.EcriturePersonnel.creerProfessionnel;
import static BD.LectureDMR.existenceDMR;
import static BD.LectureDMR.lireAdresse_fromDMR;
import static BD.LectureDMR.lireDateNaissance_fromDMR;
import static BD.LectureDMR.lireGenre_fromDMR;
import static BD.LectureDMR.lireIdDMR_fromDMR;
import static BD.LectureDMR.lireNomPatient_fromDMR;
import static BD.LectureDMR.lirePrenomPatient_fromDMR;
import static BD.LectureDPI.existenceDPI;
import static BD.LectureDPI.lireAdresse_fromDPI;
import static BD.LectureDPI.lireDateNaissance_fromDPI;
import static BD.LectureDPI.lireGenre_fromDPI;
import static BD.LectureDPI.lireIdDPI;
import static BD.LectureDPI.lireNomPatient_fromDPI;
import static BD.LectureDPI.lirePrenomPatient_fromDPI;
import static BD.LectureExamen.lireCompteRendu;
import static BD.LectureExamen.lireDateExamen;
import static BD.LectureExamen.lireIdDMR_fromExamen;
import static BD.LectureExamen.lireIdExamen;
import static BD.LectureExamen.lireIdResponsable;
import static BD.LectureExamen.lireLienPACS;
import static BD.LectureExamen.lireTypeExamen;
import static BD.LecturePersonnel.lireIdPersonnel;
import static BD.LecturePersonnel.lireStatut;
import static BD.LecturePersonnel.lireNomPersonnel;
import static BD.LecturePersonnel.lirePrenomPersonnel;
import NF.Genre;
import NF.Statut;
import NF.TypeExamen;


/**
 *
 * @author Chloé
 */
public class TestsBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //TESTS ECRITURE
        
        //creation de DMR
        creerDMR(1, "Cazaux", "Chloe", "01/12/1995", Genre.FEMME, "1 cours Liberation");
        //test creation DMR avec meme idDMR
        //ne fonctionne pas
        creerDMR(1, "Cazaux", "Chloe", "01/12/1995", Genre.FEMME, "1 cours Liberation");  
        
        //creation de DPI
        creerDPI(1, "Cazaux", "Chloe", "01/12/1995", Genre.FEMME, "1 cours Liberation");
        creerDPI(2, "Ferard", "Julie", "02/12/1995", Genre.FEMME, "2 cours Liberation");
        creerDPI(3, "Jacob", "Edith", "03/12/1995", Genre.FEMME, "3 cours Liberation");
        creerDPI(4, "Mathivet", "Marie", "04/12/1995", Genre.FEMME, "4 cours Liberation");  
                
        //generation DMR a partir DPI
        genererDMR(4);
        //test generation DMR a partir DPI qui n'existe pas
        //ne fonctionne pas
        //genere des null, essayer un if
        genererDMR(40);
        
        //creation d'un personnel
        creerProfessionnel(1, "azerty", "Propro", "Manu", Statut.RADIOLOGUE);
        
        //creation d'un examen
        creerExamen(1,1,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation examen avec meme idExamen
        //ne fonctionne pas
        creerExamen(1,1,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation examen avec idDMR qui n'existe pas
        //ne fonctionne pas
        creerExamen(2,2,"18/02/2016",1,TypeExamen.SCANNER);
        //test creation examen avec idResponsable qui n'exsite pas
        //ne fonctionne pas
        creerExamen(2,1,"18/02/2016",100,TypeExamen.SCANNER);
        
        //ajout d'un compte rendu
        ajouterCompteRendu(1,"Good");
        //test ajout d'un compte rendu a un examen qui n'existe pas
        ajouterCompteRendu(10,"Good");
        
        //ajout d'un lien PACS
        ajouterLienPACS(1,"lien");
        //test ajout d'un lien PACS a un examen qui n'existe pas
        ajouterLienPACS(10,"lien");
        
        
        //TESTS LECTURE
                
        //existence de DPI
        //true
        System.out.println(existenceDPI("Cazaux","Chloe","01/12/1995",Genre.FEMME));
        //false
        System.out.println(existenceDPI("Ferard","Chloe","01/12/1995",Genre.FEMME));
        
        //lecture de DPI
        System.out.println(lireIdDPI("Mathivet", "Marie", "04/12/1995",Genre.FEMME));
        System.out.println(lireNomPatient_fromDPI(3));
        System.out.println(lirePrenomPatient_fromDPI(2));
        System.out.println(lireDateNaissance_fromDPI(3));
        System.out.println(lireGenre_fromDPI(1));
        System.out.println(lireAdresse_fromDPI(3));
        
        //lecture de DPI qui n'existe pas
        //ne fonctionne pas
        //peut être retourner DPI n'existe pas au lieu de 0 ou null (pareil pour DMR et examens)
        System.out.println(lireIdDPI("Mathivet", "Chloe", "04/12/1995",Genre.FEMME));
        System.out.println(lireNomPatient_fromDPI(100));
        System.out.println(lirePrenomPatient_fromDPI(100));
        System.out.println(lireDateNaissance_fromDPI(100));
        System.out.println(lireGenre_fromDPI(100));
        System.out.println(lireAdresse_fromDPI(100));
        
        //existence de DMR
        //true
        System.out.println(existenceDMR("Cazaux","Chloe","01/12/1995",Genre.FEMME));
        //false
        System.out.println(existenceDMR("Ferard","Chloe","01/12/1995",Genre.FEMME));
        
        //lecture de DMR
        System.out.println(lireIdDMR_fromDMR("Mathivet", "Marie", "04/12/1995",Genre.FEMME));
        System.out.println(lireNomPatient_fromDMR(1));
        System.out.println(lirePrenomPatient_fromDMR(4));
        System.out.println(lireDateNaissance_fromDMR(4));
        System.out.println(lireGenre_fromDMR(1));
        System.out.println(lireAdresse_fromDMR(4));
        
        //lecture de DMR qui n'existe pas
        //ne fonctionne pas
        System.out.println(lireIdDMR_fromDMR("Mathivet", "Chloe", "04/12/1995",Genre.FEMME));
        System.out.println(lireNomPatient_fromDMR(100));
        System.out.println(lirePrenomPatient_fromDMR(100));
        System.out.println(lireDateNaissance_fromDMR(100));
        System.out.println(lireGenre_fromDMR(100));
        System.out.println(lireAdresse_fromDMR(100));
        
        //lecture d'un examen
        System.out.println(lireIdExamen(1, "18/02/2016", 1, TypeExamen.SCANNER));
        System.out.println(lireIdDMR_fromExamen(1));
        System.out.println(lireDateExamen(1));
        System.out.println(lireIdResponsable(1));
        System.out.println(lireTypeExamen(1));
        System.out.println(lireCompteRendu(1));
        System.out.println(lireLienPACS(1));
        
        //lecture d'un examen qui n'existe pas
        //ne fonctionne pas
        System.out.println(lireIdExamen(2, "18/02/2016", 1, TypeExamen.SCANNER));
        System.out.println(lireIdDMR_fromExamen(10));
        System.out.println(lireDateExamen(10));
        System.out.println(lireIdResponsable(10));
        System.out.println(lireTypeExamen(10));
        System.out.println(lireCompteRendu(10));
        System.out.println(lireLienPACS(10));
        
        //lecture d'un professionnel
        System.out.println(lireIdPersonnel("Propro", "Manu", Statut.RADIOLOGUE));
        System.out.println(lireNomPersonnel(1));
        System.out.println(lirePrenomPersonnel(1));
        System.out.println(lireStatut(1));
        
        //lecture d'un professionnel qui n'existe pas
        //ne fonctionne pas
        System.out.println(lireIdPersonnel("Propro", "Emmanuel", Statut.RADIOLOGUE));
        System.out.println(lireNomPersonnel(10));
        System.out.println(lirePrenomPersonnel(10));
        System.out.println(lireStatut(10));
        
    }
    
}
