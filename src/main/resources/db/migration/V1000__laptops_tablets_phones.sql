create table laptops (
     id serial not null,
     name varchar(128) not null,
     image varchar(128) not null,
     description varchar(128) not null,
     price INTEGER not null,
     primary key (id)
);

create table tablets (
     id serial not null,
     name varchar(128) not null,
     image varchar(128) not null,
     description varchar(128) not null,
     price INTEGER not null,
     primary key (id)
);

create table phones (
    id serial not null,
    name varchar(128) not null,
    image varchar(128) not null,
    description varchar(128) not null,
    price INTEGER not null,
    primary key (id)
);
