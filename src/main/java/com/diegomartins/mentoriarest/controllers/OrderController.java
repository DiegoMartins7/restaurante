package com.diegomartins.mentoriarest.controllers;

import com.diegomartins.mentoriarest.models.dtos.OrderDto;
import com.diegomartins.mentoriarest.models.entities.Order;
import com.diegomartins.mentoriarest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable UUID id){
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Delete order");
    }
}
