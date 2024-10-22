
--serie_7
--Exercice 1 : 

--Question_1
set SERVEROUTPUT on;
create or replace trigger interdit_mAj_Emp
BEFORE UPDATE ON emp
for each row 
DECLARE
    day_of_week NUMBER;
     MESSAGE EXCEPTION;
BEGIN
day_of_week := TO_NUMBER(TO_CHAR(SYSDATE, 'D'));
IF day_of_week IN (1,7) THEN
     RAISE MESSAGE;
    END IF;
    EXCEPTION 
    WHEN MESSAGE THEN
          RAISE_APPLICATION_ERROR(-20324, 'on ne met pas a jour la fin de semaine');
END;
/
update  emp  set  sal=5600 where empno=7839;
select * from emp;
select * from ALL_TRIGGERS;
drop TRIGGER MAJ_NB_EMP;
--Question_2
CREATE OR REPLACE TRIGGER update_avg_salaire
after update ON emp
for each row
DECLARE new_avg_salary FLOAT;
BEGIN
    SELECT avg(sal) into  new_avg_salary from emp; 
    DBMS_OUTPUT.PUT_LINE('NEW moyenne de SALAIRE : ' || new_avg_salary); 
END;
--Question_3
alter table dept add  nbr_emp int default ;
ALTER TABLE emp
DROP COLUMN nbr_emp;
CREATE or replace TRIGGER maj_nb_emp
BEFORE INSERT OR DELETE OR UPDATE OF num_dept ON EMPLOYEE
FOR EACH ROW
BEGIN
    IF inserting THEN
        UPDATE dept SET nbr_emp = nbr_emp + 1
        WHERE num_dept = :NEW.num_dept;
    ELSIF deleting THEN
        UPDATE dept SET nbr_emp = nbr_emp - 1 
        WHERE num_dept = :OLD.num_dept;
    ELSIF updating THEN
            UPDATE dept SET nbr_emp = nbr_emp + 1 
            WHERE num_dept = :NEW.num_dept;     
    END IF;
END;
update  emp set  NUM_DEPT=3 where num_emp=9;
insert  into   emp values(15,'salim',2900017,10);
select * from dept;

--Question_4
create or replace trigger N_Salaire 
BEFORE  UPDATE of sal on emp
FOR EACH ROW
Declare 
   salairee float;
BEGIN
select sal into salairee from emp where num_dept= :New.num_dept;
    if salairee > :New.sal then
        raise_application_error(-20001, 'Le nouveau salaire doit �tre sup�rieur � l ancien.');
    END IF;
END;
--METHODE2+++++++++++++++++++
create or replace trigger N_Salaire 
BEFORE  UPDATE of sal on emp
FOR EACH ROW
Declare 
   salairee float;
BEGIN
    if :OLD.sal > :New.salaire then
        raise_application_error(-20001, 'Le nouveau salaire doit �tre sup�rieur � l ancien.');
    END IF;
END;

--Question_5
create or replace trigger CONTROLE_sal 
BEFORE insert or  UPDATE of sal on emp
FOR EACH ROW
Declare 
   Mnsalaire float;
   Mxsalaire float;
BEGIN
select Min(sal) , Max(sal) into Mnsalaire , Mxsalaire from emp ;
    if :New.sal < Mnsalaire or :New.sal > Mxsalaire then
        RAISE_APPLICATION_ERROR(-20001, 'Le salaire doit �tre compris entre ' || Mnsalaire || ' et ' || Mxsalaire);
     END IF;
END;

--Question_6
ALTER TABLE EMPLOYEE add manageer INT DEFAULT 0 not null ;
CREATE OR REPLACE TRIGGER verif_salaire_sup_hierarchique
BEFORE INSERT  ON Employee
FOR EACH ROW
DECLARE
    NSalaire int;
