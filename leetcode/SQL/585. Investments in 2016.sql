# Write your MySQL query statement below
SELECT
    ROUND(SUM(t1.tiv_2016), 2) AS tiv_2016
FROM
    Insurance t1
WHERE
    t1.tiv_2015 IN (
        SELECT 
            tiv_2015
        FROM 
            Insurance
        GROUP BY 
            tiv_2015
        HAVING 
            COUNT(*) > 1
    )
AND
    (t1.lat, t1.lon) IN (
        SELECT
            lat, lon
        FROM
            Insurance
        GROUP BY
            lat, lon
        HAVING
            count(*) = 1
    )
;
