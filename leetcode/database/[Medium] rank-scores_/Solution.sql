SELECT
        S1.Score,
        (SELECT COUNT(DISTINCT S2.Score) FROM Scores S2 WHERE S2.Score >= S1.Score) 'Rank'
FROM Scores S1
ORDER BY S1.Score DESC
