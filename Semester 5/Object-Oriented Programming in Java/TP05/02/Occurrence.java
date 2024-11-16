package ex2;
public class Occurrence {
    public static int nombreOcc(String s1, char c){
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            // comparer caractère par caractère
            // et incrementer 'count' si le caractère exist
            if (c == s1.toLowerCase().charAt(i)) count++;
        }
        return count;
    }
}