0.CREATE DATABASE lesson;	




1. items
CREATE TABLE items (
  itemId SERIAL PRIMARY KEY,
  itemName VARCHAR(30) NOT NULL UNIQUE,
  price INTEGER NOT NULL );
  
  
2. slips
CREATE TABLE slips (
  id VARCHAR(20) NOT NULL,
  itemId INTEGER NOT NULL REFERENCES items(itemId),
  number INTEGER NOT NULL,
 PRIMARY KEY (id, itemId) );

 
 3. slips_date
CREATE TABLE slips_date (
  id VARCHAR(20) PRIMARY KEY,
  date TIMESTAMP,
  FOREIGN KEY (id) REFERENCES slips(id) );

