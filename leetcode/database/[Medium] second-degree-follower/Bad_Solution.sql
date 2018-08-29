SELECT follower, count(follower) num
FROM
	(SELECT distinct f1.follower, f2.follower follower_follower
	FROM follow f1, follow f2
	WHERE f1.follower = f2.followee) follow_table
GROUP BY follower

