package NF;

import static BD.LectureDMR.existenceDMR;
import static BD.LectureDMR.lireAdresse_fromDMR;
import static BD.LectureDMR.lireDateNaissance_fromDMR;
import static BD.LectureDMR.lireIdDMR_fromDMR;
import static BD.LectureDMR.lireNomPatient_fromDMR;
import static BD.LectureDMR.lirePrenomPatient_fromDMR;
import static BD.LectureDMR.lireGenre_fromDMR;
import static BD.LectureExamen.lireIdDMR_fromExamen;
import java.util.Vector;
import java.util.Date;
import java.util.List;

public class DMR {

    private int idDMR;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private Genre genre;
    private String adresse;

    private List<Examen> listeExamen;

    private boolean estAdmis;
    private int numSS;
    private Date date;
    private boolean temporaire;
    private Personnel personnel;

    public DMR(int idDMR) {
        this.idDMR = idDMR;
        this.nomPatient = lireNomPatient_fromDMR(idDMR);
        this.prenomPatient = lirePrenomPatient_fromDMR(idDMR);
        this.dateNaissance = lireDateNaissance_fromDMR(idDMR);
        this.genre = lireGenre_fromDMR(idDMR);
        this.adresse = lireAdresse_fromDMR(this.idDMR);
        this.listeExamen = null;
        this.temporaire = false;
    }

     public DMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre, boolean temp) {
        if (existenceDMR(nomPatient, prenomPatient, dateNaissance, genre)==true){
            this.idDMR = lireIdDMR_fromDMR(nomPatient, prenomPatient, dateNaissance, genre);
        }
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.adresse = lireAdresse_fromDMR(this.idDMR);
        this.listeExamen = null;
        this.temporaire = temp;
    }

    //retourne sous forme de liste l'ensemble des dmr
    public List<Examen> getExamen() {
        return getListeExamen();
    }

    //ajoute un examen à la liste
    public void ajouterExamen(Examen examen) {
        getExamen().add(examen);
    }

    //compare si deux instances de DMR sont proches (Nom, prénom, date de naissance)
    public boolean procheDe(Object o) {
        boolean proche = false;
        Levenshtein l = new Levenshtein();
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            int nomsProches = l.levenshtein(this.getNomPatient(), d.getNomPatient());
            int prenomsProches = l.levenshtein(this.getPrenomPatient(), d.getPrenomPatient());
            int datesProches = l.levenshtein(this.getDateNaissance().toString(), d.getDateNaissance().toString());
            if (nomsProches <= 4 && prenomsProches <= 3 && datesProches <= 5) {
                proche = true;
            }
        }
        return proche;
    }

    //compare si deux instances de DMR sont égales pour Nom, prénom, date de naissance et genre
    public boolean equalsPartiel(Object o) {
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            return this.getNomPatient().equals(d.getNomPatient()) && this.getPrenomPatient().equals(d.getPrenomPatient())
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre());
        } else {
            return false;
        }
    }

    //compare si deux instances de DMR sont égales en tout points (sauf examens)
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

    //retourne les informations du patient 
    public String AfficherInfoPatient() {
        return "Prénom : " + prenomPatient + "\n Nom : " + nomPatient + "\n Genre : " + genre + " \n N° sécurité sociale : " + numSS
                + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + idDMR + "\n";
    }

    public String AfficherInfoPatientAdmis() {
        if (this.estAdmis) {
            return "Prénom : " + prenomPatient + "\n Nom " + nomPatient + "\n Genre : " + genre + " \n N° sécurité sociale : " + numSS
                    + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + idDMR;
        } else {
            return "";
        }
    }

    public String AfficherInfoPatientTemp() {
        return "Prénom : " + prenomPatient + "\n Nom : " + nomPatient + "\n Genre : " + genre + " \n né le " + dateNaissance;
    }

    //retourne tous les examens radiologiques du patient
    public String ExamensPatient() {
        String s;
        s = ("Examens du patient " + prenomPatient + " " + nomPatient);
        for (int i = 0; i < getListeExamen().size(); i++) {
            Examen e = (Examen) getListeExamen().get(i);
            s = s + ("    > " + e.toString());
        }
        s = s + "\n---------------------------------\n";
        return s;
    }

    public String afficherDMR() {
        String s = "DMR du " + date.toString() + "\n";
        s += "- Medecin : " + "Prénom : " + personnel.getPrenomPersonnel() + " Nom " + personnel.getNomPersonnel() + " Identifiant : " + personnel.getIdPersonnel() + "\n";
        s += "- Patient : " + "Prénom : " + prenomPatient + " Nom " + nomPatient + " Genre : " + genre + "  né le " + dateNaissance + "\n";
        s += "- Examens :";
        for (int i = 0; i < listeExamen.size(); i++) {
            Examen e = listeExamen.get(i);
            s += "    > " + e.toString() + "\n";
        }
        return s;
    }

    //retourne le nom
    public String getNomPatient() {
        return nomPatient;
    }

    //change le nom
    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    //retourne le prénom
    public String getPrenomPatient() {
        return prenomPatient;
    }

    //change le prénom
    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    //retourne la date de naissance
    public String getDateNaissance() {
        return dateNaissance;
    }

    //change la date de naissance
    public void setDateNaissance(String dateNaissance) {
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
    public int getIdDMR() {
        return idDMR;
    }

    //change le numéro unique
    public void setIdDMR(int idDMR) {
        this.idDMR = idDMR;
    }

    //retourne le genre sexuel
    public Genre getGenre() {
        return genre;
    }

    //change le genre sexuel
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * @return the estAdmis
     */
    public Boolean getEstAdmis() {
        return estAdmis;
    }

    /**
     * @param estAdmis the estAdmis to set
     */
    public void setEstAdmis(Boolean estAdmis) {
        this.estAdmis = estAdmis;
    }

    /**
     * @return the ListeExamen
     */
    public List<Examen> getListeExamen() {
        return listeExamen;
    }

    /**
     * @param ListeExamen the ListeExamen to set
     */
    public void setListeExamen(List<Examen> ListeExamen) {
        this.listeExamen = ListeExamen;
    }

    public Date getDate() {
        return date;
    }

}
