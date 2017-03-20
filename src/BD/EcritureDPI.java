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
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */
public class EcritureDPI {

    //pour creer un DPI
    //seulement utile pour les tests
    public static void creerDPI(int idDPI, String nomPatient, String prenomPatient, String dateNaissance, Genre genre, String adresse, int numSS) {
        
        Connection c = null;
        Statement s = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            s = (Statement) c.createStatement();
            String sql1 = "insert into dpi (idDPI, nomPatient, prenomPatient, dateNaissance, genre, adresse, numSS) values "
                         + "('" + idDPI + "','" + nomPatient + "','" + prenomPatient + "','" + dateNaissance + "','" + genre + "','" + adresse + "','" + numSS + "');";
            s.executeUpdate(sql1);
        }
        
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        
        catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        
        finally {
            try {
                c.close();
                s.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        
    }

}
