package ex5;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donner un verbe régulier du premier groupe : ");
        String verbe = scanner.next();
        Conjugaison.conjIndicatif(verbe);
    }
}



