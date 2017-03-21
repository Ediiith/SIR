package BD;

import NF.Genre;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JEMCare Solution
 */

public class LectureDPI {
// permet de lire un DPI
    
    //pour savoir si un patient possede un DPI a partir du nom, prenom, date de naissance, genre du patient
    public static boolean existenceDPI(String nomPatient, String prenomPatient, String dateNaissance, Genre genre) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "select * from dpi ;";
            resultat = (ResultSet) st.executeQuery(sql1);
            while (resultat.next() && existence == false) {
                if (nomPatient.equalsIgnoreCase(resultat.getString("nomPatient")) && prenomPatient.equalsIgnoreCase(resultat.getString("prenomPatient")) && dateNaissance.equalsIgnoreCase(resultat.getString("dateNaissance")) && genre.toString().equalsIgnoreCase(resultat.getString("genre"))) {
                    existence = true;
                } else {
                    existence = false;
                }
            }
        }
        
        catch (SQLException exc) {
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
    
    //recuperer l'identifiant d'un DPI a partir du nom, prenom, date de naissance, genre du patient
    public static int lireIdDPI(String nomPatient, String prenomPatient, String dateNaissance, Genre genre) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idDPI = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where nomPatient = '" + nomPatient + "' and "
                    + "prenomPatient = '" + prenomPatient + "' and "
                    + "genre = '" + genre + "' and "
                    + "dateNaissance = '" + dateNaissance + "' ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idDPI = Integer.parseInt(resultat.getString("idDPI"));
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

        return idDPI;

    }

    //recuperer le nom du patient a partir de l'identifiant du DPI
    public static String lireNomPatient_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String nomPatient = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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

    //recuperer le prenom du patient a partir de l'identifiant du DPI
    public static String lirePrenomPatient_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String prenomPatient = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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

    //recuperer la date de naissance du patient a partir de l'identifiant du DPI
    public static String lireDateNaissance_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String dateNaissance = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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

    //recuperer le genre du patient a partir de l'identifiant du DPI
    public static Genre lireGenre_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String genreString = null;
        Genre genre = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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

    //recuperer l'adresse du patient a partir de l'identifiant du DPI
    public static String lireAdresse_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String adresse = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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

    //recuperer le numero de securite sociale du patient a partir de l'identifiant du DPI
    public static int lireNumSS_fromDPI(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int numSS = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
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
    
}
