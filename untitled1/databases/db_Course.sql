DROP DATABASE IF EXISTS course ;

CREATE DATABASE IF NOT EXISTS course;

USE course;

CREATE TABLE student_information (
student_id INT(250) NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40),
last_name VARCHAR(40),
birth_date VARCHAR(40),
gender  BOOLEAN ,
TC_address VARCHAR(13),
phone_number VARCHAR(15),
email_address VARCHAR(50),
home_address VARCHAR(100),
Pay_tuition_fees DECIMAL(6.3),
stayed_tuition_fees DECIMAL(6.3),
date_of_registration DATETIME DEFAULT now()
);

CREATE TABLE teacher_information (
teacher_id INT(250) NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40),
last_name VARCHAR(40),
birth_date VARCHAR(40),
gender  BOOLEAN ,
TC_address VARCHAR(13),
phone_number VARCHAR(15),
email_address VARCHAR(50),
home_address VARCHAR(100),
salary DECIMAL(6.3),
date_of_registration DATETIME DEFAULT now()
);

CREATE TABLE lessons_information (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  teacher_id INT NOT NULL,
  start_time TIME,
  end_time TIME,
  PRIMARY KEY (id)
  );
CREATE TABLE school_information (
  school_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  image VARCHAR(100),
  office_address VARCHAR(250),
  teacher_id INT,
  student_id INT,
  date_of_created DATE
);

CREATE TABLE additional_income (
 additional_income_id int not null PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(250),
 expenses decimal(6.3),
 additional_income decimal(6.3),
 date_of_registration DATE
);
CREATE TABLE expenses (
 expenses_id int not null PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(250),
 expenses decimal(6.3),
 date_of_registration DATE
);