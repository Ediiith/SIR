package NF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Examen {

    private DMR dmr;
    private Date date;
    private CompteRendu compteRendu;
    private TypeExamen typeExamen;
    private String PACS;
    private final Personnel praticien; 
    private int identifiant;

    // constructeur 
    
    public Examen(DMR dmr, Date date, CompteRendu compteRendu, TypeExamen typeExamen, String PACS, Personnel radiologue) {
        this.dmr = dmr;
        this.date = date;
        this.compteRendu = compteRendu;
        this.typeExamen = typeExamen;
        this.PACS = PACS;
        this.praticien=radiologue;
    }
    
    /**
     * Récupere toutes les infos de l'examen depuis la base de données.
     */
    public void getInfos() {
        String sql;
        sql = "SELECT * FROM BDexamens WHERE idResponsable=" + identifiant;
        try {
            ResultSet rs = ConnexionBD.getConnexionBD().exec(sql);
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("id_p") == null) {
                        idP = 0;
                    } else {
                        idP = rs.getInt("id_p");
                    }
                    if (rs.getString("compterendu") == null) {
                        compte_rendu = "N/A";
                    } else {
                        compte_rendu = rs.getString("compterendu");
                    }
                    if (rs.getString("commentaire") == null) {
                        commentaire = "N/A";
                    } else {
                        commentaire = rs.getString("commentaire");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String toString(){
        return "Patient "+this.dmr.getNom()+" "+this.dmr.getPrenom()+" Né le "+this.dmr.getDateNaissance()+"\nDate : "+date+"\n Type d'examen : "+typeExamen+"\n Compte-rendu : "+compteRendu+"\n N° PACS : "+PACS;
    }

    //retourne le DMR
    public DMR getPatient() {
        return dmr;
    }

    //change le patient
    public void setPatient(DMR dmr) {
        this.dmr = dmr;
    }

    //retourne la date de l'examen
    public Date getDate() {
        return date;
    }

    //change la date de l'examen
    public void setDate(Date date) {
        this.date = date;
    }

    //retourne le compte rendu
    public CompteRendu getCompteRendu() {
        return compteRendu;
    }

    //change le compte rendu
    public void setCompteRendu(CompteRendu compteRendu) {
        this.compteRendu = compteRendu;
    }

    //retourne le type d'examen
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }

    //change le type d'examen
    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }

    //retourne le lien vers le PACS
    public String getPACS() {
        return PACS;
    }

    //change le lien vers le PACS
    public void setPACS(String PACS) {
        this.PACS = PACS;
    }
    
    //retour le radiologue qui a rédigé le compte rendu
    public Personnel getPh(){
        return praticien;
    }
}


