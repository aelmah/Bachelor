package ma.projet.bean;
import ma.projet.inter.IPersonne;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Personne implements IPersonne {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private double salaire;
    private Profil profil;
    //Constructeur
    public Personne(int id, String nom, String prenom, Date dateNaissance, double salaire, Profil profil) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.salaire = salaire;
        this.profil = profil;
    }
    //les getters et setters
    public Profil getProfil() {
        return profil;
    }
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    //methode pour afficher les informations d'une personne
    @Override
    public void affiche() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,new Locale("fr"));
        String dateDeNaissance = dateFormat.format(getDateNaissance());
        System.out.println("Je suis le "+profil.getLibelle()+" "+nom.toUpperCase()
                +" " +prenom+" né le "+dateDeNaissance+" mon salaire est "+salaire+" DH");
    }
    //methode pour calculer le salaire
    @Override
    public double calculSalaire() {
        if (this.profil.getLibelle().equals("directeur")){
            return salaire*1.2;
        }else if (this.profil.getLibelle().equals("employé")){
            return salaire*1.1;
        }else {
            return salaire;
        }
    }
}