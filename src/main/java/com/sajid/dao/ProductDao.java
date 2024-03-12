package com.sajid.dao;

import com.sajid.config.JdbcConnection;
import com.sajid.entity.Product;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
   private  JdbcConnection jdbcConnection;

//    @Autowired
//   public ProductDao(JdbcConnection jdbcConnection) {
//        this.jdbcConnection=jdbcConnection;
//    }
    public List<Product> selectAllProducts() {
        final String SELECT_ALL_PRODUCTS = "select * from product";
        List<Product> Products = new ArrayList<>();

        try (Connection connection = jdbcConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (((ResultSet) rs).next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                Products.add(new Product(id,name,price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return Products;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
