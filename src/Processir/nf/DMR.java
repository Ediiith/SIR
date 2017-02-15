package Processir.nf;

import java.util.Vector;
import java.util.Date;

public class DMR {

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private int numSS;

    private String adresse;

    private int numUnique;

    private Genre genre;

    private Vector examens;

    public DMR(String nom, String prenom, Date dateNaissance, int numSS, String adresse, int numUnique, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numSS = numSS;
        this.adresse = adresse;
        this.numUnique = numUnique;
        this.genre = genre;
    }
    
    public DMR(String nom, String prenom, Date dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    
    //compare si deux instances de DMR sont égales en tout points (sauf examens)
    public boolean equals(Object o){
        if (o instanceof DMR){
            DMR d = (DMR) o;
            return this.getNom().equals(d.getNom()) && this.getPrenom().equals(d.getPrenom()) 
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre())
                     && this.getAdresse().equals(d.getAdresse())
                    && this.getNumSS()==d.getNumSS()&& this.getNumUnique()==d.getNumUnique();
        }
        else{
            return false;
        }
    }
    
    

    //retourne le nom
    public String getNom() {
        return nom;
    }

    //change le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    //retourne le prénom
    public String getPrenom() {
        return prenom;
    }

    //change le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //retourne la date de naissance
    public Date getDateNaissance() {
        return dateNaissance;
    }

    //change la date de naissance
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    //retourne le numéro de sécurité sociale
    public int getNumSS() {
        return numSS;
    }

    //change le numéro de sécurité sociale
    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    //retourne l'adresse
    public String getAdresse() {
        return adresse;
    }

    //change l'adresse
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //retourne le numéro unique
    public int getNumUnique() {
        return numUnique;
    }

    //change le numéro unique
    public void setNumUnique(int numUnique) {
        this.numUnique = numUnique;
    }

    //retourne le genre sexuel
    public Genre getGenre() {
        return genre;
    }

    //change le genre sexuel
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    //retourne les examens
    public Vector getExamens() {
        return examens;
    }

    //change les examens
    public void setExamens(Vector examens) {
        this.examens = examens;
    }

}
