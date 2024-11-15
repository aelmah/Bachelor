public class Compte {
    private final int numero;
    private double solde;
    public double getSolde() {
        return this.solde;
    }
    public int getNumero() {
        return numero;
    }
    public Compte(int numero,double solde) {
        this.numero = numero;
        this.solde = solde;
    }
    // methode du depot d'un montant avec exceptions des errors
    public void depot(double montant) throws Exception{
        if (montant > 0) {
            this.solde += montant;
            afficheSolde();
        }
        else { // cas du montant negative
            throw new Exception("Montant invalide.");
        }
    }
    // methode du retrait d'un montant avec exceptions des errors
    public void retrait(double montant) throws Exception{
        if (montant > 0){
            if (this.solde >= montant) {
                this.solde -= montant;
                afficheSolde();
            }
            else { // cas du solde inférieur au montant
                throw new Exception("Solde insuffisant.");
            }
        }
        else { // cas d'un montant negative
            throw new Exception("Montant invalide");
        }
    }
    // methode d'affichage du solde
    public void afficheSolde() {
        System.out.println("Le solde de compte n°"+getNumero()+" est : "+this.solde+" DH");
    }
    // methode de virement
    public void virer(double montant,Compte destinataire) throws Exception{
        if (this.solde >= montant) {
            this.retrait(montant);
            destinataire.depot(montant);
        }
        else { // cas du solde inférieur au montant
            throw new Exception("Solde insuffisant.");
        }
    }
}