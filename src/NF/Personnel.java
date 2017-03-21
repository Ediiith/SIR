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

/**
 *
 * @author JEMCare Solution
 */

public class Personnel {

    private int idPersonnel;
    private String mdp;
    private String nomPersonnel;
    private String prenomPersonnel;
    private Statut statut;

    //constructeur en connaissant nomPersonnel, prenomPersonnel, statut
    //si le professionnel existe deja dans la base de donnees
    public Personnel(String nomPersonnel, String prenomPersonnel, Statut statut) {
        if (existencePersonnel(nomPersonnel, prenomPersonnel, statut) == true) {
            this.idPersonnel = lireIdPersonnel(nomPersonnel, prenomPersonnel, statut);
            this.mdp = lireMdp(idPersonnel);
            this.nomPersonnel = nomPersonnel;
            this.prenomPersonnel = prenomPersonnel;
            this.statut = statut;
        }
    }

    //constructeur en connaissant idPersonnel
    //si le professionnel existe deja dans la base de donnees
    public Personnel(int idPersonnel) {
        if (existenceIdPersonnel(idPersonnel) == true) {
            this.idPersonnel = idPersonnel;
            this.mdp = lireMdp(idPersonnel);
            this.nomPersonnel = lireNomPersonnel(idPersonnel);
            this.prenomPersonnel = lirePrenomPersonnel(idPersonnel);
            this.statut = lireStatut(idPersonnel);
        }
    }

    //constructeur pour creer un professionnel et l'ajouter a la base de donnees
    public Personnel(int idPersonnel, String mdp, String nomPersonnel, String prenomPersonnel, Statut statut) {
        this.idPersonnel = idPersonnel;
        this.mdp = mdp;
        this.nomPersonnel = nomPersonnel;
        this.prenomPersonnel = prenomPersonnel;
        this.statut = statut;
        creerProfessionnel(idPersonnel, mdp, nomPersonnel, prenomPersonnel, statut);
    }

    //retourne les informations d'un professionnel    
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
    
    //retourne idPersonnel
    public int getIdPersonnel() {
        return idPersonnel;
    }

    //retourne mdp
    public String getMdp() {
        return mdp;
    }

    //change mdp
    public void setMdp(String ancienMdp, String nouveauMdp) {
        this.mdp = nouveauMdp;
        ajouterMdp(this.getIdPersonnel(), ancienMdp, nouveauMdp);
    }

    //retourne nomPersonnel
    public String getNomPersonnel() {
        return nomPersonnel;
    }

    //retourne prenomPersonnel
    public String getPrenomPersonnel() {
        return prenomPersonnel;
    }

    //retourne statut
    public Statut getStatut() {
        return statut;
    }
    
}

//    //VOIR SI UTILE 
//    
//    //change nomPersonel
//    public void setNomPersonnel(String nomPersonnel) {
//        this.nomPersonnel = nomPersonnel;
//    }
//
//    //change prenomPersonnel
//    public void setPrenomPersonnel(String prenomPersonnel) {
//        this.prenomPersonnel = prenomPersonnel;
//    }
//
//    //change idPersonnel
//    public void setIdPersonnel(int idPersonnel) {
//        this.idPersonnel = idPersonnel;
//    }
//
//    //change statut
//    public void setStatut(Statut statut) {
//        this.statut = statut;
//    }