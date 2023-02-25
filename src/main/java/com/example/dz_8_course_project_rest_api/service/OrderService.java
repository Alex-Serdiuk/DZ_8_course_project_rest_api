package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Order;
import com.example.dz_8_course_project_rest_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    List<Order>getAllOrders();
    Order saveOrUpdateOrder(Order order);

    Order getOrderById(int id);

    void deleteOrderById(int id);
}
