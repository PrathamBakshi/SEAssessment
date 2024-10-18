# Inventory Management System

## Overview
This package implements an inventory management system for a warehouse. The system is designed to track stock levels of products and manage restocking based on incoming sales orders. It consists of two primary functions:

1. `processOrders()`: Reduces stock levels based on sales orders and triggers alerts if stock falls below a specified threshold.
2. `restockItems()`: Updates stock levels for products that need to be restocked.

## Key Features
- Tracks stock levels for multiple products.
- Processes incoming sales orders and updates stock levels accordingly.
- Alerts for restocking items if stock drops below a defined threshold (e.g., 10 units).
- Handles errors for invalid inputs, such as attempting to process an order for a product that is out of stock.

## Code Implementation
The main components of the system include:

- **Product Class**: Represents a product with attributes for product ID, name, and stock level, and methods to manage stock.
- **processOrders() Method**: Processes sales orders by reducing stock levels and triggers alerts for restocking when necessary.
- **restockItems() Method**: Updates the stock levels for products that need restocking based on incoming requests.
- **Error Handling**: Includes checks for insufficient stock and non-existent products.

## How to Run the Project
To run the project, follow these steps:

1. **Set Up the Project**:
    - Import the project into IntelliJ IDEA or any Java IDE of your choice.

2. **Compile the Code**:
    - Ensure that all classes compile without errors.

3. **Run the Application**:
    - Execute the `main` method in the `InventoryManagement` class to see the functionality in action.
    - You can modify the sample products and sales orders within the `main` method to test different scenarios.

## Example Usage
In the `main` method, the system initializes a list of sample products and processes a set of sales orders. The output will show the current stock levels, alerts for restocking, and confirmations for any restocked items.

## Assumptions
- The system assumes that the stock threshold for triggering a restock alert is set at 10 units.
- The implementation does not include persistent storage; it operates on in-memory data for demonstration purposes.
- The error handling provided covers basic scenarios such as insufficient stock and invalid product IDs.

