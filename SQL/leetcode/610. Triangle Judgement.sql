SELECT
    *,
    CASE
        WHEN (x + y > z AND y + z > x AND x + z > y) THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM
    Triangle;

select *, if(x+y>z and y+z>x and x+z>y, "Yes","No") as triangle from triangle;