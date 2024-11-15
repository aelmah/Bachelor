import java.util.Arrays;

public class TableauEntiers {
    // Méthode pour afficher le contenu d'un tableau d'entiers
    public void afficher(int[] t) {
        System.out.println("le tableau est : " + Arrays.toString(t));
    }

    // Méthode pour calculer la somme des éléments dans un tableau d'entiers
    public int somme(int[] t) {
        int S = 0;
        for (int i = 0; i < t.length; i++) {
            S = S + t[i]; // Calculer la somme des éléments dans le tableau
        }
        return S;
    }

    // Méthode pour calculer la moyenne des éléments dans un tableau d'entiers
    public int moyenne(int[] t) {
        int M = 0;
        M = somme(t) / t.length; // Calculer la moyenne en divisant la somme par le nombre d'éléments
        return M;
    }

    // Méthode pour trouver la valeur minimale dans un tableau d'entiers
    public int minimum(int[] t) {
        int Min = t[0]; // Supposons que le premier élément est le minimum
        for (int i = 0; i < t.length; i++) {
            if (t[i] < Min) {
                Min = t[i]; // Mettre à jour Min si une valeur plus petite est trouvée
            }
        }
        return Min;
    }

    // Méthode pour trouver la valeur maximale dans un tableau d'entiers
    public int maximum(int[] t) {
        int Max = t[0]; // Supposons que le premier élément est le maximum
        for (int i = 0; i < t.length; i++) {
            if (t[i] > Max) {
                Max = t[i]; // Mettre à jour Max si une valeur plus grande est trouvée
            }
        }
        return Max;
    }

    // Méthode pour trouver l'indice de la valeur maximale dans un tableau d'entiers
    public int max(int[] t) {
        int max = t[0]; // Supposons que le premier élément est le maximum
        int indice = 0; // Initialiser l'indice à 0
        for (int i = 1; i < t.length; i++) {
            if (t[i] > max) {
                max = t[i]; // Mettre à jour max si une valeur plus grande est trouvée
                indice = i; // Mettre à jour l'indice à la position actuelle
            }
        }
        return indice;
    }

    // Méthode pour créer et retourner un tableau avec des éléments inversés
    public int[] oppose(int[] t) {
        int[] tab = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            tab[i] = -t[i]; // Inverser le signe de chaque élément et le stocker dans le nouveau tableau
        }
        return tab;
    }

    // Méthode pour échanger des éléments aux indices i et j dans un tableau
    public int [] echanger(int[] tab2, int i, int j) {
        if (i < tab2.length && j < tab2.length) {
            int ech = tab2[i];  // Stocker la valeur à l'indice i
            tab2[i] = tab2[j]; // Remplacer la valeur à l'indice i par la valeur à l'indice j
            tab2[j] = ech; // Remplacer la valeur à l'indice j par la valeur stockée
        }
        return tab2;
    }
}
