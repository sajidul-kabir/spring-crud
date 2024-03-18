package com.sajid.config;

import com.sajid.entity.Order;
import com.sajid.entity.Product;
import com.sajid.utils.OrderRowMapper;
import com.sajid.utils.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateConfig {

    private final Environment environment;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String jdbcURL = environment.getProperty("jdbc.url");
        String jdbcUsername = environment.getProperty("jdbc.username");
        String jdbcPassword = environment.getProperty("jdbc.password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public RowMapper<Product> productRowMapper() {
        return new ProductRowMapper();
    }
    @Bean
    public RowMapper<Order> orderRowMapper() {
        return new OrderRowMapper();
    }
}
