SELECT 
	IFNULL(
		ROUND(
			(SELECT
				COUNT(distinct requester_id, accepter_id)
			FROM
				request_accepted
			) / COUNT(distinct sender_id, send_to_id), 2), 0
	) accept_rate
FROM
	friend_request
