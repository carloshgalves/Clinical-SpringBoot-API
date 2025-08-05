create table patients (

    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(80) NOT NULL,
    cpf char(11) NOT NULL UNIQUE,
    age int NOT NULL,
    sex char(1) CHECK (sex IN ('M', 'F')),

    primary key(id)

)