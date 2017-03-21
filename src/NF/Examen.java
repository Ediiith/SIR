package NF;

import static BD.EcritureExamen.ajouterCompteRendu;
import static BD.EcritureExamen.ajouterLienPACS;
import static BD.EcritureExamen.creerExamen;
import static BD.LectureExamen.existenceExamen;
import static BD.LectureExamen.genererIdExamen;
import static BD.LectureExamen.lireCompteRendu;
import static BD.LectureExamen.lireDateExamen;
import static BD.LectureExamen.lireLienPACS;
import static BD.LectureExamen.lireTypeExamen;

import static NF.ListeExamenCR.ajouterExamenCR;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Edith
 */

public class Examen {

    private int idExamen;
    private DMR dmr;
    private String dateExamen;
    private Personnel responsable;
    private TypeExamen typeExamen;
    private String compteRendu;
    private String lienPACS;
    
    private List<Examen> listeAjoutCR;

   // private List<Examen> listeAjoutCR = new ArrayList<Examen>();
    
    //constructeur en connaissant idExamen et dmr
    //si l'examen existe deja dans la base de donnees
    //pour remplir listeExamens
    public Examen(int idExamen, DMR dmr) {
        if (existenceExamen(idExamen) == true) {
            this.idExamen = idExamen;
            this.dmr = dmr;
            this.dateExamen = lireDateExamen(idExamen);
            //this.responsable = ;
            this.typeExamen = lireTypeExamen(idExamen);
            this.compteRendu = lireCompteRendu(idExamen);
            this.lienPACS = lireLienPACS(idExamen);
        }            
    }

    //constructeur pour creer un examen et l'ajouter a la base de donnees
    public Examen(DMR dmr, String dateExamen, Personnel responsable, TypeExamen typeExamen) {
        this.idExamen = genererIdExamen();
        this.dmr = dmr;
        this.dateExamen = dateExamen;
        this.responsable = responsable;
        this.typeExamen = typeExamen;
        this.compteRendu = null;
        this.lienPACS = null;
        this.dmr.ajouterExamen(this);

        //ajouterExamenCR(this);

        listeAjoutCR.add(this);

        creerExamen(idExamen, dmr.getIdDMR(), dateExamen, responsable.getIdPersonnel(), typeExamen);
    }
    //ne pas oublier dans le main lecr.ajouterExamenCR(examen)

    @Override
    //retourne les informations d'un examen
    public String toString() {
        return "Patient " + this.dmr.getNomPatient() + " " + this.dmr.getPrenomPatient() + " Né(e) le " + this.dmr.getDateNaissance() + "\n Date de l'examen : " + this.getDateExamen() + "\n Type d'examen : " + this.getTypeExamen() + "\n Compte-rendu : " + this.getCompteRendu() + "\n N° PACS : " + this.getLienPACS();
    }
    
    //retourne la liste des examens
    public List<Examen> getExamen(){
        return listeAjoutCR;
    }

    //retourne idExamen
    public int getIdExamen() {
        return idExamen;
    }

    //retourne dmr
    public DMR getDMR() {
        return dmr;
    }

    //retourne dateExamen
    public String getDateExamen() {
        return dateExamen;
    }

    //retourne responsable
    public Personnel getResponsable() {
        return responsable;
    }

    //retourne typeExamen
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    //retourne compteRendu
    public String getCompteRendu() {
        return compteRendu;
    }

    //change compteRendu
    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
        ajouterCompteRendu(this.getIdExamen(), compteRendu);
    }

    //retourne lienPACS
    public String getLienPACS() {
        return lienPACS;
    }

    //change lienPACS
    public void setLienPACS(String lienPACS) {
        this.lienPACS = lienPACS;
        ajouterLienPACS(this.getIdExamen(), lienPACS);
    }

    //retourne listeAjoutCR
    public List<Examen> getListeAjoutCR() {
        return listeAjoutCR;
    }
    
}

//    //VOIR SI NECESSAIRE
//    
//    //change  DMR
//    public void setDMR(DMR dmr) {
//        this.dmr = dmr;
//    }
//
//    //change dateExamen
//    public void setDateExamen(String dateExamen) {
//        this.dateExamen = dateExamen;
//    }
//
//    //change typeExamen
//    public void setTypeExamen(TypeExamen typeExamen) {
//        this.typeExamen = typeExamen;
//    }
//
//    //constructeur en connaissant dmr, dateExamen, responsable, typeExamen
//    //si l'examen existe deja dans la base de donnees
//    public Examen(DMR dmr, String dateExamen, Personnel responsable, TypeExamen typeExamen) {
//        if (existenceExamen(dmr.getIdDMR(), dateExamen, responsable.getIdPersonnel(), typeExamen) == true) {
//            this.idExamen = lireIdExamen(dmr.getIdDMR(), dateExamen, responsable.getIdPersonnel(), typeExamen);
//            this.dmr = dmr;
//            this.dateExamen = dateExamen;
//            this.responsable = responsable;
//            this.typeExamen = typeExamen;
//            this.compteRendu = lireCompteRendu(idExamen);
//            this.lienPACS = lireLienPACS(idExamen);
//            this.dmr.ajouterExamen(this);
//        }
//    }
