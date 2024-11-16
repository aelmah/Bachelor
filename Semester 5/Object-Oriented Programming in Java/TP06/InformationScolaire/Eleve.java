package InformationScolaire;
public class Eleve extends Personne{
    private String classe;
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
        return "Eleve : "+"\nnom : "+getNom()+
                "\nprenom : "+getPrenom()+
                "\nadresse : "+getAdresse()+
                "\nclasse : " +classe;
    }
}