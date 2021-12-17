DROP TABLE IF EXISTS billionaires;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  age NUMBER(10) NOT NULL,
);

INSERT INTO user (name, name) VALUES
  ('Didier', 15);
