package gestionPFE.livrable;

public class CodeSources implements Livrable {
    private String contenue;
    private String langage;

    public CodeSources(String contenue, String langage) {
        this.contenue = contenue;
        this.langage = langage;
    }

    public String getContenue() {
        return contenue;
    }
    public void setContenue(String contenue) {
        this.contenue = contenue;
    }
    public String getLangage() {
        return langage;
    }
    public void setLangage(String langage) {
        this.langage = langage;
    }

    @Override
    public void print() {
        System.out.println("Code sources :");
        System.out.println("Language : "+this.langage+"\nCode source : "+this.contenue);
    }
}
