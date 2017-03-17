package NF;

import java.util.Date;

public class Patient {
    private String nom;
    private String prenom;
    private String genre;
    private Date dateDeNaissance;

    
    public Patient(String nom, String prenom, String genre,Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre=genre;
        this.dateDeNaissance=dateDeNaissance;
    
        }
    
    public String toString() {
        return getPrenom() + " " + getNom()+"  -  Genre :" + getGenre()+"  -  Date de naissance : "+getDateDeNaissance();
        }  

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the dateDeNaissance
     */
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    
    
    

}

