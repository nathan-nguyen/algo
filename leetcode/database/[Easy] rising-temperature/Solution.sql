SELECT
        W1.Id FROM Weather W1, Weather W2
WHERE 
        datediff(day, W2.RecordDate, W1.RecordDate) = 1 AND
        W1.Temperature > W2.Temperature

