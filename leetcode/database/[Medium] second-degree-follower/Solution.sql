SELECT
	f1.follower, count(distinct f2.follower) num
FROM
	follow f1, follow f2
WHERE
	f1.follower = f2.followee
GROUP BY f1.follower
