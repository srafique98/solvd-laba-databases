use bank_DB;

SELECT
    employees.name AS employee_name,
    employees.title AS employee_title,
    banks.name AS bank_name,
    banks.phone AS bank_phone,
    locations.address AS bank_address,
	login_credentials.email AS employee_email,
    login_credentials.password AS employee_password,
    services.name AS service_name,
    services.description AS service_description
FROM employees
JOIN banks ON employees.bank_id = banks.id
JOIN locations ON banks.location_id = locations.id
JOIN login_credentials ON employees.login_credential_id = login_credentials.id
JOIN services ON banks.id = services.bank_id;