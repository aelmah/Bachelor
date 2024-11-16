package ex3;
import ex2.*;
public class NonRepetitifs {
    public static void repetitifs(String mot){
        // transformer le mot a un tableau de caractère
        char[] character = mot.toCharArray();
        for (char c : character) {
            // utiliser la classe Occurrence
            if (Occurrence.nombreOcc(mot, c) == 1) {
                System.out.print(c + " ");
            }
        }
    }
}


/*
    autre etudiant:

        char[] character = mot.toCharArray();
        for(int i = 0 ; i < character.length ; i++){
            int count = 0;
            for(int j = 0 ;j < mot.length() ; j++){
                if(character[i] == mot.charAt(j)) count++;
            }
            if(count == 1) System.out.print(character[i]+" ");
        }
*/