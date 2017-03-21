package BD;

import NF.Genre;
import NF.Statut;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEMCare Solution
 */

public class LecturePersonnel {

    //pour savoir si un personnel existe a partir de nom, prenom, statut du personnel
    public static boolean existencePersonnel(String nomPersonnel, String prenomPersonnel, Statut statut) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "select * from personnel ;";
            resultat = (ResultSet) st.executeQuery(sql1);
            while (resultat.next() && existence == false) {
                if (nomPersonnel.equalsIgnoreCase(resultat.getString("nomPersonnel")) && prenomPersonnel.equalsIgnoreCase(resultat.getString("prenomPersonnel")) && statut.toString().equalsIgnoreCase(resultat.getString("statut"))) {
                    existence = true;
                } else {
                    existence = false;
                }
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

        return existence;

    }
    
    //pour savoir si un idPersonnel existe
    public static boolean existenceIdPersonnel(int idPersonnel) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next() && existence == false) {
                if (idPersonnel != resultat.getInt(1)) {
                    existence = false;
                } else {
                    existence = true;
                }

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

        return existence;
    }

    //liste de tous les idPersonnel dans la base de donnees
    public static List<Integer> listeIdPersonnel() {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        List<Integer> listePersonnel = new ArrayList<Integer>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                int idPersonnel = Integer.parseInt(resultat.getString("idPersonnel"));
                listePersonnel.add(idPersonnel);
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

        return listePersonnel;
        
    }
    
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

    //recuperer le mot de passe du professionnel a partir de son identifiant
    public static String lireMdp(int idPersonnel) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String mdp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where idPersonnel = " + idPersonnel + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                mdp = resultat.getString("mdp");
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

        return mdp;

    }

    //valider le mot de passe entre par le professionnel pour s'identifier
    public static boolean validerMdp(int idPersonnel, String mdp) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean validation = false;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from personnel where idPersonnel = '" + idPersonnel + "';";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                if (mdp.equalsIgnoreCase(resultat.getString("mdp"))) {
                    validation = true;
                }
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
        return validation;
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
    
    //recuperer le prenom du professionnel a partir de son identifiant
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
            statut = Statut.CHEF_SERVICE;
        }
        if (statutString.compareTo("Secretaire") == 0) {
            statut = Statut.SECRETAIRE;
        }

        return statut;

    }

}
