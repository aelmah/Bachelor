import java.util.ArrayList;
import java.util.Scanner;

public class Banque {
    private static final int MAX_CLIENTS = 100;
    private int nbClients;
    // Liste des clients
    public static ArrayList<Client> clients = new ArrayList<>();

    // methode pour l'unicité de nom de client
    public Client trouverClientParNom(String nom){
        for (Client client : clients){
            if (client.getNom().equals(nom)){
                return client;
            }
        }
        return null;
    }
    // methode d'ajout de client
    public void ajouterClient(String nomClient) throws Exception{
        if (trouverClientParNom(nomClient)==null && clients.size() < MAX_CLIENTS){
            clients.add(new Client(nomClient));
            System.out.println("Le client "+nomClient+" a été créé.");
            nbClients++;
        }
        else {
            throw new Exception("Error d'ajout de client.");
        }
    }
    public void interaction() throws Exception {
        int choix;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*************** Menu Banque ***************");
            System.out.println("Nombre des clients du banque : "+nbClients);
            System.out.println("Quelle opération voulez-vous effectuer?");
            System.out.println("1) Ajouter un client.");
            System.out.println("2) Effectuer une operation sur un client.");
            System.out.println("3) Quitter le programme.");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("Entrer le nom de client : ");
                    ajouterClient(scanner.next());
                    break;
                case 2:
                    if (clients.isEmpty()){
                        System.out.println("Aucun client disponible.");
                        break;
                    }
                    System.out.println("Quel client?");
                    //afficher la liste des clients
                    for (int i = 0; i < nbClients; i++) {
                        System.out.println((i+1)+") "+clients.get(i).getNom());
                    }
                    //selection d'un client
                    int index = scanner.nextInt();
                    clients.get(index-1).operationClient(index);
                    break;
                case 3:
                    System.out.println("Au revoir");
                    break;
                default: System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }while (choix != 3);
    }
}