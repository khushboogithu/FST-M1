--Activity 1- Create a salesman table
CREATE TABLE salesman(salesman_id int, salesman_name VARCHAR(20), salesman_city VARCHAR(20), commission int);

Describe salesman

--Activity 2 - Insert data into salesman table
-- Insert one row
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- To display all the rows
SELECT * FROM salesman;

--Activity3- To display data from the salesman table
--show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;
--show data of salesman from Paris
SELECT * FROM salesman WHERE salesman_city= 'PARIS';
--show salesman_id and Commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE salesman_name= 'Paul Adam';

--Activity4 - Adding a  new column to the salesman table
ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade = 100;
SELECT * FROM salesman;

--Activity5- Updata data in the salesman Table
--Update the grade score  of salesman from Rome to 200
UPDATE salesman SET grade = 200 WHERE salesman_city = 'Rome';
--Update the grade score of James Hoog to 300
UPDATE salesman SET grade = 300 WHERE salesman_name = 'James Hoog';
-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';
-- Display modified data
SELECT * FROM salesman;

