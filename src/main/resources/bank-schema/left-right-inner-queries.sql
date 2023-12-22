use bank_DB;
    
SELECT
    c.id AS customer_id,
    c.name AS customer_name,
    a.id AS account_id,
    a.type AS account_type
FROM
    customers c
INNER JOIN
    accounts a ON c.id = a.customer_id;
   
SELECT
    b.id AS bank_id,
    b.name AS bank_name,
    c.id AS customer_id,
    c.name AS customer_name
FROM
    banks b
LEFT JOIN
    customers c ON b.location_id = c.id;

SELECT
    a.id AS account_id,
    a.type AS account_type,
    a.balance AS account_balance,
    c.id AS customer_id,
    c.name AS customer_name
FROM
    accounts a
INNER JOIN
    customers c ON a.customer_id = c.id;

SELECT
    a.id AS account_id,
    a.type AS account_type,
    s.id AS statement_id,
    s.start_date AS statement_start_date,
    s.end_date AS statement_end_date
FROM
    accounts a
RIGHT JOIN
    statements s ON a.id = s.account_id;
    
SELECT
    c.id AS customer_id,
    c.name AS customer_name,
    b.id AS bank_id,
    b.name AS bank_name
FROM
    customers c
LEFT JOIN
    customer_banks cb ON c.id = cb.customer_id
LEFT JOIN
    banks b ON cb.bank_id = b.id;


