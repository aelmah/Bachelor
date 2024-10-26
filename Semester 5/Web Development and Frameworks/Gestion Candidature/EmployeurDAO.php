<?php

class EmployeurDAO
{
    public $Employees = array();

    public function ajouterEmployeur( Employeur $employeur){
        $this->Employees[]= $employeur;

    }
    public function récupérerUtlisateur(){
        return $this->Employees;
    }
    public function afficherUtilisateur(){
     foreach ($this->Employees as $employeur){
         echo "Niveau d'étude = ".$employeur->getNiveauetude(). "années d'expérience " .$employeur->getExperience();
     }
    }

}