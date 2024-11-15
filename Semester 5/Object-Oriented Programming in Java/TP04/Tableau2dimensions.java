public class Tableau2dimensions {
    // Méthode pour transposer un tableau à deux dimensions
    public static int [][] transposee(int[][] t) {
        int colonnes = t[0].length; // Nombre de colonnes dans le tableau d'origine
        int lignes = t.length;      // Nombre de lignes dans le tableau d'origine
        int[][] tabtransposee = new int[colonnes][lignes]; // Tableau pour stocker la transposée


        // Parcours des lignes du tableau d'origine
        for (int i = 0; i < lignes; i++) {
            // Parcours des colonnes du tableau d'origine
            for (int j = 0; j < colonnes; j++) {
                // Transposer les éléments en échangeant les indices
                tabtransposee[j][i] = t[i][j];
                // Aucun besoin d'imprimer une ligne vide à chaque itération
            }
        }return tabtransposee;
    }

    // Méthode pour afficher un tableau à deux dimensions
    public static void afficher(int[][] t) {
        // Parcours des lignes du tableau d'origine
        for (int i = 0; i < t.length; i++) {
            // Parcours des colonnes du tableau d'origine
            for (int j = 0; j < t[i].length; j++) {
                // Affichage de l'élément du tableau suivi d'un espace
                System.out.print(t[i][j] + " ");
            }
            // Passage à la ligne suivante après avoir imprimé une ligne du tableau
            System.out.println();
        }
    }
}
