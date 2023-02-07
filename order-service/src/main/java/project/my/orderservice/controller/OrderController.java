package project.my.orderservice.controller;

import org.springframework.web.bind.annotation.*;
import project.my.orderservice.service.OrderService;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{productId}")
    public String createNewOrder(@PathVariable String productId) {
        return orderService.createNewOrder(productId);
    }
}
