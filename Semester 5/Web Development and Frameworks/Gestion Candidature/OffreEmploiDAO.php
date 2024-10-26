<?php

class OffreEmploiDAO
{
    public $Offres = array();
    public function ajouterOffre(Offre $offre){
        $this->Offres[] = $offre;

    }
    public function récupérerOfrre()
    {
        return $this->Offres;

    }
    public function afficherOffre(){
        foreach ($this->Offres as $offre){
            echo "ID = ".$offre->getId(). "Titre = ".$offre->getTitre(). "Description= "
                .$offre->getDescription(). "Référence = ".$offre->getRef(). "Date Limite = "
                .$offre->getDatelimite();
        }
    }
}