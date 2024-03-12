package com.sajid.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class JdbcConnection {
    @Autowired
    private Environment env;

    private static JdbcConnection instance;

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = env.getProperty("jdbcURL");
            String jdbcUsername = env.getProperty("jdbcUsername");
            String jdbcPassword = env.getProperty("jdbcPassword");

            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}