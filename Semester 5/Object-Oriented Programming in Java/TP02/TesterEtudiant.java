public class TesterEtudiant {
    public static void main (String [] args ){

        Etudiant Etudiant1 = new Etudiant("Inaya","fouradi", "s123456", 24);
        System.out.println(" les information de l'etudiant sont : " );
        Etudiant1.afficheEtudiant();
        Etudiant1.incrimentAge(1);
        System.out.println("l'age de l'etudiante est : ");
        Etudiant1.incrimentAge(1);

    }
}