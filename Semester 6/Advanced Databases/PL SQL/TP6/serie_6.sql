--Exercice 2 
--Question 1
DROP TABLE table_client;
CREATE TABLE table_client(numeroclient NUMBER,totat_achat NUMBER);
SELECT * FROM table_client;
CREATE OR REPLACE PROCEDURE total_achat IS
CURSOR cur IS SELECT Num_cl, SUM(prix) FROM produit GROUP BY Num_cl;
   var_id NUMBER;
   var_total NUMBER;
BEGIN
   OPEN cur;
   LOOP
   FETCH cur INTO var_id,var_total;
     EXIT WHEN cur%NOTFOUND;
     INSERT INTO table_client VALUES(var_id,var_total);
   END LOOP;
END;
/
BEGIN
total_achat;
END;
/
--Question 2
CREATE OR REPLACE FUNCTION total_achat_client(Id_client NUMBER) RETURN NUMBER IS
   total NUMBER;
BEGIN
SELECT SUM(prix)INTO total FROM  produit WHERE Num_cl=Id_client;
RETURN total;
END;
/
BEGIN
  DBMS_OUTPUT.PUT_LINE(total_achat_client(1));
END;
/
--Question 3
CREATE OR REPLACE PROCEDURE delete_client  IS
CURSOR cur IS SELECT  Num_cl FROM client;
enr cur%ROWTYPE;
BEGIN
FOR enr IN cur LOOP
  IF total_achat_client(enr.Num_cl)<200 THEN
   DELETE FROM produit WHERE Num_cl=enr.Num_cl;
   DELETE FROM client WHERE Num_cl=enr.Num_cl;
  END IF;
END LOOP;
END;
/
BEGIN
delete_client;
END;
/
--Question 4
CREATE OR REPLACE FUNCTION nbr_achat_client(Id_client NUMBER) RETURN NUMBER IS
   total NUMBER;
BEGIN
SELECT COUNT(prix)INTO total FROM  produit WHERE Num_cl=Id_client;
RETURN total;
END;
/
BEGIN
  DBMS_OUTPUT.PUT_LINE(nbr_achat_client(6));
END;
/
--Question 5
CREATE OR REPLACE PROCEDURE stockage_num IS
    TYPE table_nom IS TABLE OF client.nom%TYPE INDEX BY BINARY_INTEGER;
    CURSOR cur IS SELECT  Num_cl, nom FROM client;
    t_nom table_nom;
    var_nc NUMBER;
    var_nom VARCHAR(20);
    i NUMBER DEFAULT 0;
    erreur EXCEPTION;
BEGIN
    OPEN cur;
    LOOP
      FETCH cur INTO var_nc,var_nom;
      EXIT WHEN cur%NOTFOUND;
      IF  nbr_achat_client(var_nc)>=2 THEN
        t_nom(i) :=  var_nom;
        i:=i+1;
      END IF;
    END LOOP;
    FOR i IN 0 ..t_nom.COUNT LOOP
      IF t_nom.EXISTS(i) THEN
        DBMS_OUTPUT.PUT_LINE(t_nom(i));
      ELSE
        RAISE erreur;
      END IF;
   END LOOP;
   EXCEPTION 
   WHEN NO_DATA_FOUND THEN 
       DBMS_OUTPUT.PUT_LINE('Donn�es n''existe pas ');
   WHEN erreur THEN 
       DBMS_OUTPUT.PUT_LINE('Fin du tableau t_nom ');
   WHEN invalid_cursor THEN 
       DBMS_OUTPUT.PUT_LINE('Erreur de courseur ');
END;
/
BEGIN
stockage_num;
END;
/
--Exercice 6
SELECT * FROM client;
CREATE OR REPLACE TYPE list_table IS TABLE OF VARCHAR(20);
CREATE OR REPLACE FUNCTION t_table RETURN list_table IS
     v_ta list_table:=list_table();
BEGIN
     v_ta.EXTEND(24);
     SELECT nom BULK COLLECT INTO v_ta FROM client;
     return v_ta;
END;
/
SELECT * FROM TABLE(t_table);
DECLARE
v_ta list_table:=list_table();
BEGIN
     v_ta.EXTEND(24);
     SELECT nom BULK COLLECT INTO v_ta FROM client;
     DBMS_OUTPUT.PUT_LINE(v_ta(1));
END;
/
