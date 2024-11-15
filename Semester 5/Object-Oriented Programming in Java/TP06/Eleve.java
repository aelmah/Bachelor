public class Eleve extends Personne{
    String classe;

    public Eleve() {
    }
    public Eleve(String nom, String prenom, String adresse, String classe) {
        super(nom, prenom, adresse);
        this.classe = classe;
    }
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "classe='" + classe + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
