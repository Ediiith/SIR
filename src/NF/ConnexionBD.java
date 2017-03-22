package NF;

import BD.InitialisationIP;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JEMCare Solution
 */
public class ConnexionBD {

    private String urlBd = "";
    private String idBd = "";
    private String mdpBd = "";
    private java.sql.Connection Connect = null;
    private java.sql.Statement Statement = null;
    private Connection cn = null;
    private Statement st = null;

// constructeur à partir de l'URL, l'identifiant et le mot de passe de la base de données
    public ConnexionBD(String urlBd, String idBd, String mdpBd) {
        this.urlBd = urlBd;
        this.idBd = idBd;
        this.mdpBd = mdpBd;
    }

// connexion à la base de données, retourne false si la connexion a échoué    
    public Boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(InitialisationIP.urlBD, InitialisationIP.idBD, InitialisationIP.mdpBD);
            st = (Statement) cn.createStatement();
            return true;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// Exécute une requête SQL et retourne le résultat de la requête
    public ResultSet exec(String sql) {
        try {
            ResultSet rs = this.Statement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insererDB(String s) {
        int i = 0;
        try {
            i = Statement.executeUpdate(s);
            System.out.println("Successfully inserted the information into the database!");
        } catch (SQLException ex) {
            return i;
        }
        return i;
    }

    /**
     * Inserer une image dans la base de données.
     *
     * chemin vers l'image idBd id de l'examen auquel correspond l'image
     */
    public void insert_image(String chemin, int id) {
        try {
            File imgfile = new File(chemin);
            FileInputStream fin = new FileInputStream(imgfile);

            PreparedStatement pre = this.Connect.prepareStatement("insert into PACS values(?,?,?)");
            pre.setString(1, null); //insère à l'indice n°1 càd à id_image
            pre.setInt(3, id);   //insère à l'indice n°3 càd à id
            pre.setBinaryStream(2, (InputStream) fin, (int) imgfile.length()); //insère à l'indice n°2 càd l'image
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

        } catch (FileNotFoundException | SQLException e1) {
            System.out.println(e1.getMessage());
        }
    }

    /**
     * Récupérer les images d'un examen.
     *
     * id l'id de l'examen return <code>null</code> si aucune images
     * disponibles, sinon la liste d'images
     */
    public ArrayList<Image> getImage(int id) {
        ArrayList<Image> images = new ArrayList<>();
        ResultSet rs;

        try {
            rs = this.exec("SELECT image FROM pacs WHERE id=" + id);

            byte[] image = null;
            if (rs != null) {
                if (!rs.isBeforeFirst()) {
                    images = null;
                }
                while (rs.next()) {
                    image = rs.getBytes("image");
                    images.add(Toolkit.getDefaultToolkit().createImage(image));
                }
            }
        } catch (SQLException e) {
            images = null;
        }
        return images;
    }

    /**
     * Fermer la connexion au serveur de DB
     */
    public void close() {
        try {
            this.Statement.close();
            this.Connect.close();
            this.Connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
