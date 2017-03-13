/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesBD;

import NF.Statut;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */
public class EcriturePersonnel {
    
    //pour creer un professionnel
    //seulement utile pour les tests
    public static void creerProfessionnel(int idPersonnel, String mdp, String nomPersonnel, String prenomPersonnel, Statut metier){
        
        Connection cn = null;
        Statement st = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "insert into personnel (idPersonnel, mdp, nomPersonnel, prenomPersonnel, metier)"
                    + "values ('"+idPersonnel+"','"+mdp+"','"+nomPersonnel+"','"+prenomPersonnel+"','"+metier+"');";
            st.executeUpdate(sql1);
        }
        
        catch (SQLException exc){
            exc.printStackTrace();
        }
        
        catch(ClassNotFoundException exc){
            exc.printStackTrace();
        }
        
        finally{
            try{
                cn.close();
                st.close();
            }
            catch(SQLException exc){
                exc.printStackTrace();
            }
        }
        
    }
    
}
