public class Occurence {

        // Méthode pour compter le nombre d'occurrences d'un caractère spécifié dans une chaîne donnée.
        public int nomberOccu(String s1, char c) {
            int j = 0; // Initialiser un compteur à 0.


            for (int i = 0; i < s1.length(); i++) {

                if (s1.charAt(i) == c) {
                    j++; // Incrémenter le compteur si une correspondance est trouvée.
                }
            }


            return j;
        }
}
