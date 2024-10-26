<?php

class ApplicationController
{
    private $UtilisateurDAO;
    private $EmployeurDAO;
    private $OffreEmploiDAO;


    public function __construct($EmployeurDAO, $UtilisateurDAO, $OffreEmploiDAO)
    {

        $this->EmployeurDAO = $EmployeurDAO;
        $this->UtilisateurDAO = $UtilisateurDAO;
        $this->OffreEmploiDAO = $OffreEmploiDAO;
    }

    // méthode pour traiter la soumission d'un formulaire d'inscription Utilisateur

    public function traiterInscriptionUtilisateur($id, $nom, $email, $pays)
    {
        $nouvelUtilisateur = new Utilisateur(1, "amal", "amal@gmail.com", "Maroc");
        $this->utilisateurDAO->ajouterUtilisateur($nouvelUtilisateur);
    }

    // methode pour traiter la soumission d'un formulaire d'inscription Employeur

    public function traiterInscriptionEmployeur($id, $nom, $email, $pays, $experience, $niveauEtude)
    {
        $nouvelEmployeur = new Employeur("Bac+5", "2ans");
        $this->EmployeurDAO->ajouterEmployeur($nouvelEmployeur);
    }

    // methode pour traiter la soumission d'un formulaire de création d'une Offre d'emploi
    public function TraiterCreationOffreEmploi($id, $titre, $description, $dateLimite)
    {
        $nouvelOffreEmploi = new OffreEmploi(1, "Titre1", "description1", "1", "1-1-2024");
        $this->OffreEmploiDAO->ajouterOffreEmploi($nouvelOffreEmploi);
    }

    // Méthode pour traiter la soumission d'un formulaire de candidature
    public function traiterCandidature($idUtilisateur, $idOffreEmploi, $lettreMotivation)
    {
        // on va récupérer  l'utilisateur et l'offre d'emploi correspondants
        $utilisateur = $this->utilisateurDAO->recupererUtilisateurParId($idUtilisateur);
        $offreEmploi = $this->offreEmploiDAO->recupererOffreEmploiParId($idOffreEmploi);

        // Vérifions  si l'utilisateur et l'offre d'emploi existent
        if ($utilisateur && $offreEmploi) {

            // on va créer une instance de Candidature et l'ajouter à l'offre d'emploi
            $candidature = new Candidature(2, "salimi","salimi@gmail.com", " Al Maghreb");
            $offreEmploi->ajouterCandidature($candidature);
        } else {
            // on va afficher un message d'erreur si l'offre ou l'utilisateur makayninch
            echo "Erreur: Utilisateur ou offre d'emploi introuvable.";
        }

    }
    // récupérer toutes les candidatures pour une offre d'emploi donnée
    public function recupererCandidaturesPourOffreEmploi($idOffreEmploi) {
        $offreEmploi = $this->offreEmploiDAO->recupererOffreEmploiParId($idOffreEmploi);
        if ($offreEmploi) {
            return $offreEmploi->getCandidatures();
        } else {
            // Si le tableau est vide
            return array();
        }
    }


    //  afficher toutes les candidatures pour une offre d'emploi donnée
    public function afficherCandidaturesPourOffreEmploi($idOffreEmploi) {
        $candidatures = $this->recupererCandidaturesPourOffreEmploi($idOffreEmploi);
        foreach ($candidatures as $candidature) {
            echo "Utilisateur: " . $candidature->getUtilisateur()->nom . " Lettre de Motivation: " . $candidature->getLettreMotivation();
        }
    }
}