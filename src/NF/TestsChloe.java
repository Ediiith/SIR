/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import static NF.ListeDMR.afficherListeDMR;
import static NF.ListeDMR.getListeDMR;
import static NF.ListeDMR.remplissageListeDMR;

/**
 *
 * @author Chloé
 */
public class TestsChloe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Personnel p = new Personnel(1);
//        System.out.println(p.toString());
//        
//        DMR d = new DMR(8);
//        
//        Examen e2 = new Examen(d,"13/03/2017",p,TypeExamen.AUTRE);
//        System.out.println(e2.toString());
//
//        CompteRendu cr = new CompteRendu(e2);
//        
//        DMR dmrtest1 = new DMR("gerds","vervd","vrvd",Genre.FEMME, 853);
//        DMR dmrtest2 = new DMR("Martinez", "Adam", "27/11/1928", Genre.HOMME, 822);
        
        ListeDMR ldmr = new ListeDMR();
        remplissageListeDMR();
        System.out.println(afficherListeDMR());
        
        System.out.println(getListeDMR());
        
    }
    
}
