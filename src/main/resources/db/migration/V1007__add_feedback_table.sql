create table feedback (
      id bigserial not null,
      feedback varchar(255) not null,
      customer_id bigint not null references carts(id),
      primary key(id)
);
