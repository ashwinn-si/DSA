SELECT  
    DISTINCT L1.num AS ConsecutiveNums
FROM
    Logs L1
JOIN 
    Logs L2 
ON 
    L1.num = L2.num
JOIN
    Logs L3
ON
    L3.num = L1.num
WHERE
    L1.id + 1 = L2.id
AND 
    L1.id + 2 = L3.id
;
