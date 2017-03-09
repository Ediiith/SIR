/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package accesBD;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */

public class EcritureDMR {
    
    public static void creerDMR(int idDMR, String nomPatient, String prenomPatient, String dateNaissance, Genre genre, String adresse) {
        
        Connection c = null;
        Statement s = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            s = (Statement) c.createStatement();
            String sql1 = "insert into dmr (idDMR, nomPatient, prenomPatient, dateNaissance, genre, adresse) values "
                         + "('" + idDMR + "','" + nomPatient + "','" + prenomPatient + "','" + dateNaissance + "','" + genre + "','" + adresse + "');";
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