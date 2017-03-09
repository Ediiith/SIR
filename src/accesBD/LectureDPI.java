/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesBD;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chloé
 */
public class LectureDPI {

    // creer existenceDPI

    public static int lireIdDPI(String nomPatient, String prenomPatient, String dateNaissance, String genre) {

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

    public static String lireNomPatient(int idDPI) {

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

    public static String lirePrenomPatient(int idDPI) {

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

    public static String lireDateNaissance(int idDPI) {

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

    public static String lireGenre(int idDPI) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String genre = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from dpi where idDPI = " + idDPI + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                genre = resultat.getString("genre");
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

        return genre;

    }

    public static String lireAdresse(int idDPI) {

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

}
