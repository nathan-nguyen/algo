SELECT
        DISTINCT S1.*
FROM
        stadium S1, stadium S2, stadium S3
WHERE
        (
                (S1.id + 1 = S2.id AND S2.id + 1 = S3.id)
                OR (S2.id + 1 = S1.id AND S1.id + 1 = S3.id)
                OR (S2.id + 1 = S3.id AND S3.id + 1 = S1.id)
        )
        AND S1.people >= 100 AND S2.people >= 100 AND S3.people >= 100
ORDER BY S1.Id

