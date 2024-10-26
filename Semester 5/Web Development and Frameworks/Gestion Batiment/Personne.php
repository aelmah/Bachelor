<?php
require_once 'IEntreprisreRecrutement.php';

class Personne implements IEntreprisreRecrutement
{
    public $cinPersonne;
    public $NomPersonne;
    public $AdressPersonne;

    /**
     * @param $cinPersonne
     * @param $NomPersonne
     * @param $AdressPersonne
     */
    public function __construct($cinPersonne, $NomPersonne, $AdressPersonne)
    {
        $this->cinPersonne = $cinPersonne;
        $this->NomPersonne = $NomPersonne;
        $this->AdressPersonne = $AdressPersonne;
    }

    /**
     * @return mixed
     */
    public function getCinPersonne()
    {
        return $this->cinPersonne;
    }

    /**
     * @param mixed $cinPersonne
     */
    public function setCinPersonne($cinPersonne)
    {
        $this->cinPersonne = $cinPersonne;
    }

    /**
     * @return mixed
     */
    public function getNomPersonne()
    {
        return $this->NomPersonne;
    }

    /**
     * @param mixed $NomPersonne
     */
    public function setNomPersonne($NomPersonne)
    {
        $this->NomPersonne = $NomPersonne;
    }

    /**
     * @return mixed
     */
    public function getAdressPersonne()
    {
        return $this->AdressPersonne;
    }

    /**
     * @param mixed $AdressPersonne
     */
    public function setAdressPersonne($AdressPersonne)
    {
        $this->AdressPersonne = $AdressPersonne;
    }

    public function SignerContrat()
    {
        echo "{$this->NomPersonne} a signé le contrat.";
    }

    public function PasserEntretien()
    {
        echo "{$this->NomPersonne} a passé l'entretien.";
    }

    public function publicContrat()
    {
        echo "Le contrat de {$this->NomPersonne} a été publié.";
    }

    public function mettreFinContrat()
    {
        echo "Le contrat de {$this->NomPersonne} a pris fin.";

    }

    public function enregistrerNouveauPersonne(Personne $personne)
    {
        echo "Nouvelle personne enregistrée: {$personne->NomPersonne}.";

    }

    public function chercherPersonne(Personne $personne)
    {
        echo " la personne: {$personne->NomPersonne}.";

    }

    public function chercherPersonneparcin(int $numerocartenationale)
    {
        echo "{$this->NomPersonne}";
    }

    public function chercherPersonneparnom(String $nompersonne)
    {
        return $this->NomPersonne;

    }

    public function ListeDesPersonnesQuiOntPasserEntretien()
    {

    }

    public function ListePersonneQuiReussiPeriodeEssai()
    {


    }

    public function ListePersonnesQuiNonpasReussiPeriodEssai()
    {


    }

}


