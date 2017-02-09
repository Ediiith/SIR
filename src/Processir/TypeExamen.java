package Processir;

//Enumeration des différents types d'examens
public enum TypeExamen {

    SCANNER("Scanner"),
    IRM("IRM"),
    RADIOGRAPHIE("Radiographie");

    //attributs de l'énumération
    private String libelle;

//constructeur
    private TypeExamen(String libelle) {
        this.libelle = libelle;
    }
//méthode

    @Override
    public String toString() {
        return libelle;
    }

}
