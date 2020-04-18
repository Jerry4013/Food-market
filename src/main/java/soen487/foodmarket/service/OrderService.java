package soen487.foodmarket.service;

import soen487.foodmarket.models.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    List<OrderDTO> findOrdersByBuyerId(Integer buyerId);

    OrderDTO cancel(String orderId);

    OrderDTO finish(String orderId);

    OrderDTO pay(String orderId);

    List<OrderDTO> findOrdersBySellerId(Integer sellerId);

    OrderDTO findByOrderId(String orderId);

}
