package Processir.nf;

import java.util.Date;

public class Examen {

    private DMR dmr;
    private Date date;
    private CompteRendu compteRendu;
    private TypeExamen typeExamen;
    private String PACS;

    public Examen(DMR dmr, Date date, CompteRendu compteRendu, TypeExamen typeExamen, String PACS) {
        this.dmr = dmr;
        this.date = date;
        this.compteRendu = compteRendu;
        this.typeExamen = typeExamen;
        this.PACS = PACS;
    }
    
    public String toString(){
        return "Patient "+this.dmr.getNom()+" "+this.dmr.getPrenom()+" Né le "+this.dmr.getDateNaissance()+"\nDate : "+date+"\n Type d'examen : "+typeExamen+"\n Compte-rendu : "+compteRendu+"\n N° PACS : "+PACS;
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
    public Date getDate() {
        return date;
    }

    //change la date de l'examen
    public void setDate(Date date) {
        this.date = date;
    }

    //retourne le compte rendu
    public CompteRendu getCompteRendu() {
        return compteRendu;
    }

    //change le compte rendu
    public void setCompteRendu(CompteRendu compteRendu) {
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

}
