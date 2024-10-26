<?php
require_once IEntreprisreRecrutement::class;
class PersonneRecruteCDI extends PersonneRecrute
{
    private $personnesRecruteesCDI = [];

    public function ListePersonneRecruteCDI()
    {
        //  la liste des personnes recrutées en CDI
        return $this->personnesRecruteesCDI;
    }

    public function TotalePersonneRecrutreEnCDI()
    {
        //  le total des personnes recrutées en CDI
        return count($this->personnesRecruteesCDI);
    }

    public function TotalTousPersonneRecruteesEnCDIEntreDeuxDate($date1, $date2)
    {
        $filtered = array_filter($this->personnesRecruteesCDI, function ($personne) use ($date1, $date2) {
            return true;
        });


        return count($filtered);
    }

    // Ajoute une personne recrutée en CDI à la liste
    public function recruterEnCDI(PersonneRecrute $personneRecrute)
    {
        $this->personnesRecruteesCDI[] = $personneRecrute;
        echo "{$personneRecrute->NomPersonne} a été recruté en CDI.";
    }
}

