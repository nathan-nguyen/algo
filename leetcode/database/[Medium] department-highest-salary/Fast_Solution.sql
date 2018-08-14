SELECT
        Department.Name Department, Employee.Name Employee, Salary
FROM
        Employee INNER JOIN Department ON DepartmentId = Department.Id
WHERE
        (Salary, DepartmentId) in (SELECT MAX(Salary), DepartmentId FROM Employee GROUP BY DepartmentId)

