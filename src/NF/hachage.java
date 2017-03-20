/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Edith
 */
public class hachage {

// Encode la chaîne passé en paramètre (message) avec la fonction de hachage MD5
// Retourne la valeur (message) hexadécimale sur 32 bits.
    public String getHash(String message) {
        // Il faut convertir la chaîne de caractères de base en tableau de bits
        byte[] uniqueKey = message.getBytes();
        byte[] hash = null;
        try {
            // Récupération d'un objet qui permettra de crypter la chaîne de caractère
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e){
            throw new Error ("no MD5 support in this VM");
        }
        StringBuffer hashString = new StringBuffer();
        for (int i = 0; i<hash.length; i++){ // il faut traiter le message par bloc
            String hex= Integer.toHexString(hash[i]);
            if (hex.length()==1){
                // Il faut compléter le message par des 0 pour que le message étendu ait une longueur suffisante de 32bits.
                hashString.append('0');
                hashString.append(hex.charAt(hex.length()-1));
            } else {
                hashString.append(hex.substring(hex.length()-2));
            }
        }
        return hashString.toString();
    }
 
           
            
           
          
    }


