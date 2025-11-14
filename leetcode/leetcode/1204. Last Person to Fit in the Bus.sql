# Write your MySQL query statement below
SELECT
    result_table.person_name
FROM
    (
        SELECT
        t1.turn,
        t1.person_name,
        COALESCE((
            SELECT
                SUM(t2.weight)
            FROM
                Queue t2
            WHERE
                t2.turn <= t1.turn
        ), 0) AS weight_till,
        COALESCE(t3.weight, 0) AS next_weight
        FROM
            Queue t1
        LEFT JOIN 
            Queue t3
        ON
            t1.turn = t3.turn - 1
        ORDER BY
            t1.turn
    ) result_table
WHERE
    result_table.weight_till + result_table.next_weight > 1000 OR result_table.turn = (SELECT MAX(turn) FROM Queue)
LIMIT 1
;

