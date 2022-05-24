create table carts (
                         id bigserial not null,
                         customer_id bigint not null references users(id),
                         primary key (id)
);

create table orders (
                         id bigserial not null,
                         gadget_name varchar(128) not null,
                         gadget_type varchar(128) not null,
                         cart_id bigint not null references carts(id),
                         primary key (id)
);
