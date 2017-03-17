/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.EcritureDMR.genererDMR;
import static BD.LectureDMR.existenceDMR;
import static BD.LectureDPI.existenceDPI;
import static BD.LectureDPI.lireIdDPI;
import NF.Genre;

/**
 *
 * @author Chloé
 */
public class TestExemple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test existence DMR
        //false
        existenceDMR("David", "Ethan", "07/11/1998", Genre.HOMME);
        //test existence DPI
        //true
        existenceDPI("David", "Ethan", "07/11/1998", Genre.HOMME);
        //generation d'un DMR a partir d'un DPI
        int idDPI=lireIdDPI("David", "Ethan", "07/11/1998", Genre.HOMME);
        genererDMR(idDPI);
    }
    
}
