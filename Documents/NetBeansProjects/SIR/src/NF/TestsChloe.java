/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author Chloé
 */
public class TestsChloe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Personnel p = new Personnel(1);
        System.out.println(p.toString());
        
        DMR d = new DMR(8);
        
        Examen e1 = new Examen(3);
        System.out.println(e1.toString());
        Examen e2 = new Examen(d,"13/03/2017",p,TypeExamen.AUTRE);
        System.out.println(e2.toString());

        CompteRendu cr = new CompteRendu(e1);
    }
    
}
