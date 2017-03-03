package Processir.nf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        
//        //Test d'affichage d'un DMR
//        Date d1 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-07 23h45");
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        
//        //Test de comparaison de deux DMR proches
//        Date d1 = new Date(System.currentTimeMillis()); 
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        DMR dmr2 = new DMR("MATIVE","Mary",d1,334,"1 place dubedout",001,g1);
//        
//        System.out.println("Les deux DMR sont semblables : " +dmr1.procheDe(dmr2));

//        //Test de la fonction levenshtein
//        Date n1 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-07 23h45");
//        Date n2 = new SimpleDateFormat("yyyy-MM-dd hh'h'mm").parse("1976-09-05 23h00");
//        
//        String str1 = n1.toString();
//        String str2 = n2.toString();
//        
//        Levenshtein l = new Levenshtein();
//
//        int result = l.levenshtein(str2, str1);
//        System.out.println("Les deux phrases sont semblables à : " + result);

//        //Test de la fonction min(int,int,int)
//        int a=7;
//        int b=7;
//        int c=9;
//        Levenshtein l = new Levenshtein();
//        System.out.println("Le minimum entre "+a+", "+b+" et "+c+" est : "+l.min(a,b,c));
        
        
//        //Test de comparaison de 2 instances de DMR
//        Date d1 = new Date(System.currentTimeMillis()); 
//        Genre g1 = Genre.FEMME;
//        DMR dmr1 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        DMR dmr2 = new DMR("MATHIVET","Marie",d1,334,"1 place dubedout",001,g1);
//        
//        System.out.println("Les deux DMR sont semblables : " +dmr1.equals(dmr2));
        
        
//        //Test de comparaison de 2 instances de Personnel
//        Statut t1 = Statut.MANIPULATEUR;
//        Personnel p1= new Personnel("JACOB","Edith","JE","edith",t1,true);
//              
//        Statut t2 = Statut.RADIOLOGUE;
//        Personnel p2= new Personnel("CAZAUX","Chloé","CC","choe",t2,false); 
//        
//        Personnel p3= new Personnel("CAZAUX","Chloé","CC","choe",t1,false); 
//        
//        System.out.println("P2 égal P3 : "+p2.equals(p3));
    }

}
