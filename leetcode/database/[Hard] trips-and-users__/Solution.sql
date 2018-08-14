SELECT 
        Request_at as Day,
       ROUND(1.0 * COUNT(CASE WHEN (Status != 'completed') THEN 1 ELSE NULL END) / COUNT(*), 2) AS 'Cancellation Rate'
FROM 
        Trips
WHERE 
        (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
        AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at

