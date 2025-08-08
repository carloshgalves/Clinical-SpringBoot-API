CREATE TABLE patients (

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    age INT NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')),
    email VARCHAR(255) NOT NULL,
    telephone_number VARCHAR(20) NOT NULL,
    street VARCHAR(255),
    neighborhood VARCHAR(255),
    zip_code VARCHAR(8) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    number VARCHAR(20),
    address_complement VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,

    PRIMARY KEY (id)
);