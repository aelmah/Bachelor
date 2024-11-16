package ex4;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donner un mot : ");
        String mot = scanner.next();
        Voyelles.occurrenceVoyelles(mot);
    }
}



