
import java.util.Arrays; // Importation de la classe Arrays pour utiliser les méthodes de tri.

public class Tableautrié {
    public static void main(String[] args) {
        // Tableau des entiers :
        int[] TableauNumerique = {1, 2, 6, 7, 15, 9, 20}; // Déclaration et initialisation d'un tableau d'entiers.

        // Tableau des chaines :
        String[] Tableauchaine = {"Po", "Pi", "Pa"}; // Déclaration et initialisation d'un tableau de chaînes de caractères.

        // Trie le tableau numérique en ordre croissant :
        Arrays.sort(TableauNumerique); // Utilisation de la méthode "sort" de la classe Arrays pour trier le tableau d'entiers.

        // Trie le tableau de chaînes en ordre alphabétique :
        Arrays.sort(Tableauchaine); // Utilisation de la méthode "sort" de la classe Arrays pour trier le tableau de chaînes.

        // Affiche le tableau numérique trié :
        System.out.println("Tableau numérique trié : " + Arrays.toString(TableauNumerique));// Affiche le tableau d'entiers trié
        // sous forme de chaîne.

        // Affiche le tableau de chaînes trié :
        System.out.println("Tableau de chaînes trié : " + Arrays.toString(Tableauchaine));// Affiche le tableau de chaînes trié
        // sous forme de chaîne.
    }
}

