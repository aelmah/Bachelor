package gestionPFE.livrable;

public class Rapport implements Livrable {
    private int nbPage;
    private String langue;
    private String contenue;
    private String titre;

    public Rapport(int nbPage, String langue, String contenue, String titre) {
        this.nbPage = nbPage;
        this.langue = langue;
        this.contenue = contenue;
        this.titre = titre;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public void print() {
        System.out.println("Rapport :");
        System.out.println("Titre : "+this.titre+"\nContenue : "+this.contenue);
    }
}
