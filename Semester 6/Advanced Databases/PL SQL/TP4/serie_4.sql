--Exercice 1
DROP TABLE Article;
CREATE TABLE Article(Num_Article NUMBER PRIMARY KEY,Designation VARCHAR(10),Prix_Unitaire NUMBER, Qte_Stock NUMBER);
INSERT INTO  Article VALUES (1,'TV',690,50);
INSERT INTO  Article VALUES (2,'Radio',130,10);
INSERT INTO  Article VALUES (3,'GSM',350,20);
INSERT INTO  Article VALUES (4,'PC',990,39);
SELECT * FROM Article; 
--Exercice 2
DECLARE
  Vmax  Article.Qte_Stock%TYPE;
  q  Article.Qte_Stock%TYPE;
BEGIN 
  SELECT MAX (Qte_Stock) INTO  vmax from Article;   
  SELECT  Qte_Stock INTO q  from Article  WHERE Num_Article=1 ;  
  if vmax > q THEN 
    update Article SET Prix_Unitaire = Prix_Unitaire*(0.9) WHERE Num_Article =1 ; 
  ELSE   
    update Article SET Prix_Unitaire = Prix_Unitaire*(1.2) WHERE Num_Article=1 ;
  end if;
END;
/
--Exercice 3
DECLARE 
  vnum NUMBER;
  vdes  Article.Designation%TYPE;
BEGIN 
  SELECT COUNT( Num_Article) INTO  vnum from Article where  Num_Article =10;   
  If vnum=0 THEN  
    DBMS_OUTPUT.PUT_LINE ('Rien du tout');
  ELSE
    SELECT  designation INTO vdes FROM Article WHERE  Num_Article =10;   
    DBMS_OUTPUT.PUT_LINE (vdes);
  END IF;
END;
/
--Exercice 4
DECLARE 
  qte  Article.Qte_Stock%TYPE; 
BEGIN 
  SELECT Qte_Stock INTO  qte from Article where  Num_Article =2;   
  If qte>50 THEN  
    UPDATE  Article SET Prix_Unitaire=Prix_Unitaire+200;
  ELSIF qte>=30 AND qte<=50 THEN
    UPDATE  Article SET Prix_Unitaire=Prix_Unitaire+100;
  ELSIF qte>=20 AND qte<30 THEN
    UPDATE  Article SET Prix_Unitaire=Prix_Unitaire-100;
  ELSE
     UPDATE  Article SET Prix_Unitaire=Prix_Unitaire-50;
  END IF;
END;
/
--Exercice 5
DECLARE 
  vqt  Article.Qte_stock%TYPE;
  s  Article.Qte_stock%TYPE;
BEGIN
  s:=0;
  FOR i  IN 1..4 LOOP
    SELECT qte_stock INTO vqt FROM Article WHERE num_article=i;
    s:=s+ vqt ; 
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('La somme est : '|| s);
END;
/
--Exercice 6
DECLARE 
nb NUMBER;
maxi  Article.prix_unitaire%TYPE;
temp  Article.prix_unitaire%TYPE;
i number :=2;
BEGIN
    SELECT COUNT(*) INTO nb FROM Article ;
    SELECT prix_unitaire  INTO maxi FROM Article WHERE num_article=1;
    WHILE i< nb LOOP
    SELECT prix_unitaire INTO temp FROM Article WHERE num_article=i;
    IF (temp>maxi) THEN 
       maxi:=temp;
    END IF;
    i:=i+1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('le maximum est '||maxi);
 end;
/
--Exercice 7
DECLARE
   vq  Article.Qte_stock%TYPE;
   TYPE t_varray IS VARRAY(20) OF INTEGER ;
   t t_varray:= t_varray();
BEGIN
   t.EXTEND(4);
   FOR i IN 1..t.COUNT() LOOP
     SELECT Qte_Stock  INTO vq  FROM Article WHERE num_article=i;
     t(i):=vq*(1+vq)*0.5;
   END LOOP;
   FOR i IN 1..t.COUNT() LOOP
      DBMS_OUTPUT.PUT_LINE(t(i));
   END LOOP;
END;
/
--Exercice 8
DECLARE
   n NUMBER ;
   taille NUMBER;
BEGIN
    n:=&nombre;
    IF n>=5 AND n<=20  THEN
      SELECT COUNT(*) INTO taille FROM Article;
      FOR i IN 1..n LOOP
       INSERT INTO Article VALUES(i+1+taille,dbms_random.string('A',4),TRUNC(dbms_random.value(20,100)),TRUNC(dbms_random.value(20,100)) );
      END LOOP;
    ELSE
       DBMS_OUTPUT.PUT_LINE('n est non valide ');
    END IF;  
END;
/
SELECT* FROM Article;

