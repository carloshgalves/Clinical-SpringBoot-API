CREATE TABLE doctors (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone_number VARCHAR(20) NOT NULL,
    medical_license_number VARCHAR(50) NOT NULL,
    specialty ENUM('ORTHOPEDICS', 'CARDIOLOGY', 'GYNECOLOGY', 'DERMATOLOGY') NOT NULL,
    street VARCHAR(255),
    neighborhood VARCHAR(255),
    zip_code VARCHAR(8),
    city VARCHAR(255),
    state VARCHAR(255),
    number VARCHAR(20),
    address_complement VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,

    PRIMARY KEY (id)
);