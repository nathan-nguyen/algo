CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        SELECT (
                SELECT DISTINCT Salary FROM Employee
                ORDER BY SALARY DESC
                OFFSET (@N-1) ROWS
                FETCH NEXT 1 ROWS ONLY
        ) SalaryTable
    );
END

