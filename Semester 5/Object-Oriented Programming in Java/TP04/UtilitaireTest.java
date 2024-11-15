package Ex1to3;
import java.util.Arrays;
public class UtilitaireTest {
    public static void main(String[] args) {
        double[][] tab5 = {
                {4, 5, 12},
                {5, 4.5, 5.5}
        };
        double[][] tab6 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}
        };
        double[][] tab7 = {};
        double[][] tab8 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] tab9 = {
                {1, 2},
                {4, 5}
        };
        Utilitaire.affiche(tab5);
        System.out.println("Est-ce que tab5 est régulier ? : " + Utilitaire.regulier(tab5));
        Utilitaire.affiche(tab6);
        System.out.println("Est-ce que tab6 est régulier ? : " + Utilitaire.regulier(tab6));
        System.out.println("Est-ce que tab7 est régulier ? : " + Utilitaire.regulier(tab7));
        System.out.println("###########################################################");
        System.out.println("Le tableau de la somme des lignes de tab5 : " + Arrays.toString(Utilitaire.sommeLignes(tab5)));
        System.out.println("Le tableau de la somme des lignes de tab6 : " + Arrays.toString(Utilitaire.sommeLignes(tab6)));
        System.out.println("###########################################################");
        System.out.println("La somme de tab5 et tab8 :");
        Utilitaire.affiche(Utilitaire.somme(tab5, tab8));
        System.out.println("La somme de tab5 et tab9 :");
        Utilitaire.affiche(Utilitaire.somme(tab5, tab9));
    }
}