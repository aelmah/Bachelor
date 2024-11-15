package Ex1to3;
//EX3
public class Utilitaire {
    // Méthode pour afficher un tableau de doubles
    public static void affiche(double[][] t) {
        for (double[] tab : t) {
            for (double val : tab) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    // Méthode pour vérifier si un tableau de doubles est régulier(toutes les lignes ont la même longueur)
    public static boolean regulier(double[][] t) {
        if (t.length != 0) {
            int tailleLigne1 = t[0].length;
            for (int i = 1; i < t.length; i++) {
                if (t[i].length != tailleLigne1) return false;
            }
        }
        return true;
    }
    // Méthode pour calculer la somme des éléments de chaque ligne d'un tableau de doubles
    public static double[] sommeLignes(double[][] t) {
        double[] sommeLigne = new double[t.length];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                sommeLigne[i] += t[i][j];
            }
        }
        return sommeLigne;
    }
    // Méthode pour additionner deux tableaux de doubles, si ils sont compatibles
    public static double[][] somme(double[][] t1, double[][] t2) {
        if (!regulier(t1) || !regulier(t2) || t1.length != t2.length || t1[0].length != t2[0].length) {
            return new double[][]{{0}, {0}};
        } else {
            int lignes = t1.length;
            int colonnes = t1[0].length;
            double[][] somme2tab = new double[lignes][colonnes];
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    somme2tab[i][j] = t1[i][j] + t2[i][j];
                }
            }
            return somme2tab;
        }
    }
}