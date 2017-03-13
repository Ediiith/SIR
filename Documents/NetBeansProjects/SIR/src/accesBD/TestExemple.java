/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesBD;

import static accesBD.EcritureDMR.genererDMR;
import static accesBD.LectureDMR.existenceDMR;
import static accesBD.LectureDPI.existenceDPI;
import static accesBD.LectureDPI.lireIdDPI;

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
        existenceDMR("David", "Ethan", "07/11/1998", "HOMME");
        //test existence DPI
        //true
        existenceDPI("David", "Ethan", "07/11/1998", "HOMME");
        //generation d'un DMR a partir d'un DPI
        int idDPI=lireIdDPI("David", "Ethan", "07/11/1998", "HOMME");
        genererDMR(idDPI);
    }
    
}
