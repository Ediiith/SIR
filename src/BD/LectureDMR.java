package BD;

import NF.Genre;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEMCare Solution
 */

public class LectureDMR {
// permet de lire un DMR

    //pour savoir si un patient possede deja un DMR
    public static boolean existenceDMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "select * from dmr ;";
            resultat = (ResultSet) st.executeQuery(sql1);
            while (resultat.next() && existence == false) {
                if (nomPatient.equalsIgnoreCase(resultat.getString("nomPatient")) && prenomPatient.equalsIgnoreCase(resultat.getString("prenomPatient")) && dateNaissance.equalsIgnoreCase(resultat.getString("dateNaissance")) && genre.toString().equalsIgnoreCase(resultat.getString("genre"))) {
                    existence = true;
                } else {
                    existence = false;
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return existence;

    }

    //pour savoir si un idDMR existe
    public static boolean existenceIdDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next() && existence == false) {
                if (idDMR != resultat.getInt(1)) {
                    existence = false;
                } else {
                    existence = true;
                }

            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return existence;
    }

    //liste de tous les idDMR dans la base de donnees
    public static List<Integer> listeIdDMR() {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        List<Integer> listeDMR = new ArrayList<Integer>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                int idDMR = Integer.parseInt(resultat.getString("idDMR"));
                listeDMR.add(idDMR);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return listeDMR;
        
    }
    
    //recuperer l'identifiant d'un DMR a partir du nom, prenom, date de naissance, genre du patient
    public static int lireIdDMR_fromDMR(String nomPatient, String prenomPatient, String dateNaissance, Genre genre) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idDMR = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where nomPatient = '" + nomPatient + "' and "
                    + "prenomPatient = '" + prenomPatient + "' and "
                    + "genre = '" + genre + "' and "
                    + "dateNaissance = '" + dateNaissance + "' ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idDMR = Integer.parseInt(resultat.getString("idDMR"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return idDMR;

    }

    //recuperer le nom du patient a partir de l'indentifiant du DMR
    public static String lireNomPatient_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String nomPatient = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                nomPatient = resultat.getString("nomPatient");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return nomPatient;

    }

    //recuperer le prenom du patient a partir de l'indentifiant du DMR
    public static String lirePrenomPatient_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String prenomPatient = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                prenomPatient = resultat.getString("prenomPatient");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return prenomPatient;

    }

    //recuperer la date de naissance du patient a partir de l'indentifiant du DMR
    public static String lireDateNaissance_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String dateNaissance = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                dateNaissance = resultat.getString("dateNaissance");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return dateNaissance;

    }

    //recuperer le genre du patient a partir de l'indentifiant du DMR
    public static Genre lireGenre_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String genreString = null;
        Genre genre = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                genreString = resultat.getString("genre");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        if (genreString.compareTo("Homme") == 0) {
            genre = Genre.HOMME;
        }
        if (genreString.compareTo("Femme") == 0) {
            genre = Genre.FEMME;
        }

        return genre;

    }

    //recuperer l'adresse du patient a partir de l'indentifiant du DMR
    public static String lireAdresse_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String adresse = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                adresse = resultat.getString("adresse");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return adresse;

    }

    //recuperer le numero de securite sociale du patient a partir de l'identifiant du DMR
    public static int lireNumSS_fromDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int numSS = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                numSS = Integer.parseInt(resultat.getString("numSS"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        return numSS;

    }
    
    //recuperer si le patient est admis
    public static boolean lireEstAdmis(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean estAdmis = false;
        String estAdmisString = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                estAdmisString = resultat.getString("estAdmis");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        if (estAdmisString.compareTo("true") == 0) {
            estAdmis = true;
        }
        if (estAdmisString.compareTo("false") == 0) {
            estAdmis = false;
        }
        
        return estAdmis;

    }
    
    //recuperer le DMR est temporaire
    public static boolean lireTemporaire(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean temporaire = false;
        String temporaireString = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dmr where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                temporaireString = resultat.getString("temporaire");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        if (temporaireString.compareTo("true") == 0) {
            temporaire = true;
        }
        if (temporaireString.compareTo("false") == 0) {
            temporaire = false;
        }
        
        return temporaire;

    }
    
}

