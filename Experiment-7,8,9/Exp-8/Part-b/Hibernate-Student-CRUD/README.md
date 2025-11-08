# Hibernate Student CRUD

This project performs CRUD operations on Student table using Hibernate ORM and MySQL.

## Database Setup
CREATE DATABASE school;
USE school;

CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  marks INT
);
