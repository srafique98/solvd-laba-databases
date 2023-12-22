use bank_DB;

SELECT
    type AS account_type,
    SUM(balance) AS total_balance
FROM
    accounts
GROUP BY
    account_type
HAVING
    total_balance > 50;
    
SELECT
    customer_id,
    COUNT(*) AS transaction_count
FROM
    transactions
GROUP BY
    customer_id
HAVING
    transaction_count > 1;

SELECT
    type AS account_type,
    AVG(balance) AS average_balance
FROM
    accounts
GROUP BY
    account_type
HAVING
    average_balance < 2;

SELECT
    type AS account_type,
    MAX(balance) AS max_balance
FROM
    accounts
GROUP BY
    account_type
HAVING
    max_balance > 5;
    
SELECT
    account_id,
    SUM(amount) AS total_transaction_amount
FROM
    transactions
GROUP BY
    account_id
HAVING
    total_transaction_amount > 1;

SELECT
    customer_id,
    COUNT(*) AS account_count
FROM
    accounts
GROUP BY
    customer_id
HAVING
    account_count > 2;

SELECT
    customer_id,
    AVG(amount) AS average_transaction_amount
FROM
    transactions
GROUP BY
    customer_id
HAVING
    average_transaction_amount < 2;

