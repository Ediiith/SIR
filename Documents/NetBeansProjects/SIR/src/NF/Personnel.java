package NF;

import static BD.LecturePersonnel.lireIdPersonnel;
import static BD.LecturePersonnel.lireStatut;
import static BD.LecturePersonnel.lireNomPersonnel;
import static BD.LecturePersonnel.lirePrenomPersonnel;

public class Personnel {

    private int idPersonnel;
    private String mdp;
    private String nomPersonnel;
    private String prenomPersonnel;
    private Statut statut;

    private boolean chefService;

    //constructeur en connaisant nom, prenom, statut du professionnel
    public Personnel(String nomPersonnel, String prenomPersonnel, Statut statut) {
        this.idPersonnel = lireIdPersonnel(nomPersonnel, prenomPersonnel, statut);
        this.nomPersonnel = nomPersonnel;
        this.prenomPersonnel = prenomPersonnel;
        this.statut = statut;
    }

    //constructeur en conaissant idPersonnel
    public Personnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
        this.nomPersonnel = lireNomPersonnel(idPersonnel);
        this.prenomPersonnel = lirePrenomPersonnel(idPersonnel);
        this.statut=lireStatut(idPersonnel);
    }

    //affiche les informations du professionnel
    public String toString() {
        return this.statut.toString() + " : " + this.nomPersonnel + " " + this.prenomPersonnel;
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

    //retourne le nom
    public String getNomPersonnel() {
        return nomPersonnel;
    }

    //change le nom
    public void setNomPersonnel(String nomPersonnel) {
        this.nomPersonnel = nomPersonnel;
    }

    //retourne le prénom
    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    //change le prénom
    public void setPrenomPersonnel(String prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    //retourne l'identifiant
    public int getIdPersonnel() {
        return idPersonnel;
    }

    //change l'identifiant
    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    //retourne le mot de passe
    public String getMdp() {
        return mdp;
    }

    //change le mot de passe
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    //retourne le statut professionnel
    public Statut getstatut() {
        return statut;
    }

    //change le statut professionnel
    public void setstatut(Statut statut) {
        this.statut = statut;
    }

    //retourne si le professionnel est le chef de service
    public boolean isChefService() {
        return chefService;
    }

    //change si le professionnel est le chef de service
    public void setChefService(boolean chefService) {
        this.chefService = chefService;
    }

}
