
package Processir.nf;


public class Main {

    public static void main(String[] args) {
        Statut t1 = Statut.MANIPULATEUR;
        Personnel p1= new Personnel("JACOB","Edith","JE","edith",t1,true);
              
        Statut t2 = Statut.RADIOLOGUE;
        Personnel p2= new Personnel("CAZAUX","Chloé","CC","choe",t2,false); 
        
        Personnel p3= new Personnel("CAZAUX","Chloé","CC","choe",t1,false); 
        
        System.out.println("P2 égal P3 : "+p2.equals(p3));
    }

}
