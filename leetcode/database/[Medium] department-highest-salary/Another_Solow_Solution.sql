SELECT
        Department.Name Department, E1.Name Employee, Salary
FROM
        Employee E1,
        Department,
        (
                SELECT MAX(E2.Salary) MaxSalary, E2.DepartmentId MaxSalaryDepartmentId FROM Employee E2 GROUP BY E2.DepartmentId
        ) MaxSalaryDepartment
WHERE
        E1.DepartmentId = Department.Id AND
        E1.DepartmentId = MaxSalaryDepartmentId AND
        E1.Salary = MaxSalary

