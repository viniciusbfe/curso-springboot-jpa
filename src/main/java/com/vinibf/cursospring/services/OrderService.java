package com.vinibf.cursospring.services;

import com.vinibf.cursospring.entities.Order;
import com.vinibf.cursospring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findByID(int id){
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found."));
    }
}
