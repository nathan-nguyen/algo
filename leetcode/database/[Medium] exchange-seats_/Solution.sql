SELECT S1.id, 
        CASE WHEN (S1.id % 2 = 1) THEN (IFNULL((SELECT S2.student FROM seat S2 WHERE S2.id = S1.id + 1), S1.student))
        ELSE (SELECT student FROM seat S2 WHERE S2.id = S1.id - 1)
        END student
FROM seat S1

