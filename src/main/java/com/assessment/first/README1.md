# Simplified E-Commerce System

## Overview
This package implements a simplified e-commerce system designed to handle users, products, orders, and payments. The system supports multiple users with the ability to create, view, and manage orders. Each order can contain multiple products, and payments can be made for each order, which can have different statuses (e.g., pending, completed, shipped).

## Class Diagram
A class diagram outlining the relationships between `User`, `Product`, `Order`, and `Payment` has been created. You can find the diagram in the project package com.assessment.first.classdiagram with file name as `classdiagram.png`.

## Classes
The following classes have been implemented as part of the system:

1. **User**
    - Attributes:
        - `userId` (Long): Unique identifier for the user.
        - `name` (String): The name of the user.
        - `email` (String): The email of the user.
        - `orders` (List<Order>): A list of orders associated with the user.
    - Relationships: One-to-Many with `Order`.

2. **Product**
    - Attributes:
        - `productId` (Long): Unique identifier for the product.
        - `name` (String): The name of the product.
        - `price` (Double): The price of the product.
        - `stock` (Integer): The available stock for the product.
    - Relationships: None.

3. **Order**
    - Attributes:
        - `id` (Long): Unique identifier for the order.
        - `status` (String): The status of the order (e.g., pending, completed).
        - `user` (User): The user who placed the order.
        - `products` (List<Product>): A list of products included in the order.
    - Relationships: Many-to-One with `User`, One-to-Many with `Product`.

4. **Payment**
    - Attributes:
        - `paymentId` (Long): Unique identifier for the payment.
        - `amount` (Double): The total amount paid.
        - `paymentDate` (Date): The date when the payment was made.
        - `order` (Order): The order associated with the payment.
    - Relationships: One-to-One with `Order`.

## How to Run the Project
To run the project, follow these steps:

1. **Set Up the Project**:
    - Import the project into IntelliJ IDEA.
    - Ensure that the project structure is correctly set up.

2. **Compile the Code**:
    - Build the project to ensure that all classes compile without errors.

3. **Create a Main Class** (optional):
    - You may create a `Main` class to instantiate the `User`, `Product`, `Order`, and `Payment` classes to test their functionality.

4. **Run the Application**:
    - Run the application from the `Main` class or any class that you create to demonstrate the functionality of the system.

## Assumptions
- The system does not include a database connection; it is designed for demonstration purposes only.
- The `User`, `Order`, `Product`, and `Payment` classes do not include any business logic for creating, viewing, or managing orders, as this is beyond the scope of the assessment.
- Error handling and input validation are not implemented in this assessment.

