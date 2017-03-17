package NF;

import static BD.LectureExamen.lireCompteRendu;
import static BD.LectureExamen.lireDateExamen;
import static BD.LectureExamen.lireIdDMR_fromExamen;
import static BD.LectureExamen.lireIdExamen;
import static BD.LectureExamen.lireIdResponsable;
import static BD.LectureExamen.lireLienPACS;
import static BD.LectureExamen.lireTypeExamen;
import UI.PageDeConnexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Edith
 */

public class Examen {

    private int idExamen;
    private DMR dmr;
    private String date;
    private final Personnel praticien;
    private TypeExamen typeExamen;
    private String compteRendu;
    private String PACS;
           
    // constructeur en connaissant idExamen    
    public Examen(int idExamen) {
        this.idExamen = idExamen;
        this.date = lireDateExamen(idExamen);
        this.praticien = new Personnel(lireIdResponsable(idExamen));
        this.typeExamen = lireTypeExamen(idExamen);
        this.compteRendu = lireCompteRendu(idExamen);
        this.PACS = lireLienPACS(idExamen);
        this.dmr = new DMR(lireIdDMR_fromExamen(idExamen));
    }
    
    // constructeur en connaissant dmr, date examen, responsable, type examen 
    public Examen(DMR dmr, String dateExamen, Personnel personnel, TypeExamen typeExamen) {
        this.idExamen = lireIdExamen(dmr.getIdDMR(), dateExamen, personnel.getIdPersonnel(), typeExamen);
        this.dmr = dmr;
        this.date = dateExamen;
        this.praticien = personnel;
        this.typeExamen = typeExamen;
        this.compteRendu = lireCompteRendu(this.idExamen);
        this.PACS = lireLienPACS(this.idExamen);
    }
    
    @Override
    public String toString(){
        return "Patient "+this.dmr.getNomPatient()+" "+this.dmr.getPrenomPatient()+" Né(e) le "+this.dmr.getDateNaissance()+"\nDate : "+date+"\n Type d'examen : "+typeExamen+"\n Compte-rendu : "+compteRendu+"\n N° PACS : "+PACS;
    }

    //retourne le DMR
    public DMR getPatient() {
        return dmr;
    }

    //change le patient
    public void setPatient(DMR dmr) {
        this.dmr = dmr;
    }

    //retourne la date de l'examen
    public String getDate() {
        return date;
    }

    //change la date de l'examen
    public void setDate(String date) {
        this.date = date;
    }

    //retourne le compte rendu
    public String getCompteRendu() {
        return compteRendu;
    }

    //change le compte rendu
    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    //retourne le type d'examen
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    //change le type d'examen
    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

    //retourne le lien vers le PACS
    public String getPACS() {
        return PACS;
    }

    //change le lien vers le PACS
    public void setPACS(String PACS) {
        this.PACS = PACS;
    }
    
    //retour le praticien qui a rédigé le compte rendu
    public Personnel getPraticien(){
        return praticien;
    }
    
    //retourne l'id de l'examen
    public int getIdExamen() {
        return idExamen;
    }
    
}


