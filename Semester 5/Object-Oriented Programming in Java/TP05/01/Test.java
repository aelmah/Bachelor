package ex1;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donner un mot : ");
        String mot1 = scanner.next();
        System.out.println("Donner un autre mot : ");
        String mot2 = scanner.next();
        System.out.println("Résultat : ");
        System.out.println(new Concat().concat(mot1,mot2));
    }
}