import java.util.Arrays;

public class TesterTdouble {
    public static void main(String[]args){
        double[][] t1 ={{1,2,3},{1,1,1},{1,2,1}};
        double[][] t2 ={{1,2,3},{4,5,1},{1,2,1}};
        double[][] T;
        System.out.println("la fichage de votre tableau");
        Tdouble.afficher(t1);
        System.out.println("le tableau il est reguiler:");
        System.out.println(Tdouble.regulier(t1));
        System.out.println("la somme de les lignes de votre tableau");
        System.out.println(Arrays.toString(Tdouble.sommeLignes(t1)));
        System.out.println("1er tableau : ");
        Tdouble.afficher(t1);
        System.out.println(" ");
        System.out.println("2éme tableau :");
        Tdouble.afficher(t2);
        System.out.println(" ");
        System.out.println("tableau somme");
        T=Tdouble.sommme(t1,t2);
        Tdouble.afficher(T);
    }
}

