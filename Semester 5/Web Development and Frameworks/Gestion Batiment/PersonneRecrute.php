<?php


class PersonneRecrute extends Personne
{
public $listeDesPersonnesRecrutees = array();
    public function chercherPersonneRecrute(PersonneRecrute $personneRecrute)
    {

        if ($this->NomPersonne === $personneRecrute->NomPersonne) {
            return $personneRecrute;
        } else {
            return null;
        }
    }

    public function chercherPersonneRecruteparcin(int $numeroCarteNationale)
    {

        if ($this->NumeroCarteNationale === $numeroCarteNationale) {
            return $this;
        } else {
            return null;
        }
    }

    public function enregistrerNouveauRecrute(PersonneRecrute $personneRecrute, EntrepriseX $entreprise)
    {

        $entreprise->recrutement($personneRecrute);
        echo "Nouveau recruté enregistré : {$personneRecrute->NomPersonne} chez {$entreprise->NomEntreprise}.";
    }

    public function chercherPersonneRecrutepardaterecrutement(DateTime $dateRecrutement)
    {

        if ($this->DateRecrutement == $dateRecrutement) {
            return $this;
        } else {
            return null;
        }
    }

    public function chercherListePersonneRecrutes()
    {

        return $listeDesPersonneRecrutees;
    }

    public function TotalTousPersonneRecrutesEntreDeuxDate($date1, $date2)
    {

        $total = 0;
        foreach ($listeDesPersonnesRecrutees as $personneRecrutee) {
            if ($personneRecrutee->DateRecrutement >= $date1 && $personneRecrutee->DateRecrutement <= $date2) {
                $total++;
            }
        }
        return $total;
    }

    public function MettreFinAuContrat(Personne $personne)
    {

        $personne->mettreFinContrat();
        echo "Contrat terminé pour {$personne->NomPersonne}.";
    }

    public function MettreFinAuContratApresuneperiodeEssai()
    {

        $this->mettreFinContrat();
        echo "Contrat terminé après la période d'essai pour {$this->NomPersonne}.";
    }
}





