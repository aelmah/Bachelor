<?php

class UtilisateurDAO
{
    public $utilisateurs = array();
    public function ajouterUtilisateur(Utilisateur $utilisateur){
        $this->utilisateurs[] = $utilisateur;

    }
    public function récupérerUtilisateur(){
        return $this->Utilisateurs;

    }

    public function afficherUtilisateur(){
        foreach ($this->utilisateurs as $utilisateur){
            echo "ID = " .$utilisateur->getId(). "Nom=".$utilisateur->getNom(). "Email= ".$utilisateur->getEmail(). "Pays = ".$utilisateur-> getPays();

        }
    }
}