-- Query 1: Retrieve the Top 5 Customers Who Have Purchased the Most Books Over the Last Year
SELECT c.customer_id, c.name, SUM(od.quantity) AS total_quantity
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN OrderDetails od ON o.order_id = od.order_id
WHERE o.order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
GROUP BY c.customer_id, c.name
ORDER BY total_quantity DESC
LIMIT 5;

-- Query 2: Calculate the Total Revenue Generated from Book Sales by Each Author
SELECT a.author_id, a.name, SUM(od.quantity * b.price) AS total_revenue
FROM Authors a
JOIN Books b ON a.author_id = b.author_id
JOIN OrderDetails od ON b.book_id = od.book_id
GROUP BY a.author_id, a.name;

-- Query 3: Retrieve All Books That Have Been Ordered More Than 10 Times
SELECT b.book_id, b.title, SUM(od.quantity) AS total_quantity_ordered
FROM Books b
JOIN OrderDetails od ON b.book_id = od.book_id
GROUP BY b.book_id, b.title
HAVING SUM(od.quantity) > 10;
