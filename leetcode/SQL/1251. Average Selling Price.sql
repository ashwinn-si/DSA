SELECT
    p.product_id,
    COALESCE(ROUND((SUM(s.units * p.price) / SUM(s.units)), 2), 0) AS average_price
FROM
    Prices p
LEFT JOIN
    UnitsSold s ON p.product_id = s.product_id
    AND s.purchase_date >= p.start_date
    AND s.purchase_date <= p.end_date
GROUP BY
    p.product_id;