CREATE TABLE IF NOT EXISTS dictionary.word (
  no int NOT NULL AUTO_INCREMENT,
  name varchar(255),
  def text,
  category text,
  PRIMARY KEY (no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
