<?php

class OffreEmploi
{
    private $id;
    private $titre;
    private $description;
    private $dateLimite;
    private $ref;

    public function __construct($id, $titre, $description, $ref, $dateLimite){
        $this->id= $id;
        $this->titre= $titre;
        $this->description= $description;
        $this->dateLimite = $dateLimite;
        $this->ref=$ref;

    }
}