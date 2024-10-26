<?php

class Utilisateur
{
    private $id;
    private $nom;
    private $email;
    private $pays;

    public function __construct($id, $nom, $email, $pays){
        $this->id= $id;
        $this->nom= $nom;
        $this->email=$email;
        $this->pays=$pays;
    }

}
