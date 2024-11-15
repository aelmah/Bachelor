 public class Etudiant {
    // Declaration des attributs de la classe
     private String nom, prenom, cin;
     private int age;

     // Méthode pour afficher les informations de l'étudiante
     public void afficheEtudiant() {

         System.out.println(" les information de l'etudiant sont :");
         System.out.println(" le nom :" + this.nom);
         System.out.println(" le prenom  :" + this.prenom);
         System.out.println(" CIN :" + this.cin);
         System.out.println("l'age est "+ this.age);
     }
      // Méthode pour augmenter l'âge de l'étudiant de 'a' années
      public void incrimentAge ( int a){

     this.age=age+a;
     String cin = this.cin;
     String nom = this.nom;
     String prenom = this.prenom;

}
    // Constructeur de la classe
    public Etudiant(String nom, String prenom, String cin, int age) {
         this.nom = nom;
         this.prenom = prenom;
         this.cin = cin;
         this.age = age;


     }
    // Méthodes getters pour accéder aux attributs
     public String getNom() {

         return nom;
     }

     public String getPrenom() {
         return prenom;
     }

     public String getCin() {
         return cin;
     }

     public int getAge() {
         return age;
     }

     // Méthodes setters pour modifier les attributs
     public void setNom(String nom) {
         this.nom = nom;
     }

     public void setPrenom(String prenom) {
         this.prenom = prenom;
     }

     public void setCin(String cin) {
         this.cin = cin;
     }

     public void setAge(int age) {
         this.age = age;
     }
 }
