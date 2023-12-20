-- SQL Structured Query language 
-- Create new table.. interact with our data.. create new data
-- retrieve/update/delete data from DB

create database if not exists bank_DB;
use bank_DB;

CREATE TABLE IF NOT EXISTS access_logs(
	id SERIAL,
    accessed TIMESTAMP NOT NULL,
    purpose TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS vaults (
	id SERIAL,
    capacity INT NOT NULL,
    item ENUM("Cash", "Documents", "Jewelry"),
    deposit_date TIMESTAMP NOT NULL,
    withdrawal_date TIMESTAMP,
    access_log_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_vault_access_logs FOREIGN KEY (access_log_id) REFERENCES 
    access_logs (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS locations (
	id SERIAL,
    address VARCHAR(45) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    vault_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_vault_location FOREIGN KEY (vault_id) REFERENCES 
    vaults (id) ON DELETE CASCADE ON UPDATE NO ACTION
    
);

CREATE TABLE IF NOT EXISTS banks (
	id SERIAL, -- short report for BIGINT, not null, unique, unsign, auto increment
    name VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    location_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_bank_location FOREIGN KEY (location_id) REFERENCES 
    locations (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS services(
	id SERIAL,
	name VARCHAR(20) NOT NULL,
    description TEXT NOT NULL,
    bank_id BIGINT UNSIGNED,
    
	CONSTRAINT fk_bank_service FOREIGN KEY (bank_id) REFERENCES 
    banks (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS login_credentials (
	id SERIAL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS employees (
	id SERIAL,
    name VARCHAR(50) NOT NULL UNIQUE,
    title ENUM("Teller", "Loan_Processor", "Manager", "Financial_Advisor") NOT NULL,
    PRIMARY KEY (id),
    login_credential_id BIGINT unsigned,
    bank_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_employee_login_credentials FOREIGN KEY (login_credential_id) REFERENCES 
    login_credentials (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    
    CONSTRAINT fk_employee_bank FOREIGN KEY (bank_id) REFERENCES 
    banks (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS customers(
	id SERIAL,
    name VARCHAR(50),
    phone_number VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS customer_banks(
	customer_id BIGINT UNSIGNED,
    bank_id BIGINT UNSIGNED,
    
	CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES 
    customers (id) ON DELETE CASCADE ON UPDATE NO ACTION,
    
    CONSTRAINT fk_bank_id FOREIGN KEY (bank_id) REFERENCES 
    banks (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS transactions (
	id SERIAL,
    amount DECIMAL NOT NULL,
    type ENUM("Deposit", "Withdrawal", "Transfer"),
    date DATETIME,
    customer_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_customer_transaction FOREIGN KEY (customer_id) REFERENCES 
    customers (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS loans (
	id SERIAL,
    amount DECIMAL NOT NULL,
    type ENUM("Personal", "Student", "Auto"),
    interest_rate DECIMAL,
    start_date DATETIME NOT NULL,
    end_date DATETIME,
    customer_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_customer_loan FOREIGN KEY (customer_id) REFERENCES 
    customers (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS accounts (
	id SERIAL,
    amount DECIMAL NOT NULL,
    type ENUM("Checking", "Saving"),
    opening_date DATETIME NOT NULL,
    balance DECIMAL NOT NULL,
    customer_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_customer_account FOREIGN KEY (customer_id) REFERENCES 
    customers (id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS statements (
	id SERIAL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    starting_balance DECIMAL NOT NULL,
    ending_balance DECIMAL NOT NULL,
    account_id BIGINT UNSIGNED,
    
    CONSTRAINT fk_account_statement FOREIGN KEY (account_id) REFERENCES 
    accounts (id) ON DELETE CASCADE ON UPDATE NO ACTION
);




