package Ex1to3;
public class ModificationTest {
    public static void main(String[] args) {
        int[][] tab3 = {
            {10, 20, 30},
            {40, 50, 60}
        };
        int[][] tab4 = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };
        // Affiche le contenu de tab3
        Modification.afficher(tab3);
        System.out.println("============================");
        // Transpose et affiche le contenu de tab3 transposé
        Modification.afficher(Modification.transpose(tab3));
        System.out.println("============================");

        // Affiche le contenu de tab4
        Modification.afficher(tab4);
        System.out.println("============================");
        // Transpose et affiche le contenu de tab4 transposé
        Modification.afficher(Modification.transpose(tab4));
        System.out.println("============================");
    }
}