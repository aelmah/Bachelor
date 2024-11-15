
public class pairsetimpairs {
    public static void main(String[] args) {

        // Déclaration et initialisation d'un tableau d'entiers
        int[] tab = {1, 5, 7, 12, 16, 9};

        // Initialisation de deux compteurs, un pour les nombres pairs (p) et un pour les nombres impairs (ip)
        int p = 0, ip = 0;

        // Parcours du tableau pour compter les nombres pairs et impairs
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) {
                // Si le nombre à l'indice i est pair, incrémentez le compteur p
                p++;
            } else {
                // Sinon, incrémentez le compteur ip
                ip++;
            }
        }

        // Affichage du nombre de nombres pairs et impairs
        System.out.println("le nombre des paires est : " + p);
        System.out.println("le nombre des impairs est : " + ip);
    }
}
