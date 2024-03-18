package com.sajid.service;

import com.sajid.dao.OrderDao;
import com.sajid.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.selectAllOrders();
    }

    public void insertNewOrder(String customer_name, String product, Double transaction, String address) {
        orderDao.insertNewOrder(customer_name,product,transaction,address);
    }
}
