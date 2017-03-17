/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import NF.Statut;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */
public class LecturePersonnel {

    //recuperer l'identifiant d'un personnel a partir de son nom, prenom, statut
    public static int lireIdPersonnel(String nomPersonnel, String prenomPersonnel, Statut statut) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idPersonnel = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where nomPersonnel = '" + nomPersonnel + "' and "
                    + "prenomPersonnel = '" + prenomPersonnel + "' and "
                    + "statut = '" + statut + "' ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idPersonnel = Integer.parseInt(resultat.getString("idPersonnel"));
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

        return idPersonnel;

    }

    //recuperer le nom du professionnel a partir de son identifiant
    public static String lireNomPersonnel(int idPersonnel) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String nomPersonnel = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where idPersonnel = " + idPersonnel + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                nomPersonnel = resultat.getString("nomPersonnel");
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

        return nomPersonnel;

    }

    //recuperer le nom du professionnel a partir de son identifiant
    public static String lirePrenomPersonnel(int idPersonnel) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String prenomPersonnel = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where idPersonnel = " + idPersonnel + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                prenomPersonnel = resultat.getString("prenomPersonnel");
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

        return prenomPersonnel;

    }

    //recuperer le nom du professionnel a partir de son identifiant
    public static Statut lireStatut(int idPersonnel) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String statutString = null;
        Statut statut = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where idPersonnel = " + idPersonnel + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                statutString = resultat.getString("statut");
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

        if (statutString.compareTo("Radiologue") == 0) {
            statut = Statut.RADIOLOGUE;
        }
        if (statutString.compareTo("Manipulateur") == 0) {
            statut = Statut.MANIPULATEUR;
        }
        if (statutString.compareTo("Interne") == 0) {
            statut = Statut.INTERNE;
        }
        if (statutString.compareTo("Secretaire") == 0) {
            statut = Statut.SECRETAIRE;
        }
        
        return statut;

    }

}
