package com.assessment.second;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagement {

    // A class to represent a product
    static class Product {
        private Long productId;
        private String name;
        private int stock;

        public Product(Long productId, String name, int stock) {
            this.productId = productId;
            this.name = name;
            this.stock = stock;
        }

        public Long getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public int getStock() {
            return stock;
        }

        public void reduceStock(int quantity) {
            if (quantity > stock) {
                throw new IllegalArgumentException("Insufficient stock for product: " + name);
            }
            stock -= quantity;
        }

        public void restock(int quantity) {
            stock += quantity;
        }
    }

    // Method to process sales orders
    public static void processOrders(List<Product> products, Map<Long, Integer> salesOrders) {
        for (Map.Entry<Long, Integer> order : salesOrders.entrySet()) {
            Long productId = order.getKey();
            int orderedQuantity = order.getValue();
            Product product = findProductById(products, productId);

            if (product != null) {
                try {
                    product.reduceStock(orderedQuantity);
                    if (product.getStock() < 10) {
                        alertRestock(product);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Product not found: " + productId);
            }
        }
    }

    // Method to restock items
    public static void restockItems(List<Product> products, Map<Long, Integer> restockOrders) {
        for (Map.Entry<Long, Integer> restock : restockOrders.entrySet()) {
            Long productId = restock.getKey();
            int quantityToRestock = restock.getValue();
            Product product = findProductById(products, productId);

            if (product != null) {
                product.restock(quantityToRestock);
                System.out.println("Restocked " + quantityToRestock + " units of " + product.getName());
            } else {
                System.out.println("Product not found for restock: " + productId);
            }
        }
    }

    // Helper method to find a product by ID
    private static Product findProductById(List<Product> products, Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Method to alert restock
    private static void alertRestock(Product product) {
        System.out.println("Alert: Stock for " + product.getName() + " is below threshold. Current stock: " + product.getStock());
    }

    // Example usage
    public static void main(String[] args) {
        // Sample products
        Product product1 = new Product(1L, "Book A", 20);
        Product product2 = new Product(2L, "Book B", 5);
        Product product3 = new Product(3L, "Book C", 15);

        List<Product> products = List.of(product1, product2, product3);

        // Sample sales orders
        Map<Long, Integer> salesOrders = new HashMap<>();
        salesOrders.put(1L, 5); // Order 5 units of Book A
        salesOrders.put(2L, 6); // Order 6 units of Book B (should trigger alert)
        salesOrders.put(4L, 2); // Invalid product ID

        // Process orders
        processOrders(products, salesOrders);

        // Sample restock orders
        Map<Long, Integer> restockOrders = new HashMap<>();
        restockOrders.put(2L, 10); // Restock 10 units of Book B

        // Restock items
        restockItems(products, restockOrders);
    }
}
