SELECT
        * 
FROM 
        cinema 
WHERE 
        ID % 2 = 1
        AND description <> 'boring'
ORDER BY rating DESC

