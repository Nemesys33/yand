create table orders_abr
(
    id        bigserial
        primary key,
    cost      integer not null,
    regions   integer not null,
    weight    real    not null,
    completed boolean not null
);

alter table orders_abr
    owner to postgres;

create table couriers_abr
(
    id bigserial primary key,
    courier_type text not null
);

alter table couriers_abr
    owner to postgres;

create table order_delivery_time_abr
(
    order_id   bigint not null
        constraint "order_deliveryTime_order_id_fkey"
            references orders_abr (id),
    deliv_time text   not null,
    constraint "order_delivery_abrTime_pkey"
        primary key (order_id, deliv_time)
);

alter table order_delivery_time_abr
    owner to postgres;

create table complete_order_abr
(
    order_id      bigint not null
        primary key
        references orders_abr (id),
    courier_id    bigint not null
        references couriers_abr (id),
    complete_time timestamp not null
);

alter table complete_order_abr
    owner to postgres;

create table curier_wh_abr
(
    wh         text   not null,
    courier_id bigint not null
        references couriers_abr (id),
    primary key (courier_id, wh)
);

alter table curier_wh_abr
    owner to postgres;

create table curier_region_abr
(
    courier_id bigint  not null
        references couriers_abr (id),
    region     integer not null,
    primary key (courier_id, region)
);

alter table curier_region_abr
    owner to postgres;