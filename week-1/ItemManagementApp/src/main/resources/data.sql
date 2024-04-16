drop table if exists users;
drop table if exists items;

create table users
(
    id  serial
        primary key,
    name     varchar(255) not null,
    password varchar(255) not null,
);

create table items
(
    id     serial
        primary key,
    description varchar(255),
    item_name   varchar(255)     not null,
    price       double precision not null,
    quantity    integer          not null,
    user_id     integer          not null,
--     foreign key (user_id) references users(id)
);

alter table items
    add constraint items_users_id_fk
        foreign key (user_id) references users;
