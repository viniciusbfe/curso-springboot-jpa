package com.vinibf.cursospring.resources;

import com.vinibf.cursospring.entities.Order;
import com.vinibf.cursospring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Order findByID(@PathVariable int id){
        return orderService.findByID(id);
    }
}
