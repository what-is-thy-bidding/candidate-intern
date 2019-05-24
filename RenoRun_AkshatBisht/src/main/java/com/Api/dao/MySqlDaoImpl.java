package com.Api.dao;
import com.Api.entity.Order;
import com.Api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlDaoImpl implements ProductDao, OrderDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class ProductRowMapper implements RowMapper<Product>{

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product= new Product();
            product.setProduct_id(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getDouble("price"));
            return product;
        }
    }



    @Override
    public Collection<Product> getAllProducts() {
        final String SQL="SELECT * FROM product";
         List<Product> products = jdbcTemplate.query(SQL, new ProductRowMapper());
        return products;
    }

    @Override
    public Product getProductById(int id) {
        final String SQL="SELECT product_id, name,description,price FROM product WHERE product_id=?";
        Product product = jdbcTemplate.queryForObject(SQL, new ProductRowMapper(), id);
        return product;
    }

    @Override
    public void removeProductById(int id) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void insertProductToDb(Product product) {

    }



    private static class OrderRowMapper implements RowMapper<Order>{

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order= new Order();
            order.setProduct_id(resultSet.getInt("product_id"));
            order.setColor(resultSet.getString("color"));
            order.setEmail(resultSet.getString("email"));
            order.setorder_id(resultSet.getInt("order_id"));
            return order;
        }
    }



    @Override
    public Collection<Order> getAllOrders() {
        final String SQL="SELECT * FROM orders";
        List<Order> orders = jdbcTemplate.query(SQL, new OrderRowMapper());
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        final String SQL="SELECT product_id, order_id,color,email FROM orders WHERE order_id=?";
        Order order = jdbcTemplate.queryForObject(SQL, new OrderRowMapper(), id);
        return order;
    }

    @Override
    public void removeOrderById(int id) {
        final String SQL="DELETE FROM orders WHERE order_id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void insertOrderToDb(Order order) {
        final String SQL="INSERT INTO orders (product_id,color,email) VALUES (?,?,?)";
        final int product_id_= order.getProduct_id();
        final String color=order.getColor();
        final String email=order.getEmail();
        jdbcTemplate.update(SQL,new Object[]{product_id_,color,email});
    }
}
