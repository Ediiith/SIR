package NF;

import static BD.EcritureDMR.creerDMR;
import static BD.EcritureDMR.genererDMR;
import static BD.LectureDMR.existenceDMR;
import static BD.LectureDMR.existenceIdDMR;
import static BD.LectureDMR.lireAdresse_fromDMR;
import static BD.LectureDMR.lireDateNaissance_fromDMR;
import static BD.LectureDMR.lireNomPatient_fromDMR;
import static BD.LectureDMR.lirePrenomPatient_fromDMR;
import static BD.LectureDMR.lireGenre_fromDMR;
import static BD.LectureDMR.lireNumSS_fromDMR;
import static BD.LectureDPI.existenceDPI;
import static BD.LectureDPI.lireAdresse_fromDPI;
import static BD.LectureDPI.lireIdDPI;
import static BD.LectureExamen.listeIdExamen_parIdDMR;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEMCare Solution
 */
public class DMR {

    //ATTRIBUTS   
    private int idDMR;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private Genre genre;
    private String adresse;
    private int numSS;

    private List<Examen> listeExamens;

    //pas dans la base de donnees
    private boolean estAdmis;
    private boolean temporaire;

    //CONSTRUCTEURS
    //constructeur en connaissant le numéro du DMR : idDMR
    //si le dmr existe deja dans la base de donnees
    //remplit la listeDMR
    public DMR(int idDMR) {
        if (existenceIdDMR(idDMR) == true) {
            this.idDMR = idDMR;
            this.nomPatient = lireNomPatient_fromDMR(idDMR);
            this.prenomPatient = lirePrenomPatient_fromDMR(idDMR);
            this.dateNaissance = lireDateNaissance_fromDMR(idDMR);
            this.genre = lireGenre_fromDMR(idDMR);
            this.adresse = lireAdresse_fromDMR(idDMR);
            this.numSS = lireNumSS_fromDMR(idDMR);
            this.listeExamens = new ArrayList<Examen>();
            for (int i = 0; i < listeIdExamen_parIdDMR(idDMR).size(); i++) {
                Examen e = new Examen(listeIdExamen_parIdDMR(idDMR).get(i), this);
                this.ajouterExamen(e);
            }
            this.estAdmis = true;
            this.temporaire = false;
        }
    }

