SELECT 
    ROUND(AVG(d.order_date = d.customer_pref_delivery_date) * 100, 2) AS immediate_percentage
FROM 
    delivery d
WHERE 
    (customer_id, order_date)
IN
(SELECT 
    customer_id,
    min(order_date) as order_date
FROM 
    Delivery 
GROUP BY
    customer_id
);