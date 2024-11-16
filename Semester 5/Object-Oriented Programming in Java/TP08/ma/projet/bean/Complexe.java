package ma.projet.bean;

import ma.projet.inter.IOperation;
import ma.projet.abstraite.Affichage;

public class Complexe extends Affichage implements IOperation {
    private double imaginaire;
    private double reel;
    //Constructeur
    public Complexe(double imaginaire, double reel) {
        this.imaginaire = imaginaire;
        this.reel = reel;
    }
    //les getters et setters
    public double getImaginaire() {
        return imaginaire;
    }
    public void setImaginaire(double imaginaire) {
        this.imaginaire = imaginaire;
    }
    public double getReel() {
        return reel;
    }
    public void setReel(double reel) {
        this.reel = reel;
    }
    //methode d'addition de deux objets (dans ce cas deux nombres complexes)
    @Override
    public Object plus(Object object) {
        if (object instanceof Complexe){
            Complexe c = (Complexe) object;
            return new Complexe(this.imaginaire+c.imaginaire,this.reel+c.reel);
        }
        return null;
    }
    //methode de soustraction de deux objets (dans ce cas deux nombres complexes)
    @Override
    public Object moins(Object object) {
        return new Complexe(this.imaginaire-((Complexe)object).getImaginaire(),
                this.reel-((Complexe)object).getReel());
    }
    //methode pour afficher un nombre complexe
    @Override
    public String affiche() {
        if (this.imaginaire > 0){
            return "(" + this.reel + " + " + this.imaginaire + "i)";
        }else if (this.imaginaire < 0){
            return "(" + this.reel + " " + this.imaginaire + "i)";
        }else return "(" + this.reel + ")";
    }
}