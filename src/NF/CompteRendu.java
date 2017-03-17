package NF;

import static BD.LectureExamen.lireCompteRendu;
import static BD.LectureExamen.lireIdResponsable;

public class CompteRendu {

    private Personnel praticien;

    private String bilan;

    // constructeur 
    public CompteRendu(Examen examen) {
        this.praticien = new Personnel(lireIdResponsable(examen.getIdExamen()));
        this.bilan = lireCompteRendu(examen.getIdExamen());
    }

    //retourne le praticien
    public Personnel getPraticien() {
        return praticien;
    }

    //change le praticien
    public void setPraticien(Personnel praticien) {
        this.praticien = praticien;
    }

    //retourne le bilan
    public String getBilan() {
        return bilan;
    }

    //change le bilan
    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

}
