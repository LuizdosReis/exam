DROP TABLE IF EXISTS exams;

CREATE TABLE exams
(
  code     VARCHAR(50),
  source   VARCHAR(50)  NOT NULL,
  code_list_code VARCHAR(256) NOT NULL,
  display_value VARCHAR(50) NOT NULL,
  long_description VARCHAR(256),
  from_date TIMESTAMP NOT NULL,
  to_date TIMESTAMP,
  sorting_priority int,
  CONSTRAINT exams_pk PRIMARY KEY (code)
);
