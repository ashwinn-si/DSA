SELECT 
    product_id,
    year as first_year,
    quantity,
    price
FROM
    Sales
WHERE
    (year, product_id) IN (
        SELECT
            MIN(year),
            product_id
        FROM
            Sales
        GROUP BY
            product_id
    )

ORDER BY 
    product_id;