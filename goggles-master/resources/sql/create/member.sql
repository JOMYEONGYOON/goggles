CREATE TABLE IF NOT EXISTS dictionary.member(
  no int NOT NULL AUTO_INCREMENT,
  id varchar(60) NOT NULL,
  name text  NOT NULL,
  phone text  NOT NULL,
  birth text  NOT NULL,
  email text  NOT NULL,
  gender text  NOT NULL,
  password text  NOT NULL,
  etc text,
  PRIMARY KEY (no),
  UNIQUE KEY id_UNIQUE (id)
)