import java.util.Scanner;
public class ArrayMethodeExample {
    public int max(int[] tab) {
        int max = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer la taille du tavleau");
        int t = sc.nextInt();
        int[] arr = new int[t];
        System.out.println("Entrer les elements du tableau :");
        for(int i=0; i<t; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayMethodeExample m = new ArrayMethodeExample();
        System.out.println("valeur max du tableau est:"+m.max(arr));
    }
}
