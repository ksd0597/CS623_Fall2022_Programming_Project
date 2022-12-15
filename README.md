# CS623 Fall2022 Programming Project
Course Name: CS623 - Database Management Systems, Fall 2022  
Professor: Dr. Christelle Scharff  
Team - 2  
Team members: Kaushal Dobariya, Varun Patel  
Language: Java, SQL  

## Project Description
We consider the Product, Depot and Stock relations / tables that we already used in homeworks.  

The key of product is #prod (prodid).  
The key of depot is #dep (depid).  
The key of stock is #prod, #dep. #prod and #dep are foreign keys.  
<img src='https://github.com/DV192/CS623_Fall2022_Programming_Project/blob/main/Project%20Schemas%20and%20Instances.jpg' alt='Project Schemas and Instances' />  

A transaction implements the ACID properties. If the code you will provide does not implement the ACID properties, you will get 0 for the question. 

Show and explain how you implemented a transaction in the video. 

This is the list of transactions to be implemented:

•	Group 1/7 – The product p1 is deleted from Product and Stock.  
•	Group 2/8 – The depot d1 is deleted from Depot and Stock.  
•	Group 3/9 – The product p1 changes its name to pp1 in Product and Stock.  
•	Group 4/10 – The depot d1 changes its name to dd1 in Depot and Stock.  
•	Group 5/11 – We add a product (p100, cd, 5) in Product and (p100, d2, 50) in Stock.  
•	Group 6/12 – We add a depot (d100, Chicago, 100) in Depot and (p1, d100, 100) in Stock.  

## Screenshot of tables and data
<img src='https://github.com/DV192/CS623_Fall2022_Programming_Project/blob/main/MySQL%20Project%20Tables.png' alt='Screenshot of tables and data' />
