package project.my.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.my.orderservice.client.ProductServiceClient;
import project.my.orderservice.model.Order;
import project.my.orderservice.repository.OrderRepository;

@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    private final ProductServiceClient client;

    public OrderService(OrderRepository orderRepository, ProductServiceClient client) {
        this.orderRepository = orderRepository;
        this.client = client;
    }

    public String createNewOrder(String productId) {
        log.info("Trying to create new order for product with id {}", productId);
        boolean result = client.isInStock(productId);
        log.info("Product {} in stock is {}", productId, result);

        if (result) {
            Order order = new Order();
            order.setActive(true);
            order.setTotalPrice(0);
            log.info("Order total price is 0, functionality is not allowed yet");
            order = orderRepository.save(order);
            log.info("Order {} was created successfully", order.getId());
            return "Order is created successfully";
        }

        return "Order cannot be created, product is out of stock";
    }
}
