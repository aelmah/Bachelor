import java.util.Arrays;

    public class TesterTableauEntiers {
        public static void main (String [] args ){

            int []t = new int [20];
            for (int i = 0; i<t.length; i++) {
                t[i] = 2 * i;
            }
            TableauEntiers T2 = new TableauEntiers();
            t [14]= 50;
            t[10]= -2;
            T2.afficher(t);

            System.out.println("la somme des elements est :"+ T2.somme(t));
            System.out.println("la moyenne des elements est :"+ T2.moyenne(t));
            System.out.println("l'indice du maximum est : " + T2.max(t));

            int[] tableauOppose = T2.oppose(t);
            System.out.println("l'opposé des éléments est : " + Arrays.toString(tableauOppose));

            int i = 5;
            int j = 15;
            T2.echanger(t, i, j);
            System.out.println("l'échange des éléments est : " + Arrays.toString(t));

        }
    }

