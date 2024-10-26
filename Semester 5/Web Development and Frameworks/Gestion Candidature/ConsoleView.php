<?php
class ConsoleView
{
    // afficher un menu
    public function afficherMenuPrincipal()
    {
        echo "1. Afficher les offres d'emploi";
        echo "2. Afficher les utilisateurs";
        echo "0. Quitter";
    }

    //  afficher les détails d'une offre d'emploi
    public function afficherDetailsOffreEmploi(OffreEmploi $offreEmploi)
    {
        echo "Titre: " . $offreEmploi->getTitre();
        echo "Description: " . $offreEmploi->getDescription();
        echo "Date Limite: " . $offreEmploi->getDateLimite();
        echo "Nom de l'Employeur: " . $offreEmploi->employeur->getNom();
    }

    // afficher les informations d'un utilisateur
    public function afficherDetailsUtilisateur(Utilisateur $utilisateur)
    {
        echo "Nom: " . $utilisateur->getNom();
        echo "Email: " . $utilisateur->getEmail();
        echo "Pays: " . $utilisateur->getPays();

    }
}


