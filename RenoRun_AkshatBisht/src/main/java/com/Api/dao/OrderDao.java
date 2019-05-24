package com.Api.dao;
import com.Api.entity.Order;
import java.util.Collection;

public interface OrderDao {

    Collection<Order> getAllOrders();

    Order getOrderById(int id);

    void removeOrderById(int id);

    void updateOrder(Order order);

    void insertOrderToDb(Order order);
}
