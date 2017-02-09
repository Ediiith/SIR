package Processir;

import java.util.Date;

public class Patient {

    private String nom;

    private String prenom;

    private Date dateNaissance;

    public Patient(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
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

}
