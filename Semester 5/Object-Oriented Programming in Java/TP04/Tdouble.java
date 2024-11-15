public class Tdouble {
public static void afficher(double[][] t){
        for(int i=0; i<t.length;i++){
            for(int j=0; j<t[i].length;j++){
              System.out.print(" " +t[i][j] + " ");
            }
               System.out.println();
        }
    }

    public static boolean regulier(double[][] t) {
        int longuer = t[0].length;  //la longeur de premiere ligne
        for (int i = 0; i < t.length; i++){
            if (t[i].length!=longuer)
                return false;

        }
        return true;
        }
    public static double[] sommeLignes(double[][] t){
        double[] resultat =new double[t.length];
        for(int i=0; i<t.length;i++){
        double s=0;
            for(int j=0;j<t[i].length;j++){
                s=s+t[i][j];
            }
            resultat[i]=s;
        }
        return resultat;
    }
    public static double[][]sommme(double[][] t1, double[][] t2){
        double[][] T =new double[t1.length][t1[0].length];
        if(t1.length!= t2.length || t1[0].length!=t2[0].length||
                !regulier(t1)|| !regulier(t2)){ //si les 2 tab sont pas regulier et de meme taille
            System.out.println("\n rentrer deux tableaux regulier et de meme dimension!\n");
            return null;
        }
        else{
            double somme=0;
            for(int i=0;i<t1.length;i++){
                for(int j=0; j<t1[i].length;j++){
                    somme=t1[i][j]+t2[i][j];
                    T[i][j]=somme;
                }
            }return T;
        }
    }

    }
