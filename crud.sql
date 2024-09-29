/* Alter the columns to convert their data type */
ALTER TABLE company.csvjson
MODIFY DateOfBirth__1 datetime;

/*NULL Values*/
INSERT INTO company.csvjson (UserID, FirstName, LastName, Sex, Phone, DateOfBirth__1, JobTitle)
VALUES ('AB12345678', 'Eda', 'Yavuz', 'Female', '123-456-7890', '1993-08-25', 'developer');

/* YEAR Function */
SELECT * FROM company.csvjson
WHERE YEAR(DateOfBirth__1) > 2010;

/* CALCULATING THE AGE FROM DATE TIME COLUMN */
SELECT FirstName, FLOOR(DATEDIFF(NOW(), DateOfBirth__1)/ 365) as age FROM company.csvjson;

/* AND OR */
SELECT * FROM company.csvjson
WHERE FirstName = 'Lindsey' OR FirstName = 'Todd' ;

SELECT * FROM company.csvjson
WHERE FirstName = 'Lindsey' AND FirstName = 'Todd' ;

