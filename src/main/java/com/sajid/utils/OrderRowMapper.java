package com.sajid.utils;

import com.sajid.entity.Order;
import com.sajid.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String customer_name = rs.getString("customer_name");
        String product = rs.getString("product");
        Double transaction =rs.getDouble("transaction");
        String address = rs.getString("address");

        return new Order(id, customer_name, address,product,transaction);
    }
}
