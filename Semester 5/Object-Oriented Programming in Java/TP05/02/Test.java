package ex2;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donner un mot : ");
        String mot = scanner.next();
        System.out.println("Donner un caractère : ");
        char c = scanner.next().charAt(0);
        System.out.println("Le nombre d'occurrence de "+c+" est :"+Occurrence.nombreOcc(mot,c));
    }
}




