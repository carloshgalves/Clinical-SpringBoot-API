create table doctors (

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    medical_license_number varchar(6) not null unique,
    specialty varchar(100) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip_code varchar(9) not null,
    city varchar(100) not null,
    state varchar(2) not null,
    number varchar(20),

    primary key(id)

);