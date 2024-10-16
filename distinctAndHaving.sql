/* DISTINCT returns only distinct (different) values. */
SELECT DISTINCT JobTitle from company.glassdoordataset;

/* HAVING clause was added to SQL because the WHERE keyword cannot be used with aggregate functions. */
/* Example: the following query checks each job title and their avg performance evaluations and displays the ones only above certain number.*/
SELECT JobTitle, AVG(PerfEval) AS AvgPerfEval FROM company.glassdoordataset
GROUP BY JobTitle
HAVING AVG(PerfEval) > 3;
