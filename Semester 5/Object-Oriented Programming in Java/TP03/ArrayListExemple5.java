import java.util.ArrayList;
public class ArrayListExemple5 {
    public static void main(String[] args) {
        ArrayList<String> animaux = new ArrayList<>();
        animaux.add("Chien");
        animaux.add("chat");
        animaux.add("Cheval");
        System.out.println("ArrayList: " + animaux);
        System.out.println("Acces aux elements: ");
        for (String a : animaux) {
            System.out.print(a);
            System.out.print(", ");
        }
    }
}