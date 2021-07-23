CREATE TABLE users(
    user_id integer identity NOT NULL,
    username varchar(255) unique NOT NULL CHECK (username <> ''),
    password varchar (255) NOT NULL CHECK (password <> ''),

    CONSTRAINT pk_user_user_id PRIMARY  KEY (user_id),
    CONSTRAINT check_username CHECK (CHAR_LENGTH (username) > 7),
    CONSTRAINT check_password CHECK (LENGTH (password) > 7)
);