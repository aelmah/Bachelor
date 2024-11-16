package gestionPFE.individu;


public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    public Personne(String nom, String prenom, String email, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean equals(Object object,Object object2){
        if (object.getClass()==object2.getClass()){
            Personne personne1 = (Personne) object;
            Personne personne2 = (Personne) object2;
            return personne1.nom.equals(personne2.nom) && personne1.prenom.equals(personne2.prenom)
                    && personne1.tel.equals(personne2.tel) && personne1.email.equals(personne2.email);
        }
        return false;
    }

}