BEGIN
    SELECT salaire INTO NSalaire
    FROM employee where num_emp=:New.manageer;
    -- V�rifier la contrainte
    IF :NEW.salaire > NSalaire THEN
        RAISE_APPLICATION_ERROR(-20001, 'Le salaire doit �tre inf�rieur � celui du sup�rieur hi�rarchique.');
    END IF;
END;
--Exercice 2 : 
--Question_1
-- Table Immeuble
CREATE TABLE Immeuble (
    id INT PRIMARY KEY,
    adrNum VARCHAR(20),
    adrRue VARCHAR(20),
    ville VARCHAR(20),
    parking VARCHAR(20)
);

-- Table Appartement
CREATE TABLE Appartement (
    numA INT PRIMARY KEY,
    immeuble_id INT,
    superficie FLOAT,
    loyer FLOAT,
    placeParking INT,
    prixParking FLOAT,
    constraint fk_IDimmeuble FOREIGN KEY (immeuble_id) REFERENCES Immeuble(id)
);

-- Table Piece
CREATE TABLE Piece (
    numP INT PRIMARY KEY,
    immeuble_id INT,
    appartement_numA INT,
    superficie FLOAT,
    fonction VARCHAR(20),
    constraint fk_immeuble FOREIGN KEY (immeuble_id) REFERENCES Immeuble(id),
    constraint fk_app FOREIGN KEY (appartement_numA) REFERENCES Appartement(numA)
);
--Question_2
CREATE OR REPLACE TRIGGER verif_prix_parking
BEFORE INSERT ON Appartement
FOR EACH ROW
BEGIN
   IF :NEW.placeParking IS NULL AND :NEW.prixParking IS NOT NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Le prix de la place de parking doit �tre nul si l''appartement ne poss�de pas de place de parking.');
    END IF;
END;
CREATE OR REPLACE TRIGGER check_prix_parking
BEFORE INSERT OR UPDATE ON appartement
FOR EACH ROW
BEGIN
  IF :NEW.placeParking = 0 THEN
    :NEW.prixParking := 0;
  END IF;
END;
--Question_3
CREATE OR REPLACE TRIGGER maj_superficie_appartement
BEFORE INSERT ON piece 
FOR EACH ROW 
BEGIN 
  UPDATE appartement 
  SET superficie = NVL(superficie, 0) + :NEW.superficie 
  WHERE immeuble_id = :NEW.immeuble_id AND numA = :NEW.appartement_numA; 
END;
--Exercice 3 : 
--Question_1
CREATE OR REPLACE TRIGGER quest_1
AFTER INSERT OR UPDATE ON Travaille FOR EACH ROW
DECLARE
    DEP1 NUMBER;
    DEP2 NUMBER;
BEGIN
    SELECT N_Dep INTO DEP1 FROM Projet WHERE N_Proj=:NEW.N_Proj;
    SELECT N_Dep INTO DEP2 FROM Employe WHERE Matricule=:NEW.Matricule;
    IF DEP1 !=DEP2 THEN
        RAISE_APPLICATION_ERROR(-20005,'un employé ne peut pas travailler sur un projet qui n’appartient pas à son département');
    END IF;
END;
--Question_2
CREATE OR REPLACE TRIGGER Suivi_changements_salaire
AFTER UPDATE ON EMPLOYE FOR EACH ROW
BEGIN
    IF ((:NEW.Salaire/:OLD.Salaire) >= 1.2) OR ((:OLD.Salaire/:NEW.Salaire) >= 1.2) THEN
        RAISE_APPLICATION_ERROR(-20002, 'le salaire d’un employé ne peut pas être modifié de plus de 20% du salaire initial');
    END IF;
END;
--Question_3
CREATE OR REPLACE TRIGGER quest_3
BEFORE UPDATE of NomD OR DELETE ON Departement
BEGIN
    RAISE_APPLICATION_ERROR (-20501, 'Une fois qu’un département est créé, nous ne pouvons pas changer son nom ou le supprimer');
