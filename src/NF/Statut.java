package NF;

//Enumération des différents statuts professionnels
public enum Statut {

RADIOLOGUE("Radiologue"),

MANIPULATEUR("Manipulateur"),

SECRETAIRE("Secretaire"),

CHEF_SERVICE("Chef de service");

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