create table customers (
     id bigserial not null,
     email varchar(128) not null,
     password varchar(128) not null,
     full_name varchar(128) not null,
     primary key (id)
);