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
        order.setTotalPrice(orderDto.totalPrice());

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

        return orderRepository.save(order);
    }

    private void calcTotalPrice(Order order) {
        double total = 0.0;

        for (OrderItem item : order.getOrderItens()) {
            double itemTotal = item.getPrice() * item.getQuantity();
            if (item.getDiscount() != null && item.getDiscount() > 0) {
                itemTotal -= itemTotal * (item.getDiscount() / 100.0);
            }
            total += itemTotal;
        }

        order.setTotalPrice(total);
    }
}
