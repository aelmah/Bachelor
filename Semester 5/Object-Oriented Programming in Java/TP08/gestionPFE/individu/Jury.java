package gestionPFE.individu;

import java.util.ArrayList;

public class Jury {
    private ArrayList<Prof> listJury;

    public Jury(ArrayList<Prof> listJury){
        if (listJury.size() >= 3){
            this.listJury = listJury;
        }else {
            System.out.println("Le nombre des membres de jury est insuffisant");
        }
        // you can use Exceptions
    }
    public void afficheJury(){
        System.out.println("la jury :");
        for (int i = 0; i < listJury.size(); i++) {
            System.out.println(listJury.get(i));
        }
    }
}
