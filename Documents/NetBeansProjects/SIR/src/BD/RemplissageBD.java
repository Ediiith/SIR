/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import NF.Genre;
import NF.Statut;
import static BD.EcritureDMR.creerDMR;
import static BD.EcritureDPI.creerDPI;
import static BD.EcriturePersonnel.creerProfessionnel;

/**
 *
 * @author Chloé
 */
public class RemplissageBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creation de 30 DPI
        creerDPI(1, "Martin", "Chloe", "31/12/1965", Genre.FEMME, "12 Rue Simon Nora, 38000 Grenoble");
        creerDPI(2, "Bernard", "Lucas", "12/02/1985", Genre.HOMME, "17 Rue du Phalanstère, 38000 Grenoble");
        creerDPI(3, "Dubois", "Lea", "02/04/1967", Genre.FEMME, "28 Boulevard Gambetta, 38000 Grenoble");
        creerDPI(4, "Thomas", "Louis", "23/11/1954", Genre.HOMME, "635 Chemin de la Laurelle, 38330 Montbonnot-Saint-Martin");   
        creerDPI(5, "Robert", "Jade", "02/04/1995", Genre.FEMME, "8 Avenue Esclangon, 38610 Gières");
        creerDPI(6, "Richard", "Gabriel", "12/12/2000", Genre.HOMME, "32 Rue du Repos, 38610 Gières");
        creerDPI(7, "Petit", "Manon", "08/09/1999", Genre.FEMME, "46 Avenue Jean Jaurès, 38400 Saint-Martin-d Hères");
        creerDPI(8, "Durand", "Jules", "23/12/2010", Genre.HOMME, "7 Rue Flora Tristan, 38400 Saint-Martin-d Hères");
        creerDPI(9, "Leroy", "Louise", "31/07/1934", Genre.FEMME, "24 Avenue Gabriel Péri, 38400 Saint-Martin-d Hères");
        creerDPI(10, "Moreau", "Timeo", "23/05/1984", Genre.HOMME, "42 Boulevard Clemenceau, 38100 Grenoble");
        creerDPI(11, "Simon", "Zoe", "01/12/2016", Genre.FEMME, "29 Avenue Jean Perrot, 38100 Grenoble");
        creerDPI(12, "Laurent", "Hugo", "23/12/1963", Genre.HOMME, "22 Avenue Albert 1er de Belgique, 38100 Grenoble");
        creerDPI(13, "Lefebvre", "Lilou", "06/08/1996", Genre.FEMME, "50 Boulevard Gambetta, 38000 Grenoble");
        creerDPI(14, "Michel", "Arthur", "25/06/1973", Genre.HOMME, "11 Cours Berriat, 38000 Grenoble");
        creerDPI(15, "Garcia", "Lena", "02/04/1946", Genre.FEMME, "14 Rue Félix Esclangon, 38000 Grenoble");
        creerDPI(16, "David", "Ethan", "07/11/1998", Genre.HOMME, "39 Boulevard Joliot Curie, 38600 Fontaine");
        creerDPI(17, "Bertrand", "Sarah", "23/04/1964", Genre.FEMME, "81 Avenue du Vercors, 38600 Fontaine");
        creerDPI(18, "Roux", "Raphael", "29/03/1964", Genre.HOMME, "9 Avenue du Général de Gaulle, 38170 Seyssinet-Pariset");
        creerDPI(19, "Vincent", "Camille", "30/04/1996", Genre.FEMME, "158 Rue Georges Maeder, 38170 Seyssinet-Pariset");
        creerDPI(20, "Fournier", "Mael", "15/03/1984", Genre.HOMME, "Chemin de la Digue, 38180 Seyssins");
        creerDPI(21, "Morel", "Maelys", "25/02/1975", Genre.FEMME, "3 Rue Geo Charles, 38130 Échirolles");
        creerDPI(22, "Girard", "Tom", "03/12/1995", Genre.HOMME, "7 Rue Hector Berlioz, 38130 Échirolles");
        creerDPI(23, "Andre", "Lina", "24/05/2007", Genre.FEMME, "2 Avenue de l Industrie, 38130 Échirolles");
        creerDPI(24, "Lefevre", "Noah", "03/12/2004", Genre.HOMME, "67 Avenue de la République, 38130 Échirolles");
        creerDPI(25, "Mercier", "Eva", "17/03/2015", Genre.FEMME, "24 Rue de la Liberté, 38130 Échirolles");
        creerDPI(26, "Dupont", "Mathis", "16/06/1953", Genre.HOMME, "27 Avenue de Constantine, 38100 Grenoble");
        creerDPI(27, "Lambert", "Louna", "29/02/1948", Genre.FEMME, "56 Rue de l Arlequin, 38100 Grenoble");
        creerDPI(28, "Bonnet", "Theo", "18/02/1942", Genre.HOMME, "41 Rue des Chardonnerets, 38100 Grenoble");
        creerDPI(29, "Francois", "Clara", "01/01/2004", Genre.FEMME, "44 Avenue Marcelin Berthelot, 38100 Grenoble");
        creerDPI(30, "Martinez", "Adam", "27/11/1928", Genre.HOMME, "7 Rue Condillac, 38000 Grenoble");
        
        //creation de 15 DMR
        creerDMR(1, "Martin", "Chloe", "31/12/1965", Genre.FEMME, "12 Rue Simon Nora, 38000 Grenoble");
        creerDMR(2, "Bernard", "Lucas", "12/02/1985", Genre.HOMME, "17 Rue du Phalanstère, 38000 Grenoble");
        creerDMR(3, "Dubois", "Lea", "02/04/1967", Genre.FEMME, "28 Boulevard Gambetta, 38000 Grenoble");
        creerDMR(4, "Thomas", "Louis", "23/11/1954", Genre.HOMME, "635 Chemin de la Laurelle, 38330 Montbonnot-Saint-Martin");   
        creerDMR(5, "Robert", "Jade", "02/04/1995", Genre.FEMME, "8 Avenue Esclangon, 38610 Gières");
        creerDMR(6, "Richard", "Gabriel", "12/12/2000", Genre.HOMME, "32 Rue du Repos, 38610 Gières");
        creerDMR(7, "Petit", "Manon", "08/09/1999", Genre.FEMME, "46 Avenue Jean Jaurès, 38400 Saint-Martin-d Hères");
        creerDMR(8, "Durand", "Jules", "23/12/2010", Genre.HOMME, "7 Rue Flora Tristan, 38400 Saint-Martin-d Hères");
        creerDMR(9, "Leroy", "Louise", "31/07/1934", Genre.FEMME, "24 Avenue Gabriel Péri, 38400 Saint-Martin-d Hères");
        creerDMR(10, "Moreau", "Timeo", "23/05/1984", Genre.HOMME, "42 Boulevard Clemenceau, 38100 Grenoble");
        creerDMR(11, "Simon", "Zoe", "01/12/2016", Genre.FEMME, "29 Avenue Jean Perrot, 38100 Grenoble");
        creerDMR(12, "Laurent", "Hugo", "23/12/1963", Genre.HOMME, "22 Avenue Albert 1er de Belgique, 38100 Grenoble");
        creerDMR(13, "Lefebvre", "Lilou", "06/08/1996", Genre.FEMME, "50 Boulevard Gambetta, 38000 Grenoble");
        creerDMR(14, "Michel", "Arthur", "25/06/1973", Genre.HOMME, "11 Cours Berriat, 38000 Grenoble");
        creerDMR(15, "Garcia", "Lena", "02/04/1946", Genre.FEMME, "14 Rue Félix Esclangon, 38000 Grenoble");
        
        //creation de 10 professionnels
        creerProfessionnel(1, "azerty", "Legrand", "Jean", Statut.RADIOLOGUE);
        creerProfessionnel(2, "azerty", "Garnier", "Marie", Statut.RADIOLOGUE);
        creerProfessionnel(3, "azerty", "Faure", "Philippe", Statut.RADIOLOGUE);
        creerProfessionnel(4, "azerty", "Rousseau", "Nathalie", Statut.INTERNE);
        creerProfessionnel(5, "azerty", "Blanc", "Michel", Statut.MANIPULATEUR);
        creerProfessionnel(6, "azerty", "Guerin", "Isabelle", Statut.MANIPULATEUR);
        creerProfessionnel(7, "azerty", "Muller", "Alain", Statut.MANIPULATEUR);
        creerProfessionnel(8, "azerty", "Henry", "Sylvie", Statut.SECRETAIRE);
        creerProfessionnel(9, "azerty", "Roussel", "Patrick", Statut.SECRETAIRE);
        creerProfessionnel(10, "azerty", "Nicolas", "Catherine", Statut.SECRETAIRE);
        
    }
    
}
