package project.my.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.my.orderservice.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
