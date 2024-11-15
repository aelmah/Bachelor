class TestTableau2dimensions {
    public static void main(String[] args) {
        // Création d'un tableau de test
        int[][] tableau = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int [][] T =Tableau2dimensions.transposee(tableau);

        // Affichage du tableau d'origine
        System.out.println("Tableau d'origine :");
        Tableau2dimensions.afficher(tableau);


        // Affichage du tableau transposé
        System.out.println("Tableau transposé :");
        Tableau2dimensions.afficher(T);
    }
}


