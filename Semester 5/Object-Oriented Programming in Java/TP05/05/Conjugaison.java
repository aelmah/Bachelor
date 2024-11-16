package ex5;
import java.util.Scanner;
public class Conjugaison {
    public static void conjIndicatif(String verbe) {
        Scanner scanner = new Scanner(System.in);
        //Creation d'un tableau des pronoms et des terminaisons
        String[] pronom = {"je", "tu", "il/elle", "nous", "vous", "ils/elles"};
        String[] terminaison = {"e", "es", "e", "ons", "ez", "ent"};

        //si le verbe ne se termine pas par 'er' on entre dans la boucle
        while (!verbe.endsWith("er")) {
            System.out.print(verbe + " ne se termine pas par 'er' donnez-en un autre : ");
            verbe = scanner.next();
        }
        //si le verbe se termine par 'er', on supprime les deux dérnier lettre
        String newVerbe = verbe.substring(0, verbe.length() - 2);
        //conjugaisons de nouveau verbe
        if (newVerbe.endsWith("g")){
            terminaison[3] = "eons";
            for (int i = 0; i < pronom.length; i++) {
                System.out.println(pronom[i]+" "+newVerbe+terminaison[i]);
            }
        }else{
            for (int i = 0; i < pronom.length; i++) {
                System.out.println(pronom[i]+" "+newVerbe+terminaison[i]);
            }
        }
    }
}