use bank_DB;

INSERT INTO access_logs (accessed, purpose) 
VALUES 
    ('2023-12-20 01:15:00', 'Placing documents'),
    ('2022-03-11 04:12:00', 'Placing Cash'),
    (CURRENT_TIMESTAMP, 'Placing Jewelry');

INSERT INTO access_logs (accessed, purpose) VALUES (CURRENT_TIMESTAMP, 'Dropping cash');

INSERT INTO vaults (capacity, item, deposit_date, access_log_id)
VALUES 
    (100000, 'Cash', '2023-01-01', 2),
    (500, 'Documents', '2023-02-15', 1),
    (200, 'Jewelry', '2023-03-30', 3);
    
INSERT INTO vaults (capacity, item, deposit_date, access_log_id) VALUES (100000, 'Cash', CURRENT_DATE , 4);

    
INSERT INTO locations (address, city, state, country, postal_code, vault_id)
VALUES 
    ('123 Main St', 'Cityville', 'CA', 'USA', '12345', 1),
    ('456 Ham St', 'Townsville', 'NY', 'USA', '67890', 2),
    ('789 1 St', 'Dallas', 'TX', 'USA', '45678', 3);

INSERT INTO locations (address, city, state, country, postal_code, vault_id) VALUES ('233 tokay St', 'Madson', 'WA', 'USA', '839832', 4);

INSERT INTO banks (name, phone, location_id)
VALUES 
    ('Bank A', '123-456-7890', 1),
    ('Bank B', '987-654-3210', 2),
    ('Bank C', '111-222-3333', 3);

INSERT INTO banks (name, phone, location_id) VALUES ('Bank D', '324-453-4542', 4);
    
INSERT INTO services (name, description, bank_id)
VALUES 
    ('Savings Account', 'Basic savings account', 1),
    ('Home Loan', 'Mortgage for buying a house', 2),
    ('Financial Advisory', 'Personal financial planning', 3);
    
INSERT INTO services (name, description, bank_id) VALUES ('Dispute talks', 'Discussing about closure', 4);

INSERT INTO login_credentials (email, password)
VALUES 
    ('kyle.Koo@email.com', 'skos23@ok'),
    ('Katherine.smith@email.com', 'cool20(0Ks'),
    ('nobody@email.com', 'password123');

INSERT INTO login_credentials (email, password) VALUES ('Layla.Adams@email.com', 'dkd9NID82)');

INSERT INTO employees (name, title, login_credential_id, bank_id)
VALUES 
    ('kyle koo', 'Manager', 1, 1),
    ('Kath Smith', 'Financial_Advisor', 2, 2),
    ('No nope', 'Teller', 3, 3);

INSERT INTO employees (name, title, login_credential_id, bank_id) VALUES ('Layla Adams', 'Loan_Processor', 4, 4);


INSERT INTO customers (name, phone_number)
VALUES 
    ('Customer 1', '111-111-1111'),
    ('Customer 2', '222-222-2222'),
    ('Customer 3', '333-333-3333');
    
INSERT INTO customers (name, phone_number) VALUES ('Customer 4', '378-899-7362');

INSERT INTO customer_banks (customer_id, bank_id)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO customer_banks (customer_id, bank_id) VALUES (4, 4);

INSERT INTO transactions (amount, type, date, customer_id)
VALUES 
    (1000.00, 'Deposit', '2023-01-02', 1),
    (500.00, 'Withdrawal', '2023-02-10', 2),
    (200.00, 'Transfer', '2023-03-20', 3);

INSERT INTO transactions (amount, type, date, customer_id) VALUES (10.00, 'Deposit', '2021-06-09', 4);

INSERT INTO loans (amount, type, interest_rate, start_date, end_date, customer_id)
VALUES 
    (50000.00, 'Personal', 5.0, '2023-01-15', '2024-01-15', 1),
    (100000.00, 'Auto', 4.5, '2023-02-20', '2024-02-20', 2),
    (20000.00, 'Student', 3.0, '2023-03-25', '2024-03-25', 3);

INSERT INTO loans (amount, type, interest_rate, start_date, end_date, customer_id) VALUES (99.00, 'Personal', 9.0, CURRENT_DATE, '2026-02-19', 4);


INSERT INTO accounts (amount, type, opening_date, balance, customer_id)
VALUES 
    (5000.00, 'Checking', '2023-01-01', 5000.00, 1),
    (10000.00, 'Saving', '2023-02-15', 10000.00, 2),
    (2000.00, 'Checking', '2023-03-30', 2000.00, 3);

INSERT INTO accounts (amount, type, opening_date, balance, customer_id) VALUES (20.00, 'Checking', '2023-01-01', 30.00, 4);


INSERT INTO statements (start_date, end_date, starting_balance, ending_balance, account_id)
VALUES 
    ('2023-01-01', '2023-01-31', 5000.00, 6000.00, 1),
    ('2023-02-15', '2023-02-28', 10000.00, 9500.00, 2),
    ('2023-03-30', '2023-03-31', 2000.00, 1800.00, 3);

INSERT INTO statements (start_date, end_date, starting_balance, ending_balance, account_id) VALUES ('2023-06-03', '2023-06-30', 1900.00, 2000.00, 7);

    