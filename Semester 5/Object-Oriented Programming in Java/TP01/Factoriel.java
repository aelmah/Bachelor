import java.util.Scanner;

public class Factoriel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrer un nombre :");
        int entier = scan.nextInt();

        int factorial = 1;

        if (entier == 0) {
            System.out.println(entier+"! = 1");
        }
        else {
            for (int i = 1 ; i <= entier ; i++) {
                factorial = factorial * i;
            }
            System.out.println(entier+"! = "+factorial);
        }

    }
}
