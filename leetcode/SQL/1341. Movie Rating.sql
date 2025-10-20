# Write your MySQL query statement below
SELECT 
    results
FROM
(
    (
    SELECT
        u.name AS results
    FROM
        Users u
    JOIN
        MovieRating r
    ON
        u.user_id = r.user_id
    GROUP BY
        u.user_id
    ORDER BY
        COUNT(*) DESC, u.name
    LIMIT 1
)
UNION ALL
(
    SELECT
        m.title as results
    FROM
        Movies m
    JOIN
        MovieRating r
    ON
        m.movie_id = r.movie_id
    WHERE
        MONTH(r.created_at) = 2 AND YEAR(r.created_at) = 2020
    GROUP BY    
        m.movie_id
    ORDER BY
        AVG(r.rating) DESC, m.title
    LIMIT 1
) 
) AS top_result
;