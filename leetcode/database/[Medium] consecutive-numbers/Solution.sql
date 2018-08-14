SELECT DISTINCT l1.Num 'ConsecutiveNums'
FROM Logs l1, Logs l2, Logs l3
WHERE l1.id + 1 = l2.id
AND l2.id + 1 = l3.id
AND l1.Num = L2.Num
AND l2.Num = l3.Num
