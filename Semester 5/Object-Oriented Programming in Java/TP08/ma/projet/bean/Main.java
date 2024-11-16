package ma.projet.bean;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("######### Ex1 #########");
        Personne personne1 = new Personne(1,"Simo","Live",
                new Date(1990,1,20) ,30000,
                new Profil("1","Dr","directeur"));
        personne1.affiche();
        System.out.println("Salaire aprés augmentation de "+ personne1.getNom()
                            +" est: "+personne1.calculSalaire());

        Personne personne2 = new Personne(2,"Simo","Live",
                new Date("1998/05/21"),20000,
                new Profil("2","Emp","employé"));
        personne2.affiche();
        System.out.println("Salaire aprés augmentation de "+ personne2.getNom()
                            +" est: "+personne2.calculSalaire());

        System.out.println("######### Ex2 #########");
        Complexe c1 = new Complexe(1,4);
        Complexe c2 = new Complexe(-3,7);
        Complexe c3 = new Complexe(0,7);
        Complexe c4;
        c4 = (Complexe) c1.plus(c2);
        System.out.println(c1.affiche()+" + "+c2.affiche()+" = "+c4.affiche());
        System.out.println(c2.affiche()+" - "+c1.affiche()+" = "+((Complexe)c2.moins(c1)).affiche());
        System.out.println(c3.affiche()+" + "+c1.affiche()+" = "+((Complexe)c3.plus(c1)).affiche());

        Reel r1 = new Reel(52);
        Reel r2 = new Reel(10);
        System.out.println(r1.affiche()+" + "+r2.affiche()+" = "+((Reel)r1.plus(r2)).affiche());
    }
}
