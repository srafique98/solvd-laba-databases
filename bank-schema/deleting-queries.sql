use bank_DB;

DELETE FROM access_logs WHERE id = 2;

DELETE FROM locations WHERE id = 4;

DELETE FROM banks WHERE id = 3;

DELETE FROM services WHERE id = 1;

DELETE FROM login_credentials WHERE id = 1;

DELETE FROM employees WHERE id = 3;

DELETE FROM customers WHERE id = 2;

DELETE FROM customer_banks WHERE customer_id = 3 AND bank_id = 3;

DELETE FROM transactions WHERE id = 4;

DELETE FROM loans WHERE id = 1;

DELETE FROM statements 
WHERE account_id IN (SELECT id FROM accounts WHERE balance < 1000.00);

-- IF EXISTS (SELECT 1 FROM banks WHERE id = 2) 
-- THEN 
--   DELETE FROM banks WHERE id = 2;
-- END IF;

