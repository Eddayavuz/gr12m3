/* Alter the columns to convert their data type */
ALTER TABLE company.csvjson
MODIFY DateOfBirth__1 datetime;


/* CALCULATING THE AGE FROM DATE TIME COLUMN */
SELECT FirstName, FLOOR(DATEDIFF(NOW(), DateOfBirth__1)/ 365) as age FROM company.csvjson;

/* AND OR */
SELECT * FROM company.csvjson
WHERE FirstName = 'Lindsey' OR FirstName = 'Todd' ;

SELECT * FROM company.csvjson
WHERE FirstName = 'Lindsey' AND FirstName = 'Todd' ;

