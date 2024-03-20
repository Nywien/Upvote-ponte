INSERT INTO custom_user (username, first_name, last_name, password, email, role)
SELECT 'admin', 'Admin', 'Admin', '$2a$12$lBovvDiVXeskzZXCRgPbXu/dbP3KVt6/HU6Np05bhELac2hpuMsrS', 'admin@example.com', 'ROLE_ADMIN'
WHERE NOT EXISTS(
SELECT 1 FROM custom_user
WHERE username ='admin');