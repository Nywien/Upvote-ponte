INSERT INTO custom_user (username, first_name, last_name, password, email, role)
SELECT 'admin', 'Admin', 'Admin', 'admin', 'admin@example.com', 'ROLE_ADMIN'
WHERE NOT EXISTS(
SELECT 1 FROM custom_user
WHERE username ='admin'
)
;