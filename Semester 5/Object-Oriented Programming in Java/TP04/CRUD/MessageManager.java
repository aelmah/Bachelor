package Ex4;
import java.util.ArrayList;
public class MessageManager {
    ArrayList<Message> messages = new ArrayList<>(5);
    // Méthode pour afficher tous les messages
    public void getAllMessages() {
        System.out.println("Les messages : ");
        for (Message message : messages) {
            System.out.println("Id : " + message.getId());
            System.out.println("Titre : " + message.getTitre());
            System.out.println("Date : " + message.getDate());
            System.out.println("Contenue : " + message.getContenue());
            System.out.println();
        }
    }
    // Méthode pour supprimer un message par son identifiant
    public void deleteMessage(int messageId) {
        Message messageSup = findMessageById(messageId);
        if (messageSup != null) {
            messages.remove(messageSup);
        } else {
            System.out.println("Message n'est pas trouvé.");
        }
    }
    // Méthode pour mettre à jour un message par son identifiant
    public void updateMessage(int messageId, String nouveauTitre, String nouveauDate, String nouveauContenu) {
        Message messageUp = findMessageById(messageId);
        if (messageUp != null) {
            messageUp.setTitre(nouveauTitre);
            messageUp.setDate(nouveauDate);
            messageUp.setContenue(nouveauContenu);
            System.out.println("Le message " + messageUp.getId() + " est mis à jour.");
        } else {
            System.out.println("L'id " + messageId + " n'existe pas.");
        }
    }
    // Méthode pour trouver un message par son identifiant
    public Message findMessageById(int messageId) {
        for (Message message : messages) {
            if (message.getId() == messageId) {
                return message;
            }
        }
        return null;
    }
    // Méthode pour trouver un message par son titre
    public Message findMessageByTitle(String messageTitre) {
        for (Message message : messages) {
            if (message.getTitre().equals(messageTitre)) {
                return message;
            }
        }
        return null;
    }
    // Méthode pour obtenir le nombre de messages dans la liste
    public int getNumberOfMessages() {
        return messages.size();
    }
    // Méthode pour obtenir le premier message dans la liste
    public Message getFirstMessage() {
        if (!messages.isEmpty()) return messages.get(0);
        else return null;
    }
    // Méthode pour obtenir le dernier message dans la liste
    public Message getLastMessage() {
        if (!messages.isEmpty()) return messages.get(messages.size() - 1);
        else return null;
    }
    // Méthode pour ajouter un message à la liste
    public void addMessage(Message message) {
        messages.add(message);
        System.out.println("Le message " + message.getId() + " est ajouté dans la liste.");
    }
}

/*
    Autre methode:
    public void deleteMessage(int messageId){
        boolean v = false;
        for(Message message : messages){
            if(message.getId() != messageId) {
                messages.remove(message);
                v = true;
                break;
            }
        }
        if(!v) System.out.println("Message n'est pas trouver.");
    }
*/