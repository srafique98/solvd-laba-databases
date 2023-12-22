use bank_DB;

ALTER TABLE customers ADD COLUMN is_active BOOLEAN DEFAULT true;

ALTER TABLE vaults DROP COLUMN withdrawal_date;

ALTER TABLE employees ADD COLUMN is_admin BOOLEAN DEFAULT false;

UPDATE banks SET phone = '378-489-2903' WHERE id = 1;

UPDATE vaults SET capacity = 120000 WHERE id = 1;

