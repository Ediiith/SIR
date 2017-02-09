package Processir;

import java.util.Date;

public class Examen {

    private Patient patient;

    private Date date;

    private CompteRendu compteRendu;

    private TypeExamen typeExamen;

    private String PACS;

    public Examen(Patient patient, Date date, CompteRendu compteRendu, TypeExamen typeExamen, String PACS) {
        this.patient = patient;
        this.date = date;
        this.compteRendu = compteRendu;
        this.typeExamen = typeExamen;
        this.PACS = PACS;
    }

    //retourne le patient
    public Patient getPatient() {
        return patient;
    }

    //change le patient
    public void setPatient(Patient patient) {
        this.patient = patient;
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
