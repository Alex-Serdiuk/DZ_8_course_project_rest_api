package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Order;
import com.example.dz_8_course_project_rest_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order>getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){
        return orderService.saveOrUpdateOrder(order);
    }

    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order order){
        return orderService.saveOrUpdateOrder(order);
    }

}
