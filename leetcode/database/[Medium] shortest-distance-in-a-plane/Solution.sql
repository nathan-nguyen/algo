SELECT
	ROUND(SQRT(MIN(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))), 2) shortest
FROM
	point_2d p1, point_2d p2
WHERE
	p1.x != P2.x OR p1.y != p2.y

