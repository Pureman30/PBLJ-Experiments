# Student Attendance Portal (JSP + Servlet + JDBC)

This project allows users to submit student attendance using a JSP form and store data in MySQL via Servlet.

## Database Setup
CREATE DATABASE school;
USE school;

CREATE TABLE attendance (
  StudentID INT,
  Date VARCHAR(20),
  Status VARCHAR(10)
);

