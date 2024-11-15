package Ex4;
public class MessageManagerTest {
    public static void main(String[] args) {
        // Créer une instance de MessageManager pour gérer les messages
        MessageManager messageManager = new MessageManager();

        // Créer cinq instances de la classe Message avec des informations différentes
        Message message1 = new Message(1,"1er Message","01/12/2023","Lundi");
        Message message2 = new Message(2,"2éme Message","03/12/2023","Mardi");
        Message message3 = new Message(3,"3éme Message","05/12/2023", "Mercredi");
        Message message4 = new Message(4,"4éme Message","07/12/2023", "Jeudi");
        Message message5 = new Message(5,"5éme Message","12/12/2023", "Vendredi");
        Message message6 = new Message(6,"5éme Message","12/12/2023", "Vendredi");

        // Ajouter les messages créés à MessageManager
        messageManager.addMessage(message1);
        messageManager.addMessage(message2);
        messageManager.addMessage(message3);
        messageManager.addMessage(message4);
        messageManager.addMessage(message5);
        messageManager.addMessage(message6);

        // Afficher tous les messages
        messageManager.getAllMessages();
        System.out.println("==========================================");

        // Supprimer le deuxième message par son ID
        System.out.println("On supprime le 2éme message : ");
        messageManager.deleteMessage(2);
        messageManager.getAllMessages();
        System.out.println("==========================================");

        // Mettre à jour le message avec l'ID 3
        messageManager.updateMessage(3,"message mis à jour","25/05/2003","hello world!");
        messageManager.getAllMessages();
        System.out.println("==========================================");

        // Obtenir le nombre total de messages
        System.out.println("Il y a "+messageManager.getNumberOfMessages()+" messages");
        System.out.println("==========================================");

        // Obtenir le premier et le dernier message
        System.out.println("Le premier message : "+ messageManager.getFirstMessage());
        System.out.println("Le dernier message : "+messageManager.getLastMessage());
        System.out.println("==========================================");

        // Trouver un message par son ID (3) et par son titre ("1er titre")
        System.out.println("Le message par ID 3: "+messageManager.findMessageById(3));
        System.out.println("Le message par titre '1er titre': "+messageManager.findMessageByTitle("1er titre"));
    }
}