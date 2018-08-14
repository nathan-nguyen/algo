SELECT
        Score,
        (SELECT COUNT(*) from (SELECT DISTINCT Score s from Scores) ScoreTable where s >= Score) Rank
FROM Scores
ORDER BY Score DESC

