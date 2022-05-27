create table restore
(
    id    bigserial not null
          constraint restore_pkey
          primary key,
    email varchar(128),
    hash  varchar(128)
);
