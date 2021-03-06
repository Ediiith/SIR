package BD;

import NF.Genre;
import static BD.LectureDPI.lireAdresse_fromDPI;
import static BD.LectureDPI.lireDateNaissance_fromDPI;
import static BD.LectureDPI.lireGenre_fromDPI;
import static BD.LectureDPI.lireNomPatient_fromDPI;
import static BD.LectureDPI.lireNumSS_fromDPI;
import static BD.LectureDPI.lirePrenomPatient_fromDPI;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JEMCare Solution
 */
public class EcritureDMR {
    // cette classe permet de remplir les informations concernant les DMR

    //pour generer un DMR s'il n'exite pas a partir de l'identifiant d'un DPI
    public static void genererDMR(int idDPI) {

        Connection c = null;
        Statement s = null;

        int idDMR = idDPI;
        String nomPatient = lireNomPatient_fromDPI(idDPI);
        String prenomPatient = lirePrenomPatient_fromDPI(idDPI);
        String dateNaissance = lireDateNaissance_fromDPI(idDPI);
        Genre genre = lireGenre_fromDPI(idDPI);
        String adresse = lireAdresse_fromDPI(idDPI);
        int numSS = lireNumSS_fromDPI(idDPI);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            s = (Statement) c.createStatement();
            String sql1 = "insert into dmr (idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS) values "
                    + "('" + idDMR + "','" + nomPatient + "','" + prenomPatient + "','" + dateNaissance + "','" + genre + "','" + adresse + "','" + numSS + "');";
            s.executeUpdate(sql1);
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                c.close();
                s.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

    }

    //pour creer un DMR si aucun DMR ni DPI n'existe pour le patient
    public static void creerDMR(int idDMR, String nomPatient, String prenomPatient, String dateNaissance, Genre genre, String adresse, int numSS) {

        Connection c = null;
        Statement s = null;

        boolean estAdmis = true;
        boolean temporaire = true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            s = (Statement) c.createStatement();
            String sql1 = "insert into dmr (idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS, estAdmis, temporaire) values "
                    + "('" + idDMR + "','" + nomPatient + "','" + prenomPatient + "','" + dateNaissance + "','" + genre + "','" + adresse + "','" + numSS + "','" + estAdmis + "','" + temporaire + "');";
            s.executeUpdate(sql1);
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                c.close();
                s.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

    }

    //pour creer un DMR pour la base de donnees
    public static void creerDMR(int idDMR, String nomPatient, String prenomPatient, String dateNaissance, Genre genre, String adresse, int numSS, boolean estAdmis, boolean temporaire) {

        Connection c = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            s = (Statement) c.createStatement();
            String sql1 = "insert into dmr (idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS, estAdmis, temporaire) values "
                    + "('" + idDMR + "','" + nomPatient + "','" + prenomPatient + "','" + dateNaissance + "','" + genre + "','" + adresse + "','" + numSS + "','" + estAdmis + "','" + temporaire + "');";
            s.executeUpdate(sql1);
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            try {
                c.close();
                s.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

    }

    //change estAdmis
    public static void changerEstAdmis(int idDMR, boolean nouveauEstAdmis) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = " update dmr set estAdmis = '" + nouveauEstAdmis + "' where idDMR ='" + idDMR + "';";
            st.executeUpdate(sql);
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

    }

    //change temporaire
    public static void changerTemporaire(int idDMR, boolean nouveauTemporaire) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = " update dmr set temporaire = '" + nouveauTemporaire + "' where idDMR ='" + idDMR + "';";
            st.executeUpdate(sql);
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

    }

}
