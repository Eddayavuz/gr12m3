/* COUNT */
SELECT Gender, COUNT(*) FROM acs.employee
GROUP BY Gender;

SELECT COUNT(*) as Seniors
FROM acs.employee
WHERE YearsOfExperience > 10;


/* SUM */
SELECT SUM(Salary) AS MonthlyOutcome
FROM acs.employee
WHERE JobTitle LIKE '%Developer%';

/* AVG */
SELECT Gender, AVG(Salary) AS AvgSalary
From employee
GROUP BY Gender;

/* MIN AND MAX */
SELECT MAX(Salary) AS Minimum
FROM employee;

/* ORDER BY AND LIMIT */
SELECT First_Name, age FROM employee
WHERE gender = 'male'
ORDER BY age asc
LIMIT 1;