    //constructeur en connaissant le nomPatient, prenomPatient, dateNaissance, genre, numSS
    //vérifie que DMR n'existe pas
    //regarde si DPI existe : si c'est le cas constructeur crée DMR et l'ajoute a la base de donnees a partir des donnees du DPI
    //sinon creation d'un DMR temporaire et ajout a la base de donnees
    public DMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre, int numSS) {
        if (existenceDMR(nomPatient, prenomPatient, dateNaissance, genre) == false) {
            this.nomPatient = nomPatient;
            this.prenomPatient = prenomPatient;
            this.dateNaissance = dateNaissance;
            this.genre = genre;
            this.numSS = numSS;
            this.estAdmis = true;
            if (existenceDPI(nomPatient, prenomPatient, dateNaissance, genre) == true) {
                this.idDMR = lireIdDPI(nomPatient, prenomPatient, dateNaissance, genre);
                this.adresse = lireAdresse_fromDPI(lireIdDPI(nomPatient, prenomPatient, dateNaissance, genre));
                this.temporaire = false;
                this.listeExamens = new ArrayList<Examen>();
                genererDMR(lireIdDPI(nomPatient, prenomPatient, dateNaissance, genre));
            } else {
                this.idDMR = 0;
                this.adresse = null;
                this.temporaire = true;
                this.listeExamens = new ArrayList<Examen>();
                creerDMR(idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS);
            }
        }
    }
    //ne pas oublier dans le main ldmr.ajouterDMR(dmr)

    public DMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre, int numSS, String adresse) {

        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.numSS = numSS;
        this.estAdmis = true;
        this.adresse = adresse;
        this.idDMR = 0;
        this.adresse = null;
        this.temporaire = true;
        this.listeExamens = new ArrayList<Examen>();
        creerDMR(idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS);

    }

    //COMPARAISONS
    //compare si deux instances de DMR sont proches pour nomPatient, prenomPatient et dateNaissance
    public boolean procheDe(String nom, String prenom, String date) {
        boolean proche = false;
        Levenshtein l = new Levenshtein();
        int nomsProches = l.levenshtein(this.getNomPatient(), nom);
        int prenomsProches = l.levenshtein(this.getPrenomPatient(),prenom);
        int datesProches = l.levenshtein(this.getDateNaissance(), date);
        if (nomsProches <= 4 && prenomsProches <= 3 && datesProches <= 5) {
            proche = true;
        }
        return proche;
    }

    //compare si deux instances de DMR sont égales pour nomPatient, prenomPatient, dateNaissance et genre
    public boolean equalsPartiel(Object o) {
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            return this.getNomPatient().equals(d.getNomPatient()) && this.getPrenomPatient().equals(d.getPrenomPatient())
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre());
        } else {
            return false;
        }
    }

    //compare si deux instances de DMR sont egales en tout points (sauf examens)
    public boolean equals(Object o) {
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            return this.getNomPatient().equals(d.getNomPatient()) && this.getPrenomPatient().equals(d.getPrenomPatient())
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre())
                    && this.getAdresse().equals(d.getAdresse())
                    && this.getNumSS() == d.getNumSS() && this.getIdDMR() == d.getIdDMR();
        } else {
            return false;
        }
    }

    //AFFICHAGES
    //retourne les informations d'un patient 
    public String afficherInfoPatient() {
        return "Prénom : " + prenomPatient + "\n Nom : " + nomPatient + "\n Né(e) le " + dateNaissance + "\n Genre : " + genre + " \n Adresse : " + adresse + "\n N° sécurité sociale : " + numSS + " \n DMR N° : " + idDMR + "\n";
    }

    //retourne les informations d'un patient temporaire
    public String afficherInfoPatientTemporaire() {
        return "Prénom : " + prenomPatient + "\n Nom : " + nomPatient + "\n Né(e) le : " + dateNaissance + "\n Genre : " + genre + "\n N° sécurité sociale : " + numSS + "\n Dossier temporaire \n";
    }

    //retourne les informations d'un dmr
    public String afficherDMR() {
        String s = "- DMR N° : " + idDMR + "\n";
        s += "- Patient : Prénom : " + prenomPatient + " Nom : " + nomPatient + "  Né(e) le : " + dateNaissance + " Genre : " + genre + "\n";
        s += "- Examens : \n";
        for (int i = 0; i < listeExamens.size(); i++) {
            Examen e = getListeExamens().get(i);
            s += "    > " + e.toString() + "\n";
        }
        return s;
    }

    //GETS & SETS
    //retourne idDMR
    public int getIdDMR() {
        return idDMR;
    }

    //retourne nomPatient
    public String getNomPatient() {
        return nomPatient;
    }

    //retourne prenomPatient
    public String getPrenomPatient() {
        return prenomPatient;
    }

    //retourne dateNaissance
    public String getDateNaissance() {
        return dateNaissance;
    }

    //retourne genre
    public Genre getGenre() {
        return genre;
    }

    //retourne adresse
    public String getAdresse() {
        return adresse;
    }

    //retourne numSS
    public int getNumSS() {
        return numSS;
    }

    //retourne listeExamens
    public List<Examen> getListeExamens() {
        return listeExamens;
    }

    //ajoute un examen à listeExamens
    public void ajouterExamen(Examen examen) {
        listeExamens.add(examen);
    }

    //retourne estAdmis
    public Boolean getEstAdmis() {
        return estAdmis;
    }

    //change estAdmis
    public void setEstAdmis(Boolean estAdmis) {
        this.estAdmis = estAdmis;
    }

    //retourne temporaire
    public Boolean getTemporaire() {
        return temporaire;
    }

    //change temporaire
    public void setTemporaire(Boolean temporaire) {
        this.temporaire = temporaire;
    }

}

//    //VOIR SI UTILE
//    
//    //change idDMR
//    public void setIdDMR(int idDMR) {
//        this.idDMR = idDMR;
//    }
//
//    //change nomPatient
//    public void setNomPatient(String nomPatient) {
//        this.nomPatient = nomPatient;
//    }
//
//    //change prenomPatient
//    public void setPrenomPatient(String prenomPatient) {
//        this.prenomPatient = prenomPatient;
//    }
//
//    //change dateNaissance
//    public void setDateNaissance(String dateNaissance) {
//        this.dateNaissance = dateNaissance;
//    }
//
//    //change genre
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//
//    //change adresse
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    //change numSS
//    public void setNumSS(int numSS) {
//        this.numSS = numSS;
//    }
//
//    //change listeExamens
//    public void setListeExamens(List<Examen> ListeExamens) {
//        this.listeExamens = ListeExamens;
//    }
