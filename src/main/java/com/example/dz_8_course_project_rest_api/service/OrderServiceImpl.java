package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Order;
import com.example.dz_8_course_project_rest_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
