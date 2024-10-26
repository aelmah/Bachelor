<?php

class EntrepriseX
{

    public function SalaireTousEmployeesEntrepriseX()
    {
        $totalSalaire = 0;

        foreach ($this->employes as $employe) {
            $totalSalaire += $employe->getSalaire();
        }

        return $totalSalaire;
    }


}