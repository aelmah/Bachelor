--Exercice 1 
DECLARE
     CURSOR noms_operations IS SELECT nom_operation FROM Budget WHERE nom_operation IN ('Divers','Cadeau');
     CURSOR liste_operations IS SELECT * FROM Budget WHERE date_operation BETWEEN '25/11/01' AND '30/11/01' ORDER BY date_operation DESC; 
BEGIN
   FOR enr1 IN noms_operations LOOP
        DBMS_OUTPUT.PUT_LINE('Le nom  de est  ' || enr1.nom_operation);  
   END LOOP;
   FOR enr2 IN liste_operations LOOP
        DBMS_OUTPUT.PUT_LINE(enr2.num_operation||'  ' || enr2.date_operation);  
   END LOOP;
END;
/
--Exercice 2 
DROP TABLE Courses;
CREATE TABLE Courses  ( num_operation   NUMBER (4,2) PRIMARY KEY,
     type_operation CHAR (15),
     categorie      CHAR (10),
     date_operation DATE,
     montant   NUMBER (6, 2)) ;
DECLARE
    bud budget%ROWTYPE;
    CURSOR cur IS SELECT * FROM BUDGET WHERE nom_operation='Courses';
BEGIN
    OPEN cur;
    LOOP
        FETCH cur INTO bud;
        EXIT WHEN cur%NOTFOUND;
        INSERT INTO COURSES VALUES(bud.num_operation, bud.nom_operation, bud.categorie, bud.date_operation, bud.montant);
    END LOOP;
    CLOSE cur;
END;
/
SELECT * FROM Courses;
--Exercice 3 
DECLARE
     Num_op    Budget.Num_operation%TYPE;
     Montant_op     Budget.Montant%TYPE;
    Erreur_Remb     EXCEPTION ;
    CURSOR Curseur_3 IS SELECT Num_operation, Montant FROM Budget WHERE nom_Operation = 'virement';
BEGIN
     OPEN Curseur_3;
LOOP
     FETCH Curseur_3 INTO Num_op, Montant_op;
         IF Montant_op>2000 THEN
               RAISE Erreur_Remb ;
          END IF ;
          EXIT WHEN Curseur_3%NOTFOUND ;
      END LOOP ;
      CLOSE Curseur_3;
EXCEPTION
     WHEN Erreur_Remb THEN
     DELETE FROM Budget WHERE Num_operation = Num_op ; 
END;
/
SELECT * FROM Budget;
--Exercice 4 
DECLARE
    CURSOR liste_soldes IS SELECT solde FROM BUDGET WHERE solde IS NOT NULL;
    lsolde liste_soldes%ROWTYPE;
    courant NUMBER;
    suivant NUMBER;
    resultat NUMBER DEFAULT 0;
    nc NUMBER;
    Erreur EXCEPTION ;
BEGIN
   SELECT COUNT(*)INTO  nc FROM  BUDGET WHERE solde IS NOT NULL;
   IF nc<2 THEN
      RAISE Erreur ;
   ELSE
      OPEN liste_soldes;
      FETCH liste_soldes INTO lsolde;
      courant := lsolde.solde;
      LOOP
        FETCH liste_soldes INTO lsolde;
        EXIT WHEN liste_soldes%NOTFOUND;
        suivant :=lsolde.solde;
        resultat:=resultat+ABS(suivant-courant);
        courant := suivant;
      END LOOP;
      resultat:=resultat/(nc-1);
   END IF;
   DBMS_OUTPUT.PUT_LINE('Resultat:   ' || resultat);  
   EXCEPTION WHEN Erreur THEN
      DBMS_OUTPUT.PUT_LINE('Erreur  ');  
END;
/
