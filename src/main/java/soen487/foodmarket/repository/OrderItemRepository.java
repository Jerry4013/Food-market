package soen487.foodmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soen487.foodmarket.dataobject.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
}
