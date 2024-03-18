package com.sajid.controller;

import com.sajid.dto.OrderDto;
import com.sajid.entity.Order;
import com.sajid.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

     private final OrderService orderService;

    @RequestMapping
    public String listAllorders(Model model){
      List<Order> orders= orderService.getAllOrders();
        log.info("Retrieved {} orders", orders.size());
      model.addAttribute("listOrders",orders);
      return "order/order-list";
    }
    @RequestMapping( method = RequestMethod.POST)
    public void insetNewOrder(@RequestBody OrderDto orderDto){
        orderService.insertNewOrder(orderDto.getCustomer_name(),orderDto.getProduct(),orderDto.getTransaction(),orderDto.getAddress());
    }

    @RequestMapping(value = "/new-order", method = RequestMethod.GET)
    public String newOrderForm(){
        return "order/new-order";
    }

}
