package com.sajid.dao;

import com.sajid.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Order> orderRowMapper;

    public List<Order> selectAllOrders() {
            final String SELECT_ALL_ORDERS = "select * from orders";
            log.info("Selecting all orders from the database");
            List<Order> orders = jdbcTemplate.query(SELECT_ALL_ORDERS,orderRowMapper);
            log.info("Retrieved {} orders from the database", orders.size());

            return orders;
    }

    public void insertNewOrder(String customer_name, String product, Double transaction, String address) {
        final String INSERT_Orders_SQL = "INSERT INTO orders" + "  (customer_name,product,transaction,address) VALUES "
                + " (?, ?,?,?);";
        log.info("Inserting order into the database");
        jdbcTemplate.update(INSERT_Orders_SQL,customer_name,product,transaction,address);


    }
}
