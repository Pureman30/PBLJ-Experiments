# Employee Record Servlet with JDBC

This project displays employee data using Java Servlets and JDBC.

## Features:
- Shows all employee records in an HTML table
- Search employee by EmpID
- Uses MySQL database

## Database Setup
CREATE DATABASE company;
USE company;

CREATE TABLE employee (
  EmpID INT PRIMARY KEY,
  Name VARCHAR(50),
  Salary INT
);

INSERT INTO employee VALUES
(101, 'Aayush', 40000),
(102, 'Neha', 45000),
(103, 'Rohan', 55000);
