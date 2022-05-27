CREATE TABLE users (
       id BIGSERIAL NOT NULL,
       email varchar(128) NOT NULL UNIQUE,
       password varchar(128) NOT NULL,
       fullname varchar(128) NOT NULL,
       enabled boolean NOT NULL,
       role varchar(16) NOT NULL,
       PRIMARY KEY (id)
);
