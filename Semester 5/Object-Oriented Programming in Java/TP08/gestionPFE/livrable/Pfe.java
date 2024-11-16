package gestionPFE.livrable;

import gestionPFE.individu.Etudiant;
import gestionPFE.individu.Jury;
import gestionPFE.individu.Prof;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pfe {
    private Etudiant etudiant;
    private String sujet;
    private LocalDate dateDebut;
    private String entreprise;
    private double moyenne;
    ArrayList<Livrable> livrables ;
    private Prof encadrant;
    private Jury jury;
    public Pfe(Etudiant etudiant,String sujet, LocalDate dateDebut, String entreprise, double moyenne,Prof encadrant,ArrayList<Livrable> livrables) {
        this.etudiant = etudiant;
        this.sujet = sujet;
        this.dateDebut = dateDebut;
        this.entreprise = entreprise;
        this.moyenne = moyenne;
        this.livrables = livrables;
        this.encadrant = encadrant;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public ArrayList<Livrable> getLivrables() {
        return livrables;
    }
    public void setLivrables(ArrayList<Livrable> livrables) {
        this.livrables = livrables;
    }
    public Prof getEncadrant() {
        return encadrant;
    }
    public void setEncadrant(Prof encadrant) {
        this.encadrant = encadrant;
    }
    public String getSujet() {
        return sujet;
    }
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
    public double getMoyenne() {
        return moyenne;
    }
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
    public Jury getJury() {
        return jury;
    }

    public void printAllLivrables(){
        for (Livrable livrable : livrables){
            System.out.println();
            livrable.print();
        }
    }
    public void affecterJury(Jury jury){
        this.jury = jury;
    }

    @Override
    public String toString() {
        return "Réaliser par : "+etudiant.getNom()+ "\nDate début : " + dateDebut +
                "\nSujet : " + sujet + "\nEntreprise : " + entreprise +
                "\nMoyenne : " + moyenne + "\nEncadrant : " + encadrant.getNom();
    }
}
