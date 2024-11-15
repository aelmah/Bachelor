class nonRepetitifs {
    // Méthode pour extraire les caractères non répétitifs d'une chaîne de texte.
    public String nonrepititive(String s) {
        String res = ""; // Initialisation de la chaîne de résultat à vide.

        // Parcourir chaque caractère de la chaîne.
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Obtenir le caractère courant.

            // Vérifier si le caractère n'apparaît qu'une seule fois dans la chaîne.
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                res += c; // Ajouter le caractère à la chaîne de résultat.
            }
        }

        return res; // Retourner la chaîne de caractères non répétitifs.
    }

    public static void main(String[] args) {
        String s = "YANISSERINESARAH";
        nonRepetitifs o = new nonRepetitifs();
        System.out.println("les caractères non répétitifs sont : ");
        System.out.println(o.nonrepititive(s)); // Afficher les caractères non répétitifs dans la chaîne.
    }
}
