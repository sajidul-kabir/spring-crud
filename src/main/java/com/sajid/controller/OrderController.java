package com.sajid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @RequestMapping("/orders")
    public String listAllorders(){
        return  "/q.jsp";
    }
}