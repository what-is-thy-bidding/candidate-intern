# Details
1. The project is coded in Java Spring using Intelij Ide.
2. The required functionality of the API is achieved, with
   an additional getOrder(GET/orders/:id) and 
   deleteOrderByOrderId(DELETE/orders/:id).
3. Additional Function headers are added for future updations.
4. There is @ManyToOne relation used to @JoinColumn 
    merge the "product_id" in both the "orders" and "products" tables.

# Instructions
1. Open pom.xml with Intelij or Eclipse
2. Run Main.java
3. Open browser on http://localhost:8080

# Functionalities
1. getAllProducts(GET/products) : http://localhost:8080/products
2. getProduct(GET/products/:id) : http://localhost:8080/products/1
3. getAllOrders (GET /orders)   : http://localhost:8080/orders
4. postOrder (POST /orders)   : http://localhost:8080/orders
