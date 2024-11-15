package Ex1to3;
import java.util.Arrays;
public class TabUtilsTest {
    public static void main(String[] args) {
        int[] tab1 = {1, 2, 3};
        int[] tab2 = {3, 2, 4};
        // Appel de la méthode "compareTab" de la classe "TabUtils" pour comparer les tableaux
        int[] result = TabUtils.compareTab(tab1, tab2);
        // Affichage du résultat sous forme de chaîne de caractères avec "Arrays.toString"
        System.out.println("new tab : " + Arrays.toString(result));
    }
}