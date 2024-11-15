import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Scanner;

// classe fille Enseignant (Heritage de Personne)
public class Enseignant extends Personne{
    private double [] tauxsalaire= {40, 42, 43, 44, 46, 50, 52, 54, 56, 60, 65 };
    private LocalDate dateNaissance;
    public  int nbHeures;
    public int echelon;
    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String adresse, int echelon, int nbHeures) {
        super(nom, prenom, adresse);
        this.echelon= echelon;
        this.nbHeures = nbHeures;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom);
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    @Override
    public String getAdresse() {
        return super.getAdresse();
    }

    @Override
    public void setAdresse(String adresse) {
        super.setAdresse(adresse);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public boolean echelonValide( ){
        return this.echelon>=1 && this.echelon<=11;

    }
    public double getPrixHeure(int echelon) {
        if (echelonValide()){
            return tauxsalaire[echelon -1];

        } else return 0;
    }
    public double calculSalaire(){
        if (echelonValide()){
            return getPrixHeure(echelon)*nbHeures;
        }else return 0;

    }
    public int calculeage(){
        return Period.between(this.dateNaissance, LocalDate.now()).getYears();
    }

}
