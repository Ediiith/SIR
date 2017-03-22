package BD;

import NF.Genre;
import NF.Statut;
import static BD.EcritureDMR.creerDMR;
import static BD.EcritureDPI.creerDPI;
import static BD.EcritureExamen.ajouterCompteRendu;
import static BD.EcritureExamen.ajouterLienPACS;
import static BD.EcritureExamen.creerExamen;
import static BD.EcriturePersonnel.creerProfessionnel;
import NF.TypeExamen;

/**
 *
 * @author JEMCare Solution
 */
public class RemplissageBD {
// génère la base de données

    public static void main(String[] args) {

        //creation de 30 DPI
        creerDPI(1, "Martin", "Chloe", "31/12/1965", Genre.FEMME, "12 Rue Simon Nora, 38000 Grenoble", 1);
        creerDPI(2, "Bernard", "Lucas", "12/02/1985", Genre.HOMME, "17 Rue du Phalanstère, 38000 Grenoble", 2);
        creerDPI(3, "Dubois", "Lea", "02/04/1967", Genre.FEMME, "28 Boulevard Gambetta, 38000 Grenoble", 3);
        creerDPI(4, "Thomas", "Louis", "23/11/1954", Genre.HOMME, "635 Chemin de la Laurelle, 38330 Montbonnot-Saint-Martin", 4);
        creerDPI(5, "Robert", "Jade", "02/04/1995", Genre.FEMME, "8 Avenue Esclangon, 38610 Gières", 5);
        creerDPI(6, "Richard", "Gabriel", "12/12/2000", Genre.HOMME, "32 Rue du Repos, 38610 Gières", 6);
        creerDPI(7, "Petit", "Manon", "08/09/1999", Genre.FEMME, "46 Avenue Jean Jaurès, 38400 Saint-Martin-d Hères", 7);
        creerDPI(8, "Durand", "Jules", "23/12/2010", Genre.HOMME, "7 Rue Flora Tristan, 38400 Saint-Martin-d Hères", 8);
        creerDPI(9, "Leroy", "Louise", "31/07/1934", Genre.FEMME, "24 Avenue Gabriel Péri, 38400 Saint-Martin-d Hères", 9);
        creerDPI(10, "Moreau", "Timeo", "23/05/1984", Genre.HOMME, "42 Boulevard Clemenceau, 38100 Grenoble", 10);
        creerDPI(11, "Simon", "Zoe", "01/12/2016", Genre.FEMME, "29 Avenue Jean Perrot, 38100 Grenoble", 11);
        creerDPI(12, "Laurent", "Hugo", "23/12/1963", Genre.HOMME, "22 Avenue Albert 1er de Belgique, 38100 Grenoble", 12);
        creerDPI(13, "Lefebvre", "Lilou", "06/08/1996", Genre.FEMME, "50 Boulevard Gambetta, 38000 Grenoble", 13);
        creerDPI(14, "Michel", "Arthur", "25/06/1973", Genre.HOMME, "11 Cours Berriat, 38000 Grenoble", 14);
        creerDPI(15, "Garcia", "Lena", "02/04/1946", Genre.FEMME, "14 Rue Félix Esclangon, 38000 Grenoble", 15);
        creerDPI(16, "David", "Ethan", "07/11/1998", Genre.HOMME, "39 Boulevard Joliot Curie, 38600 Fontaine", 16);
        creerDPI(17, "Bertrand", "Sarah", "23/04/1964", Genre.FEMME, "81 Avenue du Vercors, 38600 Fontaine", 17);
        creerDPI(18, "Roux", "Raphael", "29/03/1964", Genre.HOMME, "9 Avenue du Général de Gaulle, 38170 Seyssinet-Pariset", 18);
        creerDPI(19, "Vincent", "Camille", "30/04/1996", Genre.FEMME, "158 Rue Georges Maeder, 38170 Seyssinet-Pariset", 19);
        creerDPI(20, "Fournier", "Mael", "15/03/1984", Genre.HOMME, "Chemin de la Digue, 38180 Seyssins", 20);
        creerDPI(21, "Morel", "Maelys", "25/02/1975", Genre.FEMME, "3 Rue Geo Charles, 38130 Échirolles", 21);
        creerDPI(22, "Girard", "Tom", "03/12/1995", Genre.HOMME, "7 Rue Hector Berlioz, 38130 Échirolles", 22);
        creerDPI(23, "Andre", "Lina", "24/05/2007", Genre.FEMME, "2 Avenue de l Industrie, 38130 Échirolles", 23);
        creerDPI(24, "Lefevre", "Noah", "03/12/2004", Genre.HOMME, "67 Avenue de la République, 38130 Échirolles", 24);
        creerDPI(25, "Mercier", "Eva", "17/03/2015", Genre.FEMME, "24 Rue de la Liberté, 38130 Échirolles", 25);
        creerDPI(26, "Dupont", "Mathis", "16/06/1953", Genre.HOMME, "27 Avenue de Constantine, 38100 Grenoble", 26);
        creerDPI(27, "Lambert", "Louna", "29/02/1948", Genre.FEMME, "56 Rue de l Arlequin, 38100 Grenoble", 27);
        creerDPI(28, "Bonnet", "Theo", "18/02/1942", Genre.HOMME, "41 Rue des Chardonnerets, 38100 Grenoble", 28);
        creerDPI(29, "Francois", "Clara", "01/01/2004", Genre.FEMME, "44 Avenue Marcelin Berthelot, 38100 Grenoble", 29);
        creerDPI(30, "Martinez", "Adam", "27/11/1928", Genre.HOMME, "7 Rue Condillac, 38000 Grenoble", 30);

        //creation de 15 DMR
        creerDMR(1, "Martin", "Chloe", "31/12/1965", Genre.FEMME, "12 Rue Simon Nora, 38000 Grenoble", 1, true, false);
        creerDMR(2, "Bernard", "Lucas", "12/02/1985", Genre.HOMME, "17 Rue du Phalanstère, 38000 Grenoble", 2, true, false);
        creerDMR(3, "Dubois", "Lea", "02/04/1967", Genre.FEMME, "28 Boulevard Gambetta, 38000 Grenoble", 3, false, false);
        creerDMR(4, "Thomas", "Louis", "23/11/1954", Genre.HOMME, "635 Chemin de la Laurelle, 38330 Montbonnot-Saint-Martin", 4, false, false);
        creerDMR(5, "Robert", "Jade", "02/04/1995", Genre.FEMME, "8 Avenue Esclangon, 38610 Gières", 5, true, false);
        creerDMR(6, "Richard", "Gabriel", "12/12/2000", Genre.HOMME, "32 Rue du Repos, 38610 Gières", 6, true, false);
        creerDMR(7, "Petit", "Manon", "08/09/1999", Genre.FEMME, "46 Avenue Jean Jaurès, 38400 Saint-Martin-d Hères", 7, false, false);
        creerDMR(8, "Durand", "Jules", "23/12/2010", Genre.HOMME, "7 Rue Flora Tristan, 38400 Saint-Martin-d Hères", 8, false, false);
        creerDMR(9, "Leroy", "Louise", "31/07/1934", Genre.FEMME, "24 Avenue Gabriel Péri, 38400 Saint-Martin-d Hères", 9, true, false);
        creerDMR(10, "Moreau", "Timeo", "23/05/1984", Genre.HOMME, "42 Boulevard Clemenceau, 38100 Grenoble", 10, false, false);
        creerDMR(11, "Simon", "Zoe", "01/12/2016", Genre.FEMME, "29 Avenue Jean Perrot, 38100 Grenoble", 11, true, true);
        creerDMR(12, "Laurent", "Hugo", "23/12/1963", Genre.HOMME, "22 Avenue Albert 1er de Belgique, 38100 Grenoble", 12, false, false);
        creerDMR(13, "Lefebvre", "Lilou", "06/08/1996", Genre.FEMME, "50 Boulevard Gambetta, 38000 Grenoble", 13, false, false);
        creerDMR(14, "Michel", "Arthur", "25/06/1973", Genre.HOMME, "11 Cours Berriat, 38000 Grenoble", 14, true, false);
        creerDMR(15, "Garcia", "Lena", "02/04/1946", Genre.FEMME, "14 Rue Félix Esclangon, 38000 Grenoble", 15, true, false);

        //creation de 10 professionnels
        creerProfessionnel("legrandj", "azerty", "Legrand", "Jean", Statut.RADIOLOGUE);
        creerProfessionnel("garnierm", "azerty", "Garnier", "Marie", Statut.RADIOLOGUE);
        creerProfessionnel("faurep", "azerty", "Faure", "Philippe", Statut.RADIOLOGUE);
        creerProfessionnel("rousseaun", "azerty", "Rousseau", "Nathalie", Statut.CHEF_SERVICE);
        creerProfessionnel("blancm", "azerty", "Blanc", "Michel", Statut.MANIPULATEUR);
        creerProfessionnel("guerini", "azerty", "Guerin", "Isabelle", Statut.MANIPULATEUR);
        creerProfessionnel("mullera", "azerty", "Muller", "Alain", Statut.MANIPULATEUR);
        creerProfessionnel("henrys", "azerty", "Henry", "Sylvie", Statut.SECRETAIRE);
        creerProfessionnel("rousselp", "azerty", "Roussel", "Patrick", Statut.SECRETAIRE);
        creerProfessionnel("nicolasc", "azerty", "Nicolas", "Catherine", Statut.SECRETAIRE);

        //creation de 10 examens
        creerExamen(1, 2, "11/03/2017", "faurep", TypeExamen.SCANNER);
        creerExamen(2, 1, "12/03/2017", "faurep", TypeExamen.IRM);
        creerExamen(3, 8, "13/03/2017", "garnierm", TypeExamen.AUTRE);
        creerExamen(4, 10, "14/03/2017", "legrandj", TypeExamen.RADIOGRAPHIE);
        creerExamen(5, 15, "15/03/2017", "legrandj", TypeExamen.RADIOGRAPHIE);
        creerExamen(6, 5, "16/03/2017", "garnierm", TypeExamen.IRM);
        creerExamen(7, 2, "17/03/2017", "faurep", TypeExamen.SCANNER);
        creerExamen(8, 7, "18/03/2017", "legrandj", TypeExamen.RADIOGRAPHIE);
        creerExamen(9, 11, "19/03/2017", "faurep", TypeExamen.SCANNER);
        creerExamen(10, 1, "10/03/2017", "garnierm", TypeExamen.AUTRE);

        //ajout de comptes rendus
        ajouterCompteRendu(1, "Compte rendu");
        ajouterCompteRendu(2, "Compte rendu");
        ajouterCompteRendu(3, "Compte rendu");
        ajouterCompteRendu(4, "Compte rendu");
        ajouterCompteRendu(5, "Compte rendu");
        ajouterCompteRendu(6, "Compte rendu");

        //ajout de liens PACS
        ajouterLienPACS(1, "Lien PACS");
        ajouterLienPACS(2, "Lien PACS");
        ajouterLienPACS(3, "Lien PACS");
        ajouterLienPACS(4, "Lien PACS");
        ajouterLienPACS(5, "Lien PACS");
        ajouterLienPACS(6, "Lien PACS");

    }

}
