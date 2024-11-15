import java.util.Iterator;
import  java.util.LinkedList;
public class LinkedListExemple {
    public static void main(String args[]){
        LinkedList<String> list=new LinkedList<String>();
        list.add("Mohamed");
        list.add("Aymane");
        list.add("Merieme");
     //Ajoute d'un element à la première position
       list.addFirst("Rachid");
       // ajoute un element à la dernier position
       list.addLast("Aya");
    // Ajoute au deusième position
       list.add(2, "Fatima");
    // parcours d'une list
        Iterator<String>iterator= list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        }
    }
