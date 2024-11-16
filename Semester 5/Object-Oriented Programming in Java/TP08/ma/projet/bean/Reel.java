package ma.projet.bean;

import ma.projet.abstraite.Affichage;
import ma.projet.inter.IOperation;

public class Reel extends Affichage implements IOperation {
    private double x;
    //Constructeur
    public Reel(double x) {
        this.x = x;
    }
    //les getters et setters
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    //methode d'addition de deux objets (dans ce cas deux nombres reels)
    @Override
    public Object plus(Object object) {
        Reel reel = (Reel) object;
        return new Reel(this.x+ reel.getX());
    }
    //methode de soustraction de deux objets (dans ce cas deux nombres reels)
    @Override
    public Object moins(Object object) {
        Reel reel = (Reel) object;
        return new Reel(this.x-reel.getX());
    }
    //methode pour afficher un nombre reel
    @Override
    public String affiche() {
        return "("+this.x+")";
    }
}