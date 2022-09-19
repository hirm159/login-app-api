create table if not exists account( 
    id serial not null
    , username varchar (255) not null
    , password varchar (255) not null
    , mail_address varchar (255) not null
    , delete_flg int not null default 0
    , first_date timestamp
    , last_date timestamp
    , version int not null
    , primary key(id)
);

create table if not exists test(
    id int not null
    , name varchar (30) 
);

