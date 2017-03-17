package NF;

//Enumération des différents types de sexe
public enum Genre {

    FEMME("Femme"),
    HOMME("Homme"),
    AUTRE("Autre");

    //attributs de l'énumération
    private String libelle;

    //constructeur
    private Genre(String libelle) {
        this.libelle = libelle;
    }
//méthode

    @Override
    public String toString() {
        return libelle;
    }

}