END;
--Question_4
CREATE OR REPLACE TRIGGER quest_4
AFTER INSERT OR UPDATE ON Travaille FOR EACH ROW
DECLARE
    SOMME NUMBER;
BEGIN
    SELECT SUM(Heures) INTO SOMME FROM Travaille WHERE Matricule=:NEW.Matricule;
    IF SOMME > 200 THEN
        RAISE_APPLICATION_ERROR(-20005,'Un employé ne peut pas travailler plus de 200 heures.');
    END IF;
END;

--Exercice 4 : 
--Question_1
CREATE OR REPLACE TRIGGER quest_1
AFTER INSERT ON Inscription FOR EACH ROW
DECLARE
    NB NUMBER;
BEGIN
    SELECT COUNT(*) INTO NB FROM Inscription WHERE cnom=:NEW.cnom;
    IF NB>30 THEN
        RAISE_APPLICATION_ERROR(-20005,'Cours a un effectif maximum de 30 etudiants');
    END IF;
END;
--Question_2
CREATE OR REPLACE TRIGGER quest_2
AFTER INSERT OR UPDATE ON Cours FOR EACH ROW
DECLARE
    NB NUMBER;
    DEP NUMBER;
BEGIN
    SELECT depid INTO DEP FROM Professeur WHERE pid=:NEW.pid;
    SELECT COUNT(*) INTO NB FROM Cours WHERE pid=:NEW.pid;
    IF DEP!=33 AND NB>3 THEN
        RAISE_APPLICATION_ERROR(-20005,'Seuls les enseignants du département avec depid = 33 enseignent plus de trois cours');
    END IF;
END;
--Question_3
CREATE OR REPLACE TRIGGER quest_3
AFTER INSERT ON Etudiant FOR EACH ROW
BEGIN
    INSERT INTO Inscription VALUES(:NEW.eid,'Informatique théorique');
END;
--Question_4
CREATE OR REPLACE TRIGGER quest_4
AFTER INSERT OR UPDATE ON Professeur FOR EACH ROW
DECLARE
    NB NUMBER;
BEGIN
    SELECT COUNT(*) INTO NB FROM Professeur WHERE depid=:NEW.depid;
    IF NB>10 THEN
        RAISE_APPLICATION_ERROR(-20005,'Aucun département ne peut avoir plus de 10 enseignants.');
    END IF;
END;
--Question_5
CREATE OR REPLACE TRIGGER quest_5
AFTER INSERT OR UPDATE ON Etudiant FOR EACH ROW
WHEN NEW.niveau='Base de données' OR NEW.niveau='Mathématiques'
DECLARE
    NB1 NUMBER;
    NB2 NUMBER;
