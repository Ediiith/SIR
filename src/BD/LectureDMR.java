/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import NF.Genre;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */
public class LectureDMR {

    //pour savoir si un patient possede deja un DMR
    //si pas de DMR le creer a partir du DPI
    //si pas de DPI creer un DMR
    public static boolean existenceDMR(String nomPatient, String prenomPatient, String dateNaissance, String genre) {

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
                if (nomPatient.equalsIgnoreCase(resultat.getString("nomPatient")) && prenomPatient.equalsIgnoreCase(resultat.getString("prenomPatient")) && dateNaissance.equalsIgnoreCase(resultat.getString("dateNaissance")) && genre.equalsIgnoreCase(resultat.getString("genre"))) {
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

}
