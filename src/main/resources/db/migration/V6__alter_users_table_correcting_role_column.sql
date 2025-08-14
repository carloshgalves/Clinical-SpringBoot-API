ALTER TABLE users
MODIFY COLUMN role ENUM('administrator', 'patient', 'doctor') NOT NULL;
