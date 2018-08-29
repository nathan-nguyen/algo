SELECT
        e1.Name
FROM
        Employee e1, Employee e2
WHERE
        e1.Id = e2.ManagerId
GROUP BY e1.Name
HAVING COUNT(e1.Name) > 4

