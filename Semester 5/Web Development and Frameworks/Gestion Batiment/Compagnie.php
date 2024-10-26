<?php

class Compagnie
{
    private $refCompagnie;
    private $siege;
    private $nomEmployes;  // Supposons que nomEmployes soit un tableau d'employés

    public function __construct($refCompagnie, $siege)
    {
        $this->refCompagnie = $refCompagnie;
        $this->siege = $siege;
        $this->nomEmployes = array();  // Initialisation du tableau des employés
    }

    /**
     * Méthode de recrutement d'un nouvel employé
     * @param string $nom
     * @param string $poste
     */
    public function recrutement($nom, $poste)
    {

        $nouvelEmploye = new Employe($nom, $poste);
        $this->nomEmployes[] = $nouvelEmploye;

        echo "Nouvel employé recruté : $nom, Poste : $poste";
    }

    /**
     * Méthode pour faire signer un contrat à un employé
     * @param string $nom
     */
    public function signeContrat($nom)
    {

        foreach ($this->nomEmployes as $employe) {
            if ($employe->getNom() === $nom) {
                $employe->signerContrat();
                echo "$nom a signé son contrat.";
                return;
            }
        }

        echo "Employé non trouvé : $nom";
    }

    /**
     * Méthode pour mettre fin au contrat d'un employé
     * @param string $nom
     */
    public function mettreFinContrat($nom)
    {

        foreach ($this->nomEmployes as $key => $employe) {
            if ($employe->getNom() === $nom) {
                unset($this->nomEmployes[$key]);
                echo "$nom n'est plus un employé de la compagnie.";
                return;
            }
        }

        echo "Employé non trouvé : $nom";
    }
}

class Employe
{
    private $nom;
    private $poste;

    public function __construct($nom, $poste)
    {
        $this->nom = $nom;
        $this->poste = $poste;
    }

    public function getNom()
    {
        return $this->nom;
    }

    public function signerContrat()
    {

        echo "Contrat signé par $this->nom.";
    }
}