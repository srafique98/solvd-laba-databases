use bank_DB;

UPDATE access_logs SET purpose = 'Changing documents', accessed = CURRENT_TIMESTAMP WHERE id = 1;

UPDATE vaults SET item = 'Cash', withdrawal_date = '2023-04-15' WHERE id = 2;

UPDATE locations SET city = 'Provo', state = 'UT' WHERE id = 3;

UPDATE banks SET phone = '121-124-6554' WHERE id = 4;

UPDATE services SET description = 'Flexible mortgage options for home buyers' WHERE id = 2;

UPDATE login_credentials SET email = 'new.email@email.com' WHERE id = 3;

UPDATE employees SET title = 'Manager', bank_id = 2 WHERE id = 4;

UPDATE customers SET phone_number = '453-493-2839' WHERE id = 3;

UPDATE transactions SET amount = 1500.00, type = 'Deposit' WHERE id = 1;

UPDATE loans SET interest_rate = 3.5, end_date = '2024-04-25' WHERE id = 3;

UPDATE accounts SET type = 'Saving', opening_date = '2023-04-01' WHERE id = 4;
