import java.util.Scanner;

public class NombrePremier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number : ");

        int premier = 0;
        int number = scan.nextInt();

        for (int i = 1 ; i <= number ; i++){
            if (number % i == 0)
                premier++;
        }

        if (premier == 2) System.out.println(number + " est premier");
        else System.out.println(number + " n est pas premier");
    }
}
