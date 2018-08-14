SELECT
        Department.Name Department, E1.Name Employee, Salary
FROM
        Employee E1, Department
WHERE
        E1.DepartmentId = Department.Id AND
        (SELECT COUNT(*) FROM Employee E2 WHERE E1.DepartmentId = E2.DepartmentId AND E2.Salary > E1.Salary) = 0

