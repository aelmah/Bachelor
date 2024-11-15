import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    public static final int MAX_COMPTE = 10;
    private final String nom;
    private int nbComptes;
    // Liste des comptes
    ArrayList<Compte> comptes = new ArrayList<>();
    public String getNom() {
        return nom;
    }

    public Client(String nom){
        this.nom = nom;
        //ajouter un compte a chaque client crée
        Compte newCompte = new Compte(1,0);
        this.comptes.add(newCompte);
        nbComptes++;
    }
    // methode d'ajout d'un compte
    public void ajouterCompte(Compte newCompte) throws Exception{
        if (this.comptes.size() < MAX_COMPTE) {
            this.comptes.add(newCompte);
            System.out.println("Le compte n° "+comptes.size()+" a été ajouter avec success.");
            nbComptes++;
        }
        else { // cas de depasser le nombre des comptes
            throw new Exception("Il existe déja 10 comptes.");
        }
    }
    // methode de calcul de solde total
    public double soldeTotal(){
        double soldeTotal = 0;
        for (Compte compte : this.comptes){
            soldeTotal += compte.getSolde();
        }
        return soldeTotal;
    }
    // methode d'affichage de bilan de client
    public void bilanClient(){
        System.out.println("*************** Bilan de '"+getNom()+"' ***************");
        System.out.println("Nombre de comptes : "+this.nbComptes);
        System.out.println("Le solde total : "+soldeTotal()+" Dh");
        for (int i = 0; i < this.comptes.size(); i++) {
            Compte compte = comptes.get(i);
            System.out.println("Le solde du compte n°"+(i+1)+" est de "+compte.getSolde()+" Dh");
        }
    }
    // methode des operations sur le client
    public void operationClient(int index){
        // choix de client dans la liste des clients de la banque
        if (index > 0 && index <= Banque.clients.size()){
            // declaration des var et objets
            int val;
            double money;
            Scanner scanner = new Scanner(System.in);
            Client client = Banque.clients.get(index-1); //recuperation de client
            do {
                System.out.println("*************** Menu Client ***************");
                System.out.println("Quelle opération voulez-vous effectuer sur {"+getNom()+"}?");
                System.out.println("1) Afficher un bilan.");
                System.out.println("2) Faire un retrait.");
                System.out.println("3) Faire un dépôt.");
                System.out.println("4) Faire un virement.");
                System.out.println("5) Ajouter compte.");
                System.out.println("6) Revenir au Menu Banque.");
                val = scanner.nextInt();
                switch (val){
                    case 1:
                        client.bilanClient();
                        break;
                    case 2:
                        System.out.println("********* Retrait *********");
                        System.out.println("Entrer le montant du retrait :");
                        money = scanner.nextDouble();
                        try {
                            client.comptes.get(0).retrait(money);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("********* Depôt *********");
                        System.out.println("Entrer le montant du dépôt :");
                        money = scanner.nextDouble();
                        try {
                            client.comptes.get(0).depot(money);
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("********* Virement *********");
                        virement(index);
                        break;
                    case 5:
                        System.out.println("********* Ajouter un compte *********");
                        System.out.println("Montant a ajouter :");
                        money = scanner.nextDouble();
                        if (money >= 0){
                            int n = client.comptes.size();
                            Compte newCompte = new Compte(n,money);
                            try {
                                client.ajouterCompte(newCompte);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            client.bilanClient();
                        }
                        break;
                    case 6:
                        System.out.println("Bye Bye");
                        break;
                    default: System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            }while (val != 6);
        }else {
            System.out.println("Choix invalide.");
        }
    }
    // methode de cas de virement
    public void virement(int index){
        Client client = Banque.clients.get(index-1);
        Scanner scanner = new Scanner(System.in);
        //choix de client
        System.out.println("Choix de client : ");
        for (int i = 0; i < Banque.clients.size();i++) {
            System.out.println((i+1)+") "+Banque.clients.get(i).getNom());
        }
        int choixClient = scanner.nextInt();
        System.out.println("Entre le montant a virer:");
        double money = scanner.nextDouble();
        Client destinataire = Banque.clients.get(choixClient-1);
        // cas où le client est le meme
        if (destinataire.getNom().equals(client.getNom())){
            if (client.comptes.size() < 2) {
                System.out.println("Il faut avoir au moins deux comptes");
            }else {
                System.out.println("Voici votre comptes :");
                // affichage des comptes
                for (int i = 0; i < client.comptes.size(); i++) {
                    System.out.println((i+1)+") Compte n°"+(i+1));
                }
                System.out.println("Entrer le numéro de compte a virer :");
                int choix = scanner.nextInt();
                System.out.println("Entrer le numero de compte de virement :");
                int choix2 = scanner.nextInt();
                //logique
                if (choix > 0 && choix2 > 0 && choix <= client.comptes.size() && choix2 <= client.comptes.size()){
                    try {
                        client.comptes.get(choix2-1).virer(money,client.comptes.get(choix-1));
                    } catch (Exception e) { //cas de solde insuffisant
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else{//Autre client
            try {
                client.comptes.get(0).virer(money,destinataire.comptes.get(0));
            }catch (Exception e){ //cas de solde insuffisant
                System.out.println(e.getMessage());
            }
        }
    }
}