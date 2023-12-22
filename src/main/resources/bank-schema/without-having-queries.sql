use bank_DB;

SELECT
    type AS account_type,
    SUM(balance) AS total_balance
FROM
    accounts
GROUP BY
    account_type;
    
SELECT
    customer_id,
    COUNT(*) AS transaction_count
FROM
    transactions
GROUP BY
    customer_id;
    
SELECT
    type AS account_type,
    AVG(balance) AS average_balance
FROM
    accounts
GROUP BY
    account_type;

SELECT
    type AS account_type,
    MAX(balance) AS max_balance
FROM
    accounts
GROUP BY
    account_type;
   
SELECT
    customer_id,
    SUM(amount) AS total_transaction_amount
FROM
    transactions
GROUP BY
    customer_id;

SELECT
    customer_id,
    COUNT(*) AS account_count
FROM
    accounts
GROUP BY
    customer_id;
   
SELECT
    customer_id,
    AVG(amount) AS average_transaction_amount
FROM
    transactions
GROUP BY
    customer_id;
