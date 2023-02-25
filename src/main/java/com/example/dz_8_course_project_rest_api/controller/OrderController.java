package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Order;
import com.example.dz_8_course_project_rest_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order>getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return orderService.saveOrUpdateOrder(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return orderService.saveOrUpdateOrder(order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable int id){
        String result;

        if(orderService.getOrderById(id)!=null){
            orderService.deleteOrderById(id);
            if(orderService.getOrderById(id)==null){
                result = "Order was deleted";
            }else {
                result = "Order was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
