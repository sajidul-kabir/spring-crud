package com.sajid.dao;


import com.sajid.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Product> productRowMapper;

    public List<Product> selectAllProducts() {
        log.info("Selecting all products from the database");
        final String SELECT_ALL_PRODUCTS = "select * from product";
        List<Product> products = jdbcTemplate.query(SELECT_ALL_PRODUCTS,productRowMapper);
        log.info("Retrieved {} products from the database", products.size());
        return products;
    }
    public void insertNewProduct(String name, Double price) {
        log.info("Inserting New product in Database");
        final String INSERT_ProductS_SQL = "INSERT INTO product" + "  (name, price) VALUES "
                + " (?, ?);";
        jdbcTemplate.update(INSERT_ProductS_SQL,name,price);

        log.info("Succesfully inserted");
    }

    public Product selectProductById(Integer id) {
        log.info("Selecting Product By Id");
        final String SELECT_Product_BY_ID = "select id,name,price from product where id ="+id;
        return jdbcTemplate.queryForObject(SELECT_Product_BY_ID,productRowMapper);
    }

    public Product updateproduct(Integer id, String name, Double price) {
        log.info("Updating Product by id");
        final String UPDATE_ProductS_SQL = "update product set name = ?,price= ? where id=?";
         jdbcTemplate.update(UPDATE_ProductS_SQL,name,price,id);

        return this.selectProductById(id);
    }

    public void deleteProductById(Integer id) {
        log.info("Deleting Product id: {} from DB", id);
        final String DELETE_ProductS_SQL = "delete from product where id = ?";
        jdbcTemplate.update(DELETE_ProductS_SQL,id);
    }

}
