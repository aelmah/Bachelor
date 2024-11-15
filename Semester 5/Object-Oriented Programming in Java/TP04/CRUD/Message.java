package Ex4;
public class Message {
    // Attributs de la classe Message
    private int id;
    private String titre;
    private String date;
    private String contenue;
    // Constructeur par défaut
    public Message() {
    }
    // Constructeur avec paramètres
    public Message(int id, String titre, String date, String contenue) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.contenue = contenue;
    }
    // Méthodes d'accès pour l'attribut "id"
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // Méthodes d'accès pour l'attribut "titre"
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    // Méthodes d'accès pour l'attribut "date"
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    // Méthodes d'accès pour l'attribut "contenu"
    public String getContenue() {
        return contenue;
    }
    public void setContenue(String contenue) {
        this.contenue = contenue;
    }
    // Méthode pour afficher les détails du message
    @Override
    public String toString() {
        return "\nMessage ID: " + id + "\nTitre: " + titre + "\nDate: " + date + "\nContenu: " + contenue + "\n";
    }
}