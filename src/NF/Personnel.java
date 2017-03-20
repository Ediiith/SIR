package NF;

import static BD.EcriturePersonnel.ajouterMdp;
import static BD.EcriturePersonnel.creerProfessionnel;
import static BD.LecturePersonnel.existenceIdPersonnel;
import static BD.LecturePersonnel.existencePersonnel;
import static BD.LecturePersonnel.lireIdPersonnel;
import static BD.LecturePersonnel.lireMdp;
import static BD.LecturePersonnel.lireStatut;
import static BD.LecturePersonnel.lireNomPersonnel;
import static BD.LecturePersonnel.lirePrenomPersonnel;

public class Personnel {

    private int idPersonnel;
    private String mdp;
    private String nomPersonnel;
    private String prenomPersonnel;
    private Statut statut;

    //constructeur en connaissant nom, prenom, statut du professionnel
    public Personnel(String nomPersonnel, String prenomPersonnel, Statut statut) {
        if (existencePersonnel(nomPersonnel, prenomPersonnel, statut) == true) {
            this.idPersonnel = lireIdPersonnel(nomPersonnel, prenomPersonnel, statut);
            this.mdp = lireMdp(idPersonnel);
            this.nomPersonnel = nomPersonnel;
            this.prenomPersonnel = prenomPersonnel;
            this.statut = statut;
        }
    }

    //constructeur en connaissant l'identifiant du professionnel
    public Personnel(int idPersonnel) {
        if (existenceIdPersonnel(idPersonnel) == true) {
            this.idPersonnel = idPersonnel;
            this.mdp = lireMdp(idPersonnel);
            this.nomPersonnel = lireNomPersonnel(idPersonnel);
            this.prenomPersonnel = lirePrenomPersonnel(idPersonnel);
            this.statut = lireStatut(idPersonnel);
        }
    }

    //constructeur qui creer un professionnel
    public Personnel(int idPersonnel, String mdp, String nomPersonnel, String prenomPersonnel, Statut statut) {
        this.idPersonnel = idPersonnel;
        this.mdp = mdp;
        this.nomPersonnel = nomPersonnel;
        this.prenomPersonnel = prenomPersonnel;
        this.statut = statut;
        creerProfessionnel(idPersonnel, mdp, nomPersonnel, prenomPersonnel, statut);
    }

    //affiche les informations du professionnel    
    public String toString() {
        return this.nomPersonnel + " " + this.prenomPersonnel;
    }

    //vérifie si deux instances de Personnel sont égales
    public boolean equals(Object o) {
        if (o instanceof Personnel) {
            Personnel p = (Personnel) o;
            return this.nomPersonnel.equals(p.nomPersonnel) && this.prenomPersonnel.equals(p.prenomPersonnel) && this.statut.equals(p.statut);
        } else {
            return false;
        }
    }

    //retourne l'identifiant du professionnel
    public int getIdPersonnel() {
        return idPersonnel;
    }

    //retourne le mot de passe du professionnel
    public String getMdp() {
        return mdp;
    }

    //change le mot de passe du professionnel
    public void setMdp(String ancienMdp, String nouveauMdp) {
        this.mdp = mdp;
        ajouterMdp(this.getIdPersonnel(), ancienMdp, nouveauMdp);
    }

    //retourne le nom du professionnel
    public String getNomPersonnel() {
        return nomPersonnel;
    }

    //retourne le prenom du professionnel
    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    //retourne le statut du professionnel
    public Statut getStatut() {
        return statut;
    }

    
    //VOIR SI UTILE 
    
    //change le nom du professionnel
    public void setNomPersonnel(String nomPersonnel) {
        this.nomPersonnel = nomPersonnel;
    }

    //change le prenom du professionnel
    public void setPrenomPersonnel(String prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    //change l'identifiant du professionnel
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    //change le statut du professionnel
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
}
