SHOW DATABASES ;
CREATE DATABASE exercise;
USE exercise;

DROP TABLE IF EXISTS exercise.user;
CREATE TABLE exercise.user(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(255),
  password VARCHAR(255),
  role VARCHAR(255) DEFAULT 'student'
);

INSERT INTO exercise.user VALUES (null,'teacher','123','teacher' );
INSERT INTO exercise.user VALUES (NULL,'jiaowu','123','jiaowu');

TRUNCATE TABLE exercise.user;

SELECT *
FROM exercise.user;

DROP TABLE IF EXISTS exercise.choice_question;
CREATE TABLE choice_question(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  question VARCHAR(2048),
  options VARCHAR(2048),
  answer VARCHAR(2048)
);

SELECT *
FROM exercise.choice_question;

DROP TABLE IF EXISTS exercise.student;
CREATE TABLE student(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  sno INT(11) UNSIGNED UNIQUE ,
  name VARCHAR(255),
  mark INT(3)
);