class cercle {
    // declaration des attributs de la classe
    private double rayon;
    // Constructeur de la class
    public cercle(double rayon) {
        this.rayon = rayon;
    }
    // Méthode pour calculer la surface du Cercle
    public double calculersurface(){

        return Math.PI*Math.pow(rayon, 2);
    }
    // Méthode pour calculer le perimetre du Cercle
    public double calculerperimetre() {

        return Math.PI * rayon * 2;
    }
    // Méthode getter pour acceder a l'attribut rayon
    public double getRayon() {
        return rayon;
    }

    // Méthode setter pour modifier l'attribut rayon

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }
}
