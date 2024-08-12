package com.diegomartins.mentoriarest.service;

import com.diegomartins.mentoriarest.models.dtos.OrderDto;
import com.diegomartins.mentoriarest.models.entities.Order;
import com.diegomartins.mentoriarest.models.entities.OrderItem;
import com.diegomartins.mentoriarest.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order create(OrderDto orderDto) {
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderItens(orderDto.orderItens());

        calcTotalPrice(order);

        return orderRepository.save(order);
    }

    public Order findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteOrder(UUID id) {
        Order order = findById(id);
        orderRepository.delete(order);
    }

    public Order updateOrder(UUID id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        order.setOrderItens(orderDto.orderItens());

        calcTotalPrice(order);

        return orderRepository.save(order);
    }

    private void calcTotalPrice(OrderItem order) {
        double total = order.getOrderItens().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();

        if (order.getDiscount() != null && order.getDiscount() > 0) {
            total -= total * (order.getDiscount() / 100);
        }

        order.setTotalPrice(total);

    }
}
