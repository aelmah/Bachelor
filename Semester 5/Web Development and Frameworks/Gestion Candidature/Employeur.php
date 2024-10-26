<?php

class Employeur extends Utilisateur
{
    private $niveauEtude;
    private $experience;

    /**
     * @param $niveauEtude
     * @param $experience
     */
    public function __construct( $niveauEtude, $experience)
    {
        $this->niveauEtude = $niveauEtude;
        $this->experience = $experience;
    }



}