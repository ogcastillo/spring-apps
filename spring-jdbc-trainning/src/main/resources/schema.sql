create table users (
    user_id integer identity not null,
    username varchar (255) unique not null,
    password varchar (225) not null,

    constraint pk_user_id primary key (user_id)
);