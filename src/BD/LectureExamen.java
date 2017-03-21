/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import NF.TypeExamen;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chloé
 */

public class LectureExamen {

    //pour savoir si un examen existe a partir de idExamen
    public static boolean existenceExamen(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "select * from examens ;";
            resultat = (ResultSet) st.executeQuery(sql1);
            while (resultat.next() && existence == false) {
                if (Integer.toString(idExamen).equalsIgnoreCase(resultat.getString("idExamen"))) {
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
    
    //pour savoir si un examen existe a partir du dmr, date examen, personnel, type examen
    public static boolean existenceExamen(int idDMR, String dateExamen, int idResponsable, TypeExamen typeExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        boolean existence = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql1 = "select * from examens ;";
            resultat = (ResultSet) st.executeQuery(sql1);
            while (resultat.next() && existence == false) {
                if (Integer.toString(idDMR).equalsIgnoreCase(resultat.getString("idDMR")) && dateExamen.equalsIgnoreCase(resultat.getString("dateExamen")) && Integer.toString(idResponsable).equalsIgnoreCase(resultat.getString("idResponsable")) && typeExamen.toString().equalsIgnoreCase(resultat.getString("typeExamen"))) {
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

    public static int genererIdExamen() {
        
        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idExamen = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idExamen = idExamen + 1;
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

        idExamen = idExamen + 1;
        
        return idExamen;
    }
    
    public static List<Integer> listeIdExamen_parIdDMR(int idDMR) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        List<Integer> listeExamens = new ArrayList<Integer>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idDMR = " + idDMR + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                int exam = Integer.parseInt(resultat.getString("idExamen"));
                listeExamens.add(exam);
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

        return listeExamens;
        
    }

    //recuperer l'identifiant d'un examen a partir de l'identifiant du DMR, date de l'examen, identifiant du responsable, type d'examen
    public static int lireIdExamen(int idDMR, String dateExamen, int idResponsable, TypeExamen typeExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idExamen = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idDMR = '" + idDMR + "' and "
                    + "dateExamen = '" + dateExamen + "' and "
                    + "idResponsable = '" + idResponsable + "' and "
                    + "typeExamen = '" + typeExamen + "' ;";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idExamen = Integer.parseInt(resultat.getString("idExamen"));
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

        return idExamen;

    }

    //recuperer l'identifiant du DMR a partir de l'identifiant de l'examen
    public static int lireIdDMR_fromExamen(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idDMR = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idDMR = Integer.parseInt(resultat.getString("idDMR"));
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

        return idDMR;

    }

    //recuperer la date de l'examen a partir de l'identifiant de l'examen
    public static String lireDateExamen(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String dateExamen = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                dateExamen = resultat.getString("dateExamen");
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

        return dateExamen;

    }

    //recuperer l'identifiant du responsable a partir de l'identifiant de l'examen
    public static int lireIdResponsable(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        int idResponsable = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                idResponsable = Integer.parseInt(resultat.getString("idResponsable"));
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

        return idResponsable;

    }

    //recuperer le type d'examen a partir de l'identifiant de l'examen
    public static TypeExamen lireTypeExamen(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String typeExamenString = null;
        TypeExamen typeExamen = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                typeExamenString = resultat.getString("typeExamen");
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

        if (typeExamenString.compareTo("Scanner") == 0) {
            typeExamen = TypeExamen.SCANNER;
        }
        if (typeExamenString.compareTo("IRM") == 0) {
            typeExamen = TypeExamen.IRM;
        }
        if (typeExamenString.compareTo("Radiographie") == 0) {
            typeExamen = TypeExamen.RADIOGRAPHIE;
        }
        if (typeExamenString.compareTo("Autre") == 0) {
            typeExamen = TypeExamen.AUTRE;
        }

        return typeExamen;

    }

    //recuperer le compte rendu a partir de l'identifiant de l'examen
    public static String lireCompteRendu(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String compteRendu = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                compteRendu = resultat.getString("compteRendu");
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

        return compteRendu;

    }

    //recuperer le lien PACS a partir de l'identifiant de l'examen
    public static String lireLienPACS(int idExamen) {

        Connection cn = null;
        Statement st = null;
        ResultSet resultat = null;
        String lienPACS = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            String sql = "select * from examens where idExamen = " + idExamen + ";";
            resultat = (ResultSet) st.executeQuery(sql);
            while (resultat.next()) {
                lienPACS = resultat.getString("lienPACS");
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

        return lienPACS;

    }

}
