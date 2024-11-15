import java.util.Scanner;
public class verbe {
    public void verb() {
        Scanner scan = new Scanner(System.in);
        String verbe;
        do {
            System.out.print("Donnez un verbe régulier du premier groupe terminé par 'er' : ");
            verbe = scan.nextLine();
        } while (!verbe.endsWith("er"));
        if (verbe.endsWith("er")) {

        }
        String radical = verbe.substring(0, verbe.length() - 2); //pour suprrimer les 2 dernier lettre
        System.out.println("je " + radical + "e");
        System.out.println("tu " + radical + "es");
        System.out.println("il " + radical + "e");
        System.out.println("nous " + radical + "ons");
        System.out.println("vous " + radical + "ez");
        System.out.println("ils " + radical + "ent");
    }

    public static void main(String[] args) {
        verbe obj = new verbe(); //création d'un objet.
        obj.verb(); //l'appel de la methode
    }
}

