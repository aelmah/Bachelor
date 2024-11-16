package ex4;
import ex2.*;
public class Voyelles {
    public static void occurrenceVoyelles(String mot) {
        char[] lettre = {'a','e','i','o','u','y'};
        for(char c : lettre){
            //utiliser la classe Occurrence pour trouver combien de fois une voyelle
            //dans le tableau de lettre se répète dans un mot
            System.out.println("La lettre "+c+" occurre "+Occurrence.nombreOcc(mot, c) +" fois.");
        }
    }
}