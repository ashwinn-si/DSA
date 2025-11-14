SELECT
    e1.employee_id 
FROM
    (
        SELECT
            *
        FROM
            Employees
        WHERE
            manager_id IS NOT NULL
    ) e1
LEFT JOIN
    Employees e2
ON
    e1.manager_id = e2.employee_id
WHERE
    e2.employee_id IS NULL AND e1.salary < 30000
ORDER BY
    e1.employee_id;


//NOTE CAN USE NOT IN TOO