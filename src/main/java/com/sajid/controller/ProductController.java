package com.sajid.controller;

import com.sajid.dto.ProductDto;
import com.sajid.entity.Product;
import com.sajid.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public String listAllProducts(Model model) {
        List<Product> listProducts = productService.getAllProducts();
        log.info("Retrieved {} products", listProducts.size());
        model.addAttribute("listProducts", listProducts);
        return "product/product-list";
    }

    @RequestMapping( method = RequestMethod.POST)
    public void insertProduct(@RequestBody ProductDto productDto) {

        try {
            productService.insertNewProduct(productDto.getName(), productDto.getPrice());
            log.info("New product inserted successfully - name: {}, price: {}", productDto.getName(), productDto.getPrice());
        } catch (Exception e) {
            log.error("Error inserting new product -name: {}, price: {}", productDto.getName(), productDto.getPrice(), e);
        }

    }
    @RequestMapping(method = RequestMethod.PATCH)
    public void updateProduct(@RequestBody ProductDto productDto) {
        try {
            productService.updateExistingProduct(productDto.getId(),productDto.getName(), productDto.getPrice());
            log.info("Product updated successfully - id: {}, name: {}, price: {}", productDto.getId(),productDto.getName(), productDto.getPrice());
        } catch (Exception e) {
            log.error("Error updating product - id: {}, name: {}, price: {}", productDto.getId(),productDto.getName(), productDto.getPrice(), e);
        }

    }

    @RequestMapping( method = RequestMethod.DELETE)
    public void deleteProduct(@RequestParam String id) {
        productService.deleteProduct(Integer.valueOf(id));
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.GET)
    public String showEditForm(@RequestParam String id, Model model) {
        Product existingProduct = productService.getExistingProduct(Integer.valueOf(id));
        log.info("Fetched existing product - id: {}, name: {}, price: {}", existingProduct.getId(), existingProduct.getName(), existingProduct.getPrice());
        model.addAttribute("product", existingProduct);
        return "product/new-product";
    }


    @RequestMapping(value = "/new-product", method = RequestMethod.GET)
    public String newproductForm() {
        log.info("Accessing New Product form");
        return "product/new-product";
    }



}
