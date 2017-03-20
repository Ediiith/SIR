package NF;

import static BD.EcritureExamen.ajouterCompteRendu;
import static BD.EcritureExamen.ajouterLienPACS;
import static BD.EcritureExamen.creerExamen;
import static BD.LectureExamen.existenceExamen;
import static BD.LectureExamen.lireCompteRendu;
import static BD.LectureExamen.lireIdExamen;
import static BD.LectureExamen.lireLienPACS;

/**
 *
 * @author Edith
 */
public class Examen {

    private int idExamen;
    private DMR dmr;
    private String date;
    private Personnel praticien;
    private TypeExamen typeExamen;
    private String compteRendu;
    private String PACS;

    //constructeur en connaissant dmr, date examen, personnel responsable, type examen
    public Examen(DMR dmr, String dateExamen, Personnel personnel, TypeExamen typeExamen) {
        if (existenceExamen(dmr.getIdDMR(), dateExamen, personnel.getIdPersonnel(), typeExamen) == true) {
            this.idExamen = lireIdExamen(dmr.getIdDMR(), dateExamen, personnel.getIdPersonnel(), typeExamen);
            this.dmr = dmr;
            this.date = dateExamen;
            this.praticien = personnel;
            this.typeExamen = typeExamen;
            this.compteRendu = lireCompteRendu(this.idExamen);
            this.PACS = lireLienPACS(this.idExamen);
        }
    }

    //si necessaire on peut faire constructeur en conaissant seulement dmr et praticien
    //constructeur pour creer un examen
    public Examen(int idExamen, DMR dmr, String dateExamen, Personnel personnel, TypeExamen typeExamen) {
        this.idExamen = idExamen;
        this.dmr = dmr;
        this.date = dateExamen;
        this.praticien = personnel;
        this.typeExamen = typeExamen;
        this.compteRendu = null;
        this.PACS = null;
        creerExamen(idExamen, dmr.getIdDMR(), date, praticien.getIdPersonnel(), typeExamen);
    }

    @Override
    public String toString() {
        return "Patient " + this.dmr.getNomPatient() + " " + this.dmr.getPrenomPatient() + " Né(e) le " + this.dmr.getDateNaissance() + "\nDate : " + date + "\n Type d'examen : " + typeExamen + "\n Compte-rendu : " + compteRendu + "\n N° PACS : " + PACS;
    }

    //retourne l'identifiant de l'examen
    public int getIdExamen() {
        return idExamen;
    }

    //retourne le DMR
    public DMR getDMR() {
        return dmr;
    }

    //retourne la date de l'examen
    public String getDate() {
        return date;
    }

    //retourne le praticien responsable
    public Personnel getPraticien() {
        return praticien;
    }

    //retourne le type d'examen
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    //retourne le compte rendu
    public String getCompteRendu() {
        return compteRendu;
    }

    //change le compte rendu
    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
        ajouterCompteRendu(this.getIdExamen(), compteRendu);
    }

    //retourne le lien vers le PACS
    public String getPACS() {
        return PACS;
    }

    //change le lien vers le PACS
    public void setPACS(String PACS) {
        this.PACS = PACS;
        ajouterLienPACS(this.getIdExamen(), PACS);
    }

    //VOIR SI NECESSAIRE
    //change le DMR
    public void setPatient(DMR dmr) {
        this.dmr = dmr;
    }

    //change la date de l'examen
    public void setDate(String date) {
        this.date = date;
    }

    //change le type d'examen
    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

}
