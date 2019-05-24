package com.Api.service;

import com.Api.dao.OrderDao;
import com.Api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {
    @Autowired
    @Qualifier("mysql")
    private OrderDao orderDao;
    public Collection<Order> getAllOrders(){return this.orderDao.getAllOrders();}

    public Order getOrderById(int id){return this.orderDao.getOrderById(id);}


    public void removeOrderById(int id) {
        this.orderDao.removeOrderById(id);
    }

    public void updateOrder(Order order){
        this.orderDao.updateOrder(order);
    }

    public void insertOrder(Order order) { this.orderDao.insertOrderToDb(order);}
}
