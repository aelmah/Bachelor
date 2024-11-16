import java.util.Scanner;

public class Seconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Entrer le temp en second :");
        int second = scan.nextInt();

        int jour = second/(24*3600);
        second = second%(24*3600);

        int heure = second/3600;
        second = second%3600;

        int minute = second/60;
        second = second%60;

        System.out.println("Le temps est : "+jour+" jour "+heure+" heure "+minute+" minute "+second+" second");
    }
}
