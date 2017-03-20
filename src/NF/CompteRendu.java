package NF;

import static BD.LectureExamen.lireCompteRendu;

public class CompteRendu {

    private Personnel praticien;
    private String bilan;

    // constructeur à partir d'un examen
    public CompteRendu(Examen examen) {
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
