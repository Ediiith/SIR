package BD;

import NF.TypeExamen;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JEMCare Solution
 */
public class EcritureExamen {

    //pour creer un examen et l'ajouter a un DMR
    public static void creerExamen(int idExamen, int idDMR, String dateExamen, String idResponsable, TypeExamen typeExamen) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "insert into examens (idExamen, idDMR, dateExamen, idResponsable, typeExamen)"
                    + "values ('" + idExamen + "','" + idDMR + "','" + dateExamen + "','" + idResponsable + "','" + typeExamen + "');";
            st.executeUpdate(sql1);
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

    //pour ajouter un compte rendu a un examen deja existant
    public static void ajouterCompteRendu(int idExamen, String compteRendu) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = " update examens set compteRendu = '" + compteRendu + "' where idExamen ='" + idExamen + "';";
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

    //pour ajouter un lien PACS a un examen deja existant
    public static void ajouterLienPACS(int idExamen, String lienPACS) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = " update examens set lienPACS = '" + lienPACS + "' where idExamen ='" + idExamen + "';";
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
