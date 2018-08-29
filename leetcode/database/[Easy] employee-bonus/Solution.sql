SELECT
	name, bonus
FROM
	Employee LEFT JOIN Bonus ON Employee.empId = Bonus.empId
WHERE
	(Bonus.bonus IS NULL) OR Bonus.bonus < 1000

