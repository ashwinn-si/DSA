# Write your MySQL query statement below
SELECT 
    t.Department,
    t.Employee,
    t.salary
FROM(
    SELECT
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) as pos
    FROM
        Employee e
    JOIN
        Department d
    ON
        e.departmentId = d.id
) t
WHERE
    t.pos < 4
;