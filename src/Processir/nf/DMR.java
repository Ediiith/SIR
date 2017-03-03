package Processir.nf;

import java.util.Vector;
import java.util.Date;
import java.util.List;

public class DMR {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private int numSS;
    private String adresse;
    private int numUnique;
    private Genre genre;
    private List<Examen> ListeExamen;
    private Boolean estAdmis;

    public DMR(String nom, String prenom, Date dateNaissance, int numSS, String adresse, int numUnique, Genre genre, Boolean estAdmis) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numSS = numSS;
        this.adresse = adresse;
        this.numUnique = numUnique;
        this.genre = genre;
        ListeExamen = new Vector<Examen>();
        this.estAdmis = estAdmis;
    }

    public DMR(String nom, String prenom, Date dateNaissance, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
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
            int nomsProches = l.levenshtein(this.getNom(), d.getNom());
            int prenomsProches = l.levenshtein(this.getPrenom(), d.getPrenom());
            int datesProches = l.levenshtein(this.getDateNaissance().toString(), d.getDateNaissance().toString());
            if (nomsProches <=4 && prenomsProches<=3 && datesProches<=5){
                proche = true;
            }
        }
        return proche;
    }
    
    //compare si deux instances de DMR sont égales pour Nom, prénom, date de naissance et genre
    public boolean equalsPartiel(Object o) {
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            return this.getNom().equals(d.getNom()) && this.getPrenom().equals(d.getPrenom())
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre());
        } else {
            return false;
        }
    }

    //compare si deux instances de DMR sont égales en tout points (sauf examens)
    public boolean equals(Object o) {
        if (o instanceof DMR) {
            DMR d = (DMR) o;
            return this.getNom().equals(d.getNom()) && this.getPrenom().equals(d.getPrenom())
                    && this.getDateNaissance().equals(d.getDateNaissance()) && this.getGenre().equals(d.getGenre())
                    && this.getAdresse().equals(d.getAdresse())
                    && this.getNumSS() == d.getNumSS() && this.getNumUnique() == d.getNumUnique();
        } else {
            return false;
        }
    }
    
    //retourne les informations du patient 
    public String AfficherInfoPatient() {
        return "Prénom : " +prenom+ "\n Nom : " + nom + "\n Genre : "+genre+ " \n N° sécurité sociale : " + numSS 
                + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + numUnique+"\n";
    }
    
    public String AfficherInfoPatientAdmis(){
        if (this.estAdmis){
            return "Prénom : " +prenom+ "\n Nom " + nom + "\n Genre : "+genre+ " \n N° sécurité sociale : " + numSS 
                + " \n né le " + dateNaissance + " \n Adresse : " + adresse + " \n n° unique : " + numUnique;
        }
        else {
            return "";
        }
    }
    
    //retourne tous les examens radiologiques du patient
    public String ExamensPatient(){
        String s;
        s=("Examens du patient " +prenom+" "+nom);
        for (int i = 0; i < getListeExamen().size(); i++) {
            Examen e = (Examen) getListeExamen().get(i);
            s=s+("    > " + e.toString());
        }
        s=s+"\n---------------------------------\n";
        return s;
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
        return ListeExamen;
    }

    /**
     * @param ListeExamen the ListeExamen to set
     */
    public void setListeExamen(List<Examen> ListeExamen) {
        this.ListeExamen = ListeExamen;
    }

}
