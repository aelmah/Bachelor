<?php

class PeronneRecruteCDD extends PersonneRecrute

{

        public $Personnes = array ();
        function ListePersonneRecruteCDD()
        {
            return $this->personnesRecruteesCDD;
        }
        function TotalPersonneRecrutreEnCDD()
        {
            return count($this->personnesRecruteesCDD);
        }

        function TotaltousPeronnesRecruteesEnCDDEntreDeuxDate($date1, $date2)
        {
            $filtered = array_filter($this->personnesRecruteesCDD, function ($personne) use ($date1, $date2) {

                return $personne->DateRecrutement >= $date1 && $personne->DateRecrutement <= $date2;
            });

            return count($filtered);
        }


}