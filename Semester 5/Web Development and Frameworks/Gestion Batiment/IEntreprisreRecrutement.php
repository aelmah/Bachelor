<?php

interface IEntreprisreRecrutement
{
    public function enregistrerNouveauPersonne(Personne  $personne);
    public function enregistrerNouveauRecrute(PersonneRecrute $personnerecrute, EntrepriseX $entreprise);
    public function chercherPersonne(Personne $personne);
    public function chercherPersonneparcin(int $numerocartenationale);
    public function chercherPersonneparnom(String $NomPersonne);
    public function chercherPersonneRecrute(PersonneRecrute $personneRecrute);
    public function chercherPersonneRecruteparcin(int $numerocartenationale);
    public function chercherPersonneRecrutepardaterecrutement(Date $daterecrutement);
    public function cherchersalarieparnum(int $numerosalarie);
    public function cherchertouslessalarieentreprise();
    public function cherchertouslessalariesentrepriseparsalaire(double $salairemin, double $salaireMax);
    public function chercherSalaireDateRecrutementEntre(Date $daterecrutement1, Date $daterecrutement2);
    public function chercherListePersonneRecrutes();
    public function chercherListeContratCDDenoffre();
    public function chercherListeMemberJuryRecrutement();
    public function ListePersonneRecruteCDI();
    public function PersonneRecruteCDD();
    public function ListePersonneRecruteCDD();
    public function TotalePersonneRecrutreEnCDI();
    public function TotalPersonneRecrutreEnCDD();
    public function TotaltousPeronnesRecruteesEnCDDEntreDeuxDate($date1, $date2);
    public function TotalTousPersonneRecruteesEnCDIEntreDeuxDate($date1, $date2);
    public function TotalTousPersonneRecrutesEntreDeuxDate($date1, $date2);
    public function ListeDesPersonnesQuiOntPasserEntretien();
    public function SalaireTousEmployeesEntrepriseX();
    public function ListePersonneQuiReussiPeriodeEssai();
    public function ListePersonnesQuiNonpasReussiPeriodEssai();


}