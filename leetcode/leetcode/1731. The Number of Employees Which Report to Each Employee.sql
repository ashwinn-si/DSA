SELECT 
    manager.employee_id,
    manager.name,
    COUNT(emp.employee_id) AS reports_count,
    ROUND(AVG(emp.age)) AS average_age
FROM
    Employees emp
JOIN
    Employees manager
ON
    emp.reports_to = manager.employee_id
GROUP BY    
    manager.employee_id
ORDER BY
    manager.employee_id;