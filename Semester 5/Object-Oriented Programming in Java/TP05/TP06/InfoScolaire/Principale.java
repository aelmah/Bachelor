package InformationScolaire;
import java.time.LocalDate;

public class Principale{
    public static void main(String[] args) {
        Personne personne = new Personne("Simo","Live","Al hoceima");
        Personne eleve = new Eleve("Bahlaouane", "Salaheddine",
                "Casablanca", "IDDL");
        Enseignant enseignant1 =
                new Enseignant("Fahim", "Mohamed",
                        "Hoceima",11,
                        80 ,LocalDate.of(1980,5,23));
        Enseignant enseignant2 = new Enseignant("Alaouite","ALi",
                "Nador",12,
                125,LocalDate.of(1990,12,30));

        System.out.println(personne);
        System.out.println();
        System.out.println(eleve);
        System.out.println();
        System.out.println(enseignant1);
        try {
            System.out.println(enseignant1.calculSalaire());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(enseignant1.calculAge());
        System.out.println();
        System.out.println(enseignant2);
        try {
            System.out.println(enseignant2.calculSalaire());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(enseignant2.calculAge());
    }
}