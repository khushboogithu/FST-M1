REM   Script: Activity1,2,3,4,5
REM   Activities 1-5 

CREATE DATABASE activities;

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar(52), 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

   Select * from Salesman;

CREATE TABLE Salesman(Salesman_id int PRIMARY KEY, Salesman_name varchar2(32),Salesman_city varchar2(32),Commission int);

DESCRIBE Salesman


INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

Select * from Salesman;

CREATE TABLE Salesperson(Salesperson_id int PRIMARY KEY, Salesperson_name varchar2(32),Salesperson_city varchar2(32),Commission int);

DESCRIBE Salesperson


INSERT ALL 
    INTO Salesperson VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO Salesperson VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO Salesperson VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO Salesperson VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

Select * from Salesperson;

SELECT Salesperson_id, Salesperson_city FROM Salesperson;

SELECT * FROM Salesperson WHERE Salesperson_city='Paris';

SELECT Salesperson_id, commission FROM Salesperson WHERE Salesperson_name='Paul Adam';

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

ALTER TABLE Salesperson ADD grade int;

UPDATE Salesperson SET grade=100;

UPDATE Salesperson SET grade=200 WHERE Salesperson_city='Rome';

UPDATE Salesperson SET grade=300 WHERE Salesperson_name='James Hoog';

UPDATE Salesperson SET Salesperson_name='Pierre' WHERE Salesperson_name='McLyon';

SELECT * FROM Salesperson;

