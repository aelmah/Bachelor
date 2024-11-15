package Ex1to3;
//EX1
public class TabUtils {
    // Méthode pour comparer deux tableaux d'entiers
    public static int[] compareTab(int[] tab1, int[] tab2) {
        int[] tab;
        // Vérifie si les tableaux ont la même longueur
        if (tab1.length != tab2.length) {
            // Si la longueur est différente, retourne un tableau contenant -1
            return new int[]{-1};
        } else {
            // Si les tableaux ont la même longueur, crée un tableau pour stocker les résultats
            tab = new int[tab1.length];
            for (int i = 0; i < tab1.length; i++) {
                if (tab1[i] == tab2[i]) tab[i] = 0;
                else tab[i] = 1;
            }
        }
        return tab;
    }
}