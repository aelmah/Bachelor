import java.util.Arrays;
import java.util.Scanner;

public class SearchBinary {
    public static void main(String[] args) {
        // Declaration et Initialization du tableau
        int[] Tab1 = {2, 3, 79, 4, 5, 6, 7, 8};

        // demande a l'utilisateur d'entrer la valeur chercher
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre svp :");

        // stocker la valeur
        int nbr_spé = scanner.nextInt();

        // trier le tableau

        Arrays.sort(Tab1);

        // afficher le tableau triér
        System.out.println(" la tableau trié est : "+Arrays.toString(Tab1));

        // on cherche la valeur entrer par l'utilisateur
        if (Arrays.binarySearch(Tab1, nbr_spé)>=0){
            System.out.println("l'indice de nombre chercher est : "+Arrays.binarySearch(Tab1, nbr_spé));
        }

    }
}


