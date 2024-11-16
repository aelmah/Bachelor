package gestionPFE.individu;

import gestionPFE.livrable.Pfe;

import java.util.ArrayList;

public class Etudiant extends Personne {
    private String CNE;
    private String filiere;
    private ArrayList<Pfe> pfes = new ArrayList<>();

    public Etudiant(String nom, String prenom, String email, String tel, String CNE, String filiere) {
        super(nom, prenom, email, tel);
        this.CNE = CNE;
        this.filiere = filiere;
    }

    public String getCNE() {
        return CNE;
    }
    public void setCNE(String CNE) {
        this.CNE = CNE;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public void ajouterPfe(Pfe pfe){
        this.pfes.add(pfe);
    }
    @Override
    public String toString() {
        return "Etudiant : \n"+"CNE : "+CNE+"\t|Filiere : "+filiere+"\t|Nom : "+getNom()+
                "\t|Prénom : "+getPrenom()+"\t|Tél : "+getTel()+"\t|email : "+getEmail();
    }
}
