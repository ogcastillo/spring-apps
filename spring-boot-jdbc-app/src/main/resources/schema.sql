CREATE TABLE users(
  user_id integer identity NOT NULL,
  username varchar(255) unique NOT NULL,
  password varchar (255) NOT NULL,

  CONSTRAINT pk_user_user_id PRIMARY  KEY (user_id)
);