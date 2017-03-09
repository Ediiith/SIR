package NF;

public class CompteRendu {

    private Personnel praticien;

    private String bilan;

    // constructeur 
    public CompteRendu(Personnel praticien, String bilan) {
        this.praticien = praticien;
        this.bilan = bilan;
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
