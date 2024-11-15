public class Principale {
    public static void main (String [] args){
        Personne p1= new Personne("amal", "elmahraoui", "70 rue fes ");
        System.out.println("les informations de cette personne sont : "+p1.toString());
        Eleve e1 = new Eleve("ALMA", "Mazraoui", "80 RUE MARRAKECH ", "IDDL");
        System.out.println("les infos de l'elève sont: " +e1.toString());

        System.out.println("--------- ENSEIGNANT ------------");

        Enseignant Es1 = new Enseignant("Mohamed ", "Fahim", "FSTH", 11, 8);
        Enseignant Es2 = new Enseignant("Amal ", "Elmah", "FSTH", 14, 8);


        System.out.println("les informations des enseignants sont : "+Es1.toString());
        System.out.println("les informations des enseignants sont : "+Es2.toString());

        System.out.println(" l'echlon de l'enseignant est : " + Es1.echelonValide());
        System.out.println(" l'echlon de l'enseignant est : " + Es2.echelonValide());

        System.out.println("le salire de l'enseignant est : "+Es1.calculSalaire());



    }
}
