# Book Sales SQL Queries

## Overview
This package contains SQL queries for analyzing book sales data from an e-commerce application. The queries aim to provide insights into customer purchasing behavior, revenue generation by authors, and frequently ordered books.

## Queries
1. **Top 5 Customers**: Retrieves the top 5 customers who have purchased the most books (by total quantity) over the last year.
2. **Revenue by Author**: Calculates the total revenue generated from book sales by each author.
3. **Frequently Ordered Books**: Retrieves all books that have been ordered more than 10 times, along with the total quantity ordered for each book.

## SQL Queries
The SQL queries are located in the `book_sales_queries.sql` file.

## Database Schema Assumptions
- **Customers**: Contains customer information.
    - `customer_id` (Primary Key)
    - `name`

- **Books**: Contains book information.
    - `book_id` (Primary Key)
    - `title`
    - `author_id` (Foreign Key)

- **Authors**: Contains author information.
    - `author_id` (Primary Key)
    - `name`

- **Orders**: Contains order information.
    - `order_id` (Primary Key)
    - `customer_id` (Foreign Key)
    - `order_date`

- **OrderDetails**: Contains details about which books were ordered and in what quantity.
    - `order_detail_id` (Primary Key)
    - `order_id` (Foreign Key)
    - `book_id` (Foreign Key)
    - `quantity`

## Running the Queries
1. Connect to your database using a SQL client (e.g., MySQL Workbench).
2. Execute the queries in the provided `book_sales_queries.sql` file to retrieve insights.

## Performance Considerations
- The queries have been optimized for performance with appropriate indexing strategies suggested in the documentation.
- Make sure to create the necessary indexes to ensure efficient execution of the queries.


