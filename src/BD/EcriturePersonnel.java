package BD;

import static BD.LecturePersonnel.validerMdp;
import NF.Statut;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JEMCare Solution
 */

public class EcriturePersonnel {

    //pour creer un professionnel
    public static void creerProfessionnel(int idPersonnel, String mdp, String nomPersonnel, String prenomPersonnel, Statut statut) {

        Connection cn = null;
        Statement st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "insert into personnel (idPersonnel, mdp, nomPersonnel, prenomPersonnel, statut)"
                    + "values ('" + idPersonnel + "','" + mdp + "','" + nomPersonnel + "','" + prenomPersonnel + "','" + statut + "');";
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

    //pour changer le mot de passe du professionnel
    public static void ajouterMdp(int idPersonnel, String ancienMdp, String nouveauMdp) {

        if (validerMdp(idPersonnel, ancienMdp) == true) {

            Connection cn = null;
            Statement st = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
                st = (Statement) cn.createStatement();
                String sql = " update personnel set mdp = '" + nouveauMdp + "' where idPersonnel ='" + idPersonnel + "';";
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

}
