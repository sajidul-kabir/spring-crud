package com.sajid.service;

import com.sajid.dao.ProductDao;
import com.sajid.entity.Product;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private ProductDao productDao;


//    public ProductService(ProductDao productDao){
//        this.productDao=productDao;
//    }
    public List<Product> getAllProducts() {
        return productDao.selectAllProducts();
    }
}
