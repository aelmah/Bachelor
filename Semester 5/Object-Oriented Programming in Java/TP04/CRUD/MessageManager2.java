package Ex4;
import java.util.LinkedList;
public class MessageManager2 {
    LinkedList<Message> messages = new LinkedList<>();

    public LinkedList<Message> getAllMessages() {
        return messages;
    }
    public void deleteMessage(int messageId) {
        Message messageSup = findMessageById(messageId);
        if (messageSup != null) {
            messages.remove(messageSup);
        }
    }
    public void updateMessage(int messageId, String nouveauTitre, String nouveauDate, String nouveauContenu) {
        Message messageUp = findMessageById(messageId);
        if (messageUp != null) {
            messageUp.setTitre(nouveauTitre);
            messageUp.setDate(nouveauDate);
            messageUp.setContenue(nouveauContenu);
        }
    }
    public Message findMessageById(int messageId) {
        for (Message message : messages) {
            if (message.getId() == messageId) {
                return message;
            }
        }
        return null;
    }
    public Message findMessageByTitle(String messageTitre) {
        for (Message message : messages) {
            if (message.getTitre().equals(messageTitre)) {
                return message;
            }
        }
        return null;
    }
    public int getNumberOfMessages() {
        return messages.size();
    }
    public Message getFirstMessage() {
        return messages.getFirst();
    }
    public Message getLastMessage() {
        return messages.getLast();
    }
    public void addMessage(Message message) {
        messages.add(message);
    }
    @Override
    public String toString() {
        return "MessageManager{" + "messages=" + messages + '}';
    }
}