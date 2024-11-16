package gestionPFE.individu;

import gestionPFE.livrable.Pfe;
import java.util.ArrayList;

public class Prof extends Personne {
    private String CIN;
    private String grade;
    private ArrayList<Pfe> pfes = new ArrayList<>();
    public Prof(String nom, String prenom, String email, String tel, String CIN, String grade) {
        super(nom, prenom, email, tel);
        this.CIN = CIN;
        this.grade = grade;
    }

    public String getCIN() {
        return CIN;
    }
    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void ajouterPfe(Pfe pfe){
        this.pfes.add(pfe);
    }
    @Override
    public String toString() {
        return "Grade : "+grade+"\t|CIN : "+CIN+"\t|Nom : "+getNom()+
                "\t|Prénom : "+getPrenom()+"\t|Tél : "+getTel()+"\t|email : "+getEmail();
    }

}