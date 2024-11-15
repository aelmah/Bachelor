public class Voyelles {
    // Méthode pour compter les voyelles (a, e, i, o, u, y).
    public void voyelles(String s) {
        // Initialisation des compteurs à 0.
        int a = 0;
        int e = 0;
        int I = 0;
        int o = 0;
        int u = 0;
        int y = 0;

        // Parcourir chaque caractère de la chaîne.
        for (int i = 0; i < s.length(); i++) {
            char lettre = s.charAt(i); // Obtenir le caractère courant de la chaîne.

            // Vérifier le caractère courant et incrémenter le compteur approprié s'il s'agit d'une voyelle.
            if (lettre == 'a' || lettre == 'A') {
                a++;
            } else if (lettre == 'e' || lettre == 'E') {
                e++;
            } else if (lettre == 'i' || lettre == 'I') {
                I++;
            } else if (lettre == 'o' || lettre == 'O') {
                o++;
            } else if (lettre == 'u' || lettre == 'U') {
                u++;
            } else if (lettre == 'y' || lettre == 'Y') {
                y++;
            }
        }

        // Afficher le nombre d'occurrences de chaque voyelle.
        System.out.println(a + " fois la lettre a");
        System.out.println(e + " fois la lettre e");
        System.out.println(I + " fois la lettre I");
        System.out.println(o + " fois la lettre o");
        System.out.println(u + " fois la lettre u");
        System.out.println(y + " fois la lettre y");
    }

    public static void main(String[] args) {
        Voyelles j = new Voyelles(); // Création d'un objet de la classe Voyelles.
        // Appel de la méthode pour compter les voyelles dans la chaîne.
        j.voyelles("Anticonstitutionnellement");
    }
}


