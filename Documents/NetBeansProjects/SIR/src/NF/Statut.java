package NF;

//Enumération des différents statuts professionnels
public enum Statut {

RADIOLOGUE("Radiologue"),

MANIPULATEUR("Manipulateur"),

INTERNE("Interne"),

SECRETAIRE("Secretaire");

//attributs de l'énumération
    private String libelle;

//constructeur
    private Statut(String libelle) {
        this.libelle = libelle;
    }
//méthode

    @Override
    public String toString() {
        return libelle;
    }
   
}