package Ex1to3;
//EX2
public class Modification {
    // Méthode pour transposer un tableau à 2 dimensions
    public static int[][] transpose(int[][] tab) {
        int lignes = tab.length;
        int colonnes = tab[0].length;
        int[][] transposedTab = new int[colonnes][lignes];
        // Parcours du tableau d'origine
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                // Échange des éléments pour la transposition
                transposedTab[j][i] = tab[i][j];
            }
        }
        return transposedTab;
    }
    // Méthode pour afficher un tableau à 2 dimensions
    public static void afficher(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                // Affichage de chaque élément du tableau
                System.out.print(" " + tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}