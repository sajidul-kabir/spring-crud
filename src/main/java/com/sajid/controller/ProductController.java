package com.sajid.controller;

import com.sajid.entity.Product;
import com.sajid.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


//     public ProductController(ProductService productService){
//        this.productService=productService;
//    }


    @RequestMapping("/products")
    public String listAllProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "product/product-list.jsp";
    }
}
