package NF;

import static BD.EcritureDMR.creerDMR;
import static BD.EcritureDMR.genererDMR;
import static BD.LectureDMR.existenceDMR;
import static BD.LectureDMR.existenceIdDMR;
import static BD.LectureDMR.lireAdresse_fromDMR;
import static BD.LectureDMR.lireDateNaissance_fromDMR;
import static BD.LectureDMR.lireIdDMR_fromDMR;
import static BD.LectureDMR.lireNomPatient_fromDMR;
import static BD.LectureDMR.lirePrenomPatient_fromDMR;
import static BD.LectureDMR.lireGenre_fromDMR;
import static BD.LectureDMR.lireNumSS_fromDMR;
import static BD.LectureDPI.existenceDPI;
import static BD.LectureDPI.lireAdresse_fromDPI;
import static BD.LectureDPI.lireIdDPI;
import java.util.Date;
import java.util.List;

public class DMR {

    private int idDMR;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private Genre genre;
    private String adresse;
    private int numSS;
    private boolean temporaire;

    private List<Examen> listeExamen;

    //VOIR SI UTILE    
    private boolean estAdmis;
    private Date date;
    private Personnel personnel;

    //constructeur en connaissant l'identifiant du DMR
    public DMR(int idDMR) {
        if (existenceIdDMR(idDMR) == true) {
            this.idDMR = idDMR;
            this.nomPatient = lireNomPatient_fromDMR(idDMR);
            this.prenomPatient = lirePrenomPatient_fromDMR(idDMR);
            this.dateNaissance = lireDateNaissance_fromDMR(idDMR);
            this.genre = lireGenre_fromDMR(idDMR);
            this.adresse = lireAdresse_fromDMR(idDMR);
            this.numSS = lireNumSS_fromDMR(idDMR);
            this.temporaire = false;
            this.listeExamen = null;
        }
    }

    //constructeur en connaissant le nom, prenom, date de naissance, genre, numero de SS du patient 
    //regarde si DMR existe ; si c'est le cas constructeur a partir des donnees du DMR
    //sinon regarde si DPI existe ; si c'est le cas constructeur qui cree DMR a partir des donnees du DPI
    //sinon creation d'un DMR temporaire
    public DMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre, int numSS) {
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.numSS = numSS;
        this.listeExamen = null;
        if (existenceDMR(nomPatient, prenomPatient, dateNaissance, genre) == true) {
            this.idDMR = lireIdDMR_fromDMR(nomPatient, prenomPatient, dateNaissance, genre);
            this.adresse = lireAdresse_fromDMR(this.idDMR);
            this.temporaire = false;
        } else {
            if (existenceDPI(nomPatient, prenomPatient, dateNaissance, genre) == true) {
                this.idDMR = lireIdDPI(nomPatient, prenomPatient, dateNaissance, genre);
                this.adresse = lireAdresse_fromDPI(this.idDMR);
                this.temporaire = false;
                genererDMR(idDMR);
            } else {
                this.idDMR = 0;
                this.adresse = null;
                this.temporaire = true;
                creerDMR(idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS);
            }
        }
    }

    //retourne sous forme de liste l'ensemble des examens d'un DMR
    public List<Examen> getExamen() {
        return getListeExamen();
    }

    //ajoute un examen à la liste des examens
    public void ajouterExamen(Examen examen) {
        getExamen().add(examen);
    }

    //compare si deux instances de DMR sont proches pour nom, prenom, date de naissance
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

    //compare si deux instances de DMR sont égales pour nom, prenom, date de naissance et genre
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

    //retourne les informations du patient 
    public String AfficherInfoPatient() {
        return "Prénom : " + prenomPatient + "\n Nom : " + nomPatient + "\n Genre : " + genre + " \n N° sécurité sociale : " + numSS
                + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + idDMR + "\n";
    }

    //retourne les informations d'un patient admis
    public String AfficherInfoPatientAdmis() {
        if (this.estAdmis) {
            return "Prénom : " + prenomPatient + "\n Nom " + nomPatient + "\n Genre : " + genre + " \n N° sécurité sociale : " + numSS
                    + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + idDMR;
        } else {
            return "";
        }
    }

    //retourne les informations d'un patient temporaire
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

    //retourne toutes les informations du DMR
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

    //retourne l'identifiant du DMR du patient
    public int getIdDMR() {
        return idDMR;
    }

    //retourne le nom du patient
    public String getNomPatient() {
        return nomPatient;
    }

    //retourne le prenom du patient
    public String getPrenomPatient() {
        return prenomPatient;
    }

    //retourne la date de naissance du patient
    public String getDateNaissance() {
        return dateNaissance;
    }

    //retourne le genre sexuel du patient
    public Genre getGenre() {
        return genre;
    }

    //retourne l'adresse du patient
    public String getAdresse() {
        return adresse;
    }

    //retourne le numero de sécurite sociale du patient
    public int getNumSS() {
        return numSS;
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

    
    //VOIR SI UTILE
    
    //change l'identifiant du DMR du patient
    public void setIdDMR(int idDMR) {
        this.idDMR = idDMR;
    }

    //change le nom du patient
    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    //change le prenom du patient
    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    //change la date de naissance du patient
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    //change le genre sexuel du patient
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    //change l'adresse du patient
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //change le numero de securite sociale du patient
    public void setNumSS(int numSS) {
        this.numSS = numSS;
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

    //retourne la date de creation du DMR
    public Date getDate() {
        return date;
    }

}
