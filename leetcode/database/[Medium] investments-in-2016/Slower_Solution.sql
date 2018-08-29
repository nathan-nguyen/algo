SELECT
	SUM(TIV_2016) TIV_2016
FROM
	insurance I1
WHERE
	(SELECT COUNT(*) FROM insurance I2 WHERE I2.LAT = I1.LAT AND I2.LON = I1.LON) = 1
	AND (SELECT COUNT(*) FROM insurance I3 WHERE I3.TIV_2015 = I1.TIV_2015) > 1

