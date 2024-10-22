--Exercice 1 : Premiers blocs PL/SQL
-- Code 1: D�couvrir PL/SQL 
DECLARE 
  mavar1  NUMBER   default 1;
  mavar2  VARCHAR(6) default 'Oracle';
  mavar3  NUMBER(10);
BEGIN  
  dbms_output.put_line(‘Hello World ‘); 
  dbms_output.put_line('La valeur de mavar1 est : ' || mavar1); 
  dbms_output.put_line('La valeur de mavar2 est : ' || mavar2); 
  SELECT sal INTO mavar3 FROM emp WHERE empno=7839;
  dbms_output.put_line('Le salaire est:'|| mavar3);
END; 
/
--Exercice 2 : Entrer une valeur donnée
-- Code 2: Entrer une valeur donn�e
DECLARE
vnom varchar(10);
vno number(10);
vdate DATE;
BEGIN
vnom := '&  nom';
vno := & numero;
vdate := '& date';
dbms_output.put_line('Le nom  de est  ' || vnom  );
dbms_output.put_line('Le numero  de est  ' || vno  );
dbms_output.put_line('La date est  ' || vdate  );
END;
/
--Exercice 3 : Types 
DECLARE 
  mavar1  NUMBER ;
  vsal  mavar1%TYPE;
  vnom emp.ename%TYPE;
  venr emp%ROWTYPE; 
BEGIN  
  SELECT empno, sal, ename INTO mavar1, vsal, vnom FROM emp WHERE empno=7839;
  SELECT empno, sal, ename INTO venr.empno, venr.sal, venr.ename FROM emp WHERE empno=7839;

  -- Affichage des valeurs des variables
  dbms_output.put_line('La valeur de vsal est : ' || mavar1);
  dbms_output.put_line('La valeur de vsal est : ' || vsal);
  dbms_output.put_line('La valeur de vnom est : ' || vnom);
  --dbms_output.put_line('La valeur de venr.empno est : ' || venr.empno);
  --dbms_output.put_line('La valeur de venr.sal est : ' || venr.sal);
  --dbms_output.put_line('La valeur de venr.sal est : ' || venr.ename);
END; 
/
--Exercice 4 : VARRAY, avec paramètre
DECLARE
  --Definition
  TYPE lessalaires IS VARRAY  (5) OF NUMBER;
  --Declaration
  mavar lessalaires := lessalaires(null,null,null);
BEGIN
  --Initialiser
  mavar(1):=1000;
  mavar(2):=2000;
  mavar(3):=3000;
  mavar.EXTEND(1);
  mavar(4):=4000;
  --Utilisation
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(1) );
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(2) );
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(3) );
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(4) );
END;
/
--refaire l’exercice sans déterminer la size de la table
DECLARE
  --Definition
  TYPE lessalaires IS TABLE OF NUMBER;
  --Declaration
  mavar lessalaires := lessalaires();
BEGIN
  --Initialiser
  mavar.EXTEND(3);
  mavar(1):=1000;
  mavar(2):=2000;
  mavar(3):=3000;
  --Utilisation
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(1) );
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(2) );
  DBMS_OUTPUT.PUT_LINE('La valeur  est ' || mavar(3) );
  --mavar.delete();/* permer de disalower la table */
END;
--Exercice 5 : VARRAY, sans paramètre
DECLARE
  --Definition
  TYPE lessalaires IS VARRAY (3) OF NUMBER;
  --Declaration
  mavar lessalaires := lessalaires();
BEGIN
  SELECT sal BULK COLLECT INTO  mavar FROM emp WHERE empno IN (7839,7782);
  DBMS_OUTPUT.PUT_LINE(mavar(1));
  DBMS_OUTPUT.PUT_LINE(mavar(2));
END;
/
--refaire l’exercice sans déterminer la size de la table 
DECLARE
  --Definition
  TYPE lessalaires IS TABLE OF NUMBER;
  --Declaration
  mavar lessalaires := lessalaires();
  --mavar lessalair es ;
BEGIN
  SELECT sal BULK COLLECT INTO  mavar FROM emp; 
  DBMS_OUTPUT.PUT_LINE(mavar(1));
  DBMS_OUTPUT.PUT_LINE(mavar(2));
END;
/
--Exercice 6 : Instructions de contrôle : IF ELSE
DECLARE
  mavar NUMBER;
BEGIN
  mavar :=10;
  IF mavar>10 THEN 
    DBMS_OUTPUT.PUT_LINE('Je suis dans le bloc IF');
  ELSIF mavar = 10 THEN
    DBMS_OUTPUT.PUT_LINE('Je suis dans le bloc ELSIF');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Je suis dans le bloc ELSE');
  END IF;
END;
/
--Exercice 7 : Instructions de contrôle
--Code 1:Instructions de controle: la boucle LOOP
DECLARE
  mavar NUMBER;
BEGIN
  mavar := 1;
  LOOP
      DBMS_OUTPUT.PUT_LINE( mavar );
      mavar := mavar + 1;
      EXIT WHEN mavar=10;
  END LOOP;
END;
/
--Code 2:Instructions de controle: la boucle FOR LOOP
DECLARE
  mavar NUMBER; 
BEGIN
  mavar := NULL;
  FOR mavar IN 1..10 LOOP
  --  FOR mavar IN REVERSE 1..10 LOOP
      DBMS_OUTPUT.PUT_LINE( mavar);
  END LOOP;
END; 
/
--Code 3:Instructions de controle: la boucle WHILE
DECLARE
  mavar NUMBER;
BEGIN
  mavar := 1;
  WHILE mavar<10 LOOP
      DBMS_OUTPUT.PUT_LINE( mavar);
      mavar := mavar + 1;
  END LOOP;
END;
/
