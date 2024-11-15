import java.util.ArrayList;

public class Messagess {
    private int id;
    private String titre;
    private String date;
    private String contenu;

    public Messagess(int id, String titre, String date, String contenu) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.contenu = contenu;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Messagess{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", date='" + date + '\'' +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}

class MessageManager{
    private ArrayList<Messagess> messageList = new ArrayList<>();

    public void getAllMessages() {
        for (Messagess M : messageList) {
            System.out.println( M.getId());
        }
    }

    public void deleteMessage(int id) {
        boolean found = false;
        for (Messagess M : messageList) {
            if (M.getId() == id) {
                messageList.remove(M);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("The message with ID " + id + " does not exist in the list.");
        }
    }

    public Messagess findMessageById(int id) {
        for (Messagess M : messageList) {
            if (M.getId() == id) {
                return M;
            }
        }
        return null;
    }

    public void updateMessage(int id, String title, String date, String contenu) {
        Messagess msg = findMessageById(id);
        if (msg != null) {
            msg.setTitre(title);
            msg.setDate(date);
            msg.setContenu(contenu);
        } else {
            System.out.println("Message with ID " + id + " does not exist.");
        }
    }

    public Messagess findMessageByTitle(String messageTitre) {
        for (Messagess M : messageList) {
            if (M.getTitre().equals(messageTitre)) {
                return M;
            }
        }
        return null;
    }

    public int getNumberOfMessages() {
        return messageList.size();
    }

    public Messagess getFirstMessage() {
        if (!messageList.isEmpty()) {
            return messageList.get(0);
        }
        return null;
    }

    public Messagess getLastMessage() {
        if (!messageList.isEmpty()) {
            return messageList.get(messageList.size() - 1);
        }
        return null;
    }

    public void addMessage(Messagess msg) {
        messageList.add(msg);
    }
}
