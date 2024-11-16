package InformationScolaire;
import java.time.LocalDate;

public class Enseignant extends Personne{
    private int echelon;
    private double nbHeures;
    private LocalDate dateNaissance;
    private static final double[] tauxSalaire = {40,42,43,44,46,50,52,54,56,60,65};
    public Enseignant(String nom, String prenom, String adresse, int echelon,double nbHeures,LocalDate dateNaissance) {
        super(nom, prenom, adresse);
        this.echelon = echelon;
        this.nbHeures = nbHeures;
        this.dateNaissance = dateNaissance;
        //Flconstructeur : String dateNaissance ; ... = LocalDate.parse(dateNaissance);
    }
    public int getEchelon() {
        return echelon;
    }
    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }
    public double getNbHeures() {
        return nbHeures;
    }
    public void setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    @Override
    public String toString() {
        return "Enseignant : \n"+super.toString()+
                "\nechelon : " +echelon+
                "\nnbHeures : "+nbHeures+
                "\nDate-Naissance : "+dateNaissance;
    }
    public boolean echelonValide(){
        return this.echelon > 0 && this.echelon <= tauxSalaire.length;
    }
    public double getPrixHeure(int echelon) throws Exception{
        if (echelonValide()) {
            return tauxSalaire[echelon-1];
        }
        else {
            throw new Exception("Echelon invalide");
        }
    }
    public double calculSalaire() throws Exception{
        if (echelonValide()) {
            System.out.print("Le salaire est : ");
            return getPrixHeure(this.echelon)*getNbHeures();
        }
        else {
            throw new Exception("Echelon invalide");
        }
    }
    public int calculAge(){
        System.out.print("L'age est : ");
        return LocalDate.now().getYear() - this.dateNaissance.getYear();
        //Autre methode : Period.between(this.dateNaissance,LocalDate.now()).getYear();
    }
}