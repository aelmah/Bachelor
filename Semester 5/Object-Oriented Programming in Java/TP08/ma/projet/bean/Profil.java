package ma.projet.bean;

import java.util.ArrayList;

public class Profil {
    private String id;
    private String code;
    private String libelle;
    ArrayList<Personne> personnes = new ArrayList<>();
    //Constructeur
    public Profil(String id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    //les getters et setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
