SELECT
        Department.Name Department, E1.Name Employee, E1.Salary
FROM
        Employee E1 INNER JOIN Department ON E1.DepartmentId = Department.Id
WHERE
        (SELECT COUNT(DISTINCT E2.Salary) FROM Employee E2 WHERE E1.DepartmentId = E2.DepartmentId AND E2.Salary > E1.Salary) < 3
ORDER BY Department.Name, E1.Salary DESC

