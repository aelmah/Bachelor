package gestionPFE.Main;

import gestionPFE.individu.Etudiant;
import gestionPFE.individu.Jury;
import gestionPFE.individu.Prof;
import gestionPFE.livrable.CodeSources;
import gestionPFE.livrable.Livrable;
import gestionPFE.livrable.Pfe;
import gestionPFE.livrable.Rapport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class MainProg {
    public static void main(String[] args) {
        Etudiant etudiant1 = new Etudiant("Bahlaouane","Salaheddine","bruh@gmail.com","0615487952","R789456321","IDDL");
        Etudiant etudiant2 = new Etudiant("BayBay","Badr","bruh2@gmail.com","0615487952","R789476321","IDDL");

        //Les profs
        Prof prof1 = new Prof("Fahim","Mohamed","prof1@gmail.com","0612354897","BJ98754","PA");
        Prof prof2 = new Prof("Salimi","Amine","prof2@gmail.com","06123458497","Rl87456","PH");
        Prof prof3 = new Prof("Bahi","Salim","prof3@gmail.com","0687543219","RF87654","PES");
        Prof prof4 = new Prof("BahiL","Salima","prof4@gmail.com","0687578219","RF95654","PH");
        Prof prof5 = new Prof("Nafili","Karima","prof5@gmail.com","0687556219","RM98754","PES");

        //Le jury
        ArrayList<Prof> membreDeJury = new ArrayList<>();
        membreDeJury.add(prof1);
        membreDeJury.add(prof2);
        membreDeJury.add(prof3);

        Jury jury1 = new Jury(membreDeJury);
        Jury jury2 = new Jury(new ArrayList<>(Arrays.asList(prof1,prof5,prof4)));

        //Les livrable1
        Rapport rapport1 = new Rapport(65,"Français","insert text here","Rapport de stage de l'Application de gestion des PFE");
        CodeSources codeSource1 = new CodeSources("\npackage gestionPFE.individu;\n" +
                "\n" +
                "import java.util.ArrayList;\n" +
                "\n" +
                "public class Jury {\n" +
                "    private ArrayList<Prof> listJury;\n" +
                "\n" +
                "    public Jury(ArrayList<Prof> listJury){\n" +
                "        if (listJury.size() >= 3){\n" +
                "            this.listJury = listJury;\n" +
                "        }else {\n" +
                "            System.out.println(\"Le nombre des membres de jury est insuffisant\");\n" +
                "        }\n" +
                "    }\n" +
                "    public void afficheJury(){\n" +
                "        System.out.println(\"la jury :\");\n" +
                "        for (int i = 0; i < listJury.size(); i++) {\n" +
                "            System.out.println(listJury.get(i).getNom());\n" +
                "        }\n" +
                "    }\n" +
                "}","Java");

        ArrayList<Livrable> livrable1 = new ArrayList<>();
        livrable1.add(rapport1);
        livrable1.add(codeSource1);

        Rapport rapport2 = new Rapport(50,"English","insert text here","Rapport stage de l'Application des gestions de banque");
        CodeSources codeSource2 = new CodeSources("\npublic class MiniBanque {\n" +
                "    public static void main(String[] args) throws Exception {\n" +
                "        Banque banque = new Banque();\n" +
                "        banque.interaction();\n" +
                "    }\n" +
                "}","Java");

        //Les pfe
        Pfe pfe1 = new Pfe(etudiant1,"Gestion pfe", LocalDate.of(2023,12,03),"Bruh.inc",15.5,prof1,livrable1);
        pfe1.affecterJury(jury1);
        Pfe pfe2 = new Pfe(etudiant2,"Gestion banque", LocalDate.of(2023,12,04),"Bruh2.inc",15.5,prof2,
                new ArrayList<>(Arrays.asList(rapport2,codeSource2)));
        pfe2.affecterJury(jury2);

        //Affichage de toutes les infos
        //affichage les info d'etudiant 1 /ses pfe /membre de jury
        System.out.println(pfe1);
        System.out.println("########################################");
        jury1.afficheJury();
        System.out.println("############### Livrable ###############");
        pfe1.printAllLivrables();
        System.out.println("//////////////////////////////////////////");
        
        //affichage les info d'etudiant 2 /ses pfe /membre de jury
        System.out.println(pfe2);
        System.out.println("########################################");
        jury2.afficheJury();
        System.out.println("############### Livrable ###############");
        pfe2.printAllLivrables();
    }
}
