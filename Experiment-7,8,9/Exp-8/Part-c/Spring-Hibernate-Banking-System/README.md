# Spring + Hibernate Transaction Management

This project demonstrates a simple banking system where money is transferred between accounts using @Transactional to ensure rollback on failure.

## Database Setup
CREATE DATABASE bank;
USE bank;

CREATE TABLE account (
  accNo INT PRIMARY KEY,
  name VARCHAR(50),
  balance INT
);

CREATE TABLE bank_transaction (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fromAcc INT,
  toAcc INT,
  amount INT
);

