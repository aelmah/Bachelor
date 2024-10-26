<?php

class Salarié implements IEntrepriseRecrutement
{
    private $listeSalaries = [];

    public function chercherSalarieParNum(int $numeroSalarie)
    {
        foreach ($this->listeSalaries as $salarie) {
            if ($salarie['numero'] === $numeroSalarie) {
                return $salarie;
            }
        }

        return null;
    }

    public function chercherTousLesSalariesEntreprise()
    {
        return $this->listeSalaries;
    }

    public function chercherTousLesSalariesEntrepriseParSalaire(float $salaireMin, float $salaireMax)
    {
        $resultats = [];
        foreach ($this->listeSalaries as $salarie) {
            if ($salarie['salaire'] >= $salaireMin && $salarie['salaire'] <= $salaireMax) {
                $resultats[] = $salarie;
            }
        }

        return $resultats;
    }

    public function chercherSalaireDateRecrutementEntre(DateTime $dateRecrutement1, DateTime $dateRecrutement2)
    {
        $resultats = [];
        foreach ($this->listeSalaries as $salarie) {
            $dateRecrutement = new DateTime($salarie['date_recrutement']);
            if ($dateRecrutement >= $dateRecrutement1 && $dateRecrutement <= $dateRecrutement2) {
                $resultats[] = $salarie['salaire'];
            }
        }

        return $resultats;
    }

    public function SalaireTousEmployeesEntrepriseX()
    {
        $totalSalaire = 0;
        foreach ($this->listeSalaries as $salarie) {
            $totalSalaire += $salarie['salaire'];
        }

        return $totalSalaire;
    }

    public function embaucherSalarie(array $nouveauSalarie)
    {
        $this->listeSalaries[] = $nouveauSalarie;
    }
}