BEGIN
    SELECT COUNT(*) INTO NB1 FROM Etudiant WHERE niveau='Base de données';
    SELECT COUNT(*) INTO NB2 FROM Etudiant WHERE niveau='Mathématiques';
    IF NB2<NB1 THEN
        RAISE_APPLICATION_ERROR(-20005,'Le nombre d eleves inscrits dans la section base de donnees doit être superieur au nombre d eleves
dans la section Mathematiques.');
    END IF;
END;
--Question_6
CREATE OR REPLACE TRIGGER quest_6
AFTER INSERT OR UPDATE ON Etudiant FOR EACH ROW
WHEN NEW.niveau='Mathématiques'
DECLARE
    NB1 NUMBER;
    NB1 NUMBER;
BEGIN
    SELECT COUNT(*) INTO NB1 FROM Etudiant WHERE niveau='Mathématiques';
    SELECT COUNT(*) INTO NB2 FROM Professeur P INNER JOIN Cours C ON P.pid=C.pid INNER JOIN Inscription I ON I.cnom=C.cnom WHERE P.depid=33;
    IF NB1>NB2 THEN
        RAISE_APPLICATION_ERROR(-20005,'Nombre d inscription dans math depasse depid=33 ');
    END IF;
END;
--Question_7
CREATE OR REPLACE TRIGGER quest_7
BEFORE INSERT OR UPDATE ON Cours FOR EACH ROW
WHEN NEW.pid>0
DECLARE
    DEP1 NUMBER;
    NB NUMBER;
BEGIN
    SELECT depid INTO DEP1 FROM Professeur WHERE pid=:NEW.pid;
    SELECT count(*) INTO NB FROM Cours C INNER JOIN Professeur P ON C.pid=P.pid WHERE C.salle=:NEW.salle AND P.depid!=DEP1;
    IF NB1>NB2 THEN
        RAISE_APPLICATION_ERROR(-20005,'Deux Courss ne peuvent pas se réunir dans la même salle en même temps.');
    END IF;
END;

--Exercice 5 : 
--Question_1
CREATE OR REPLACE TRIGGER quest_1
BEFORE INSERT OR UPDATE ON Employe FOR EACH ROW
BEGIN
    IF :NEW.salaire < 1000 THEN
        RAISE_APPLICATION_ERROR(-20005,'Les employés doivent gagner un salaire minimum de 1000$.');
    END IF;
END;
--Question_2
CREATE OR REPLACE TRIGGER quest_2
AFTER INSERT OR UPDATE ON Travail FOR EACH ROW
DECLARE
    pct NUMBER;
BEGIN
    SELECT SUM(pct_temps) INTO pct FROM Travail WHERE eid=:NEW.eid;
    IF pct >=100 THEN
        RAISE_APPLICATION_ERROR(-20005,'Le pourcentage total du temp de travail pour un employé doit être inférieur à 100');
    END IF;
END;
--Question_3
CREATE OR REPLACE TRIGGER quest_3
AFTER INSERT OR UPDATE ON Travail FOR EACH ROW
DECLARE
    SAL REAL;
BEGIN
    SELECT E.salaire INTO SAL FROM Departement D INNER JOIN EMPLOYE E ON E.eid=D.responsable_id WHERE D.depid=:NEW.depid; 
    IF :NEW.salaire > SAL THEN
        RAISE_APPLICATION_ERROR(-20005,'Un responsable doit toujours avoir un salaire plus élevé');
    END IF;
END;
--Question_4
CREATE OR REPLACE TRIGGER quest_4
AFTER UPDATE ON EMPLOYE FOR EACH ROW
WHEN NEW.salaire>OLD.salaire
DECLARE
    DEP NUMBER;
    RESP NUMBER;
    DIFF REAL;
BEGIN
    DIFF:=:NEW.salaire-:OLD.salaire;
    SELECT T.depid INTO DEP FROM Travail T INNER JOIN Employe E ON E.eid=T.eid WHERE E.eid=:NEW.eid;
    SELECT responsable_id INTO RESP FROM Departement WHERE depid=DEP;
    UPDATE Employe SET salaire=salaire+DIFF WHERE eid = RESP;
END;
--Question_5
CREATE OR REPLACE TRIGGER quest_5
AFTER UPDATE ON EMPLOYE FOR EACH ROW
FOLLOWS quest_4
WHEN NEW.salaire>OLD.salaire
 
DECLARE
    DEP NUMBER;
    BUDG REAL;
    DIFF REAL;
    SOMME REAL;
BEGIN
    DIFF:=:NEW.salaire-:OLD.salaire;
    SELECT T.depid INTO DEP FROM Travail T INNER JOIN Employe E ON E.eid=T.eid WHERE E.eid=:NEW.eid;
    SELECT budget INTO BUDG FROM Departement WHERE depid=DEP;
    SELECT SUM(E.salaire) INTO SOMME FROM Travail T INNER JOIN Employe E ON E.eid=T.eid WHERE T.depid=DEP; 
    IF SOMME>BUDG THEN
        UPDATE Employe SET salaire=salaire+(SOMME-BUDG) WHERE eid = RESP;
    END IF;
END;


