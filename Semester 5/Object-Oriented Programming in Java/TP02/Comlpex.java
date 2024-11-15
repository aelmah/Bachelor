public class Comlpex {
    private double reelle;
    private double imaginaire;

    public Comlpex() {
        this.reelle = 0;
        this.imaginaire = 0;
    }

    public Comlpex(double reelle, double imaginaire) {
        this.reelle = reelle;
        this.imaginaire = imaginaire;
    }

    public double getReelle() {
        return reelle;
    }

    public void setReelle(double reelle) {
        this.reelle = reelle;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public void setImaginaire(double imaginaire) {
        this.imaginaire = imaginaire;
    }
    public Comlpex ajouter (Comlpex C ){
         double newreelle = this.reelle+C.getReelle();
         double newimaginaire = this.imaginaire+C.getImaginaire();
         return new Comlpex(newreelle, newimaginaire);

    }
    public Comlpex soustraire (Comlpex C){
        double newreelle = this.reelle-C.getReelle();
        double newimaginaire = this.imaginaire-C.getImaginaire();
        return new Comlpex(newreelle, newimaginaire);

        }
    public Comlpex multiplier (Comlpex C){
        double newreelle = this.reelle*C.getReelle();
        double newimaginaire = this.imaginaire*C.getImaginaire();
        return new Comlpex(newreelle, newimaginaire);
    }

}
