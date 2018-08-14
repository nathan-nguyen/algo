SELECT
    (SELECT DISTINCT Salary FROM Employee
        ORDER BY Salary DESC
        OFFSET 1 rows
        FETCH NEXT 1 ROWS ONLY
    ) SecondHighestSalary

