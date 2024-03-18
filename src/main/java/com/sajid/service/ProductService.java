package com.sajid.service;

import com.sajid.dao.ProductDao;
import com.sajid.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductDao productDao;

    public List<Product> getAllProducts() {
        List<Product> products = productDao.selectAllProducts();
        log.info("Retrieved {} orders from DAO", products.size());
        return products;
    }

    public void insertNewProduct(String name, Double price) {
        try {
            productDao.insertNewProduct(name, price);
            log.info("New product inserted successfully - name: {}, price: {}", name, price);
        } catch (Exception e) {
            log.error("Error inserting new product - name: {}, price: {}", name, price, e);
        }
    }

    public Product getExistingProduct(Integer id) {
        Product existingProduct = productDao.selectProductById(id);
        log.info("Fetched Exisitng Product: {}", existingProduct.toString());
        return existingProduct;
    }

    public Product updateExistingProduct(Integer id, String name, Double price) {
        Product existingProduct = null;
        try {
            existingProduct = productDao.updateproduct(id, name, price);
            log.info("Product updated successfully - id: {}, name: {}, price: {}", id, name, price);
        } catch (Exception e) {
            log.error("Error inserting new product - id: {}, name: {}, price: {}", id, name, price, e);
        }

        return existingProduct;
    }

    public void deleteProduct(Integer id) {
        try {
            productDao.deleteProductById(id);
            log.info("Product id: {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error deleting id: {} product", id);
        }
    }
}
