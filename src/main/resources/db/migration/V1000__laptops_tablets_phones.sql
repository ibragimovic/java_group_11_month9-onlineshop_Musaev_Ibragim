create table laptops (
     id bigserial not null,
     name varchar(128) not null,
     image varchar(128) not null,
     quantity integer not null,
     description varchar(128) not null,
     price FLOAT not null,
     primary key (id)
);

create table tablets (
     id bigserial not null,
     name varchar(128) not null,
     image varchar(128) not null,
     quantity integer not null,
     description varchar(128) not null,
     price FLOAT not null,
     primary key (id)
);

create table phones (
    id bigserial not null,
    name varchar(128) not null,
    image varchar(128) not null,
    quantity integer not null,
    description varchar(128) not null,
    price FLOAT not null,
    primary key (id)
);
