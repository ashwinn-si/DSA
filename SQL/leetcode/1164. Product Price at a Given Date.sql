SELECT
    DISTINCT t3.product_id,
    COALESCE(
        (
            SELECT
                t1.new_price
            FROM
                Products t1
            WHERE
                t1.product_id = t3.product_id
            AND
                t1.change_date <= '2019-08-16' 
            ORDER BY
                t1.change_date DESC          
            LIMIT 1
        ),
        10 
    ) AS price
FROM
    Products t3;