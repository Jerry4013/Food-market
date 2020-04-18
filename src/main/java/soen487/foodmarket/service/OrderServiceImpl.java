package soen487.foodmarket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soen487.foodmarket.dataobject.OrderItem;
import soen487.foodmarket.dataobject.OrderMaster;
import soen487.foodmarket.dataobject.ProductInfo;
import soen487.foodmarket.enums.OrderStatus;
import soen487.foodmarket.enums.PayStatus;
import soen487.foodmarket.error.BusinessException;
import soen487.foodmarket.error.EmBusinessError;
import soen487.foodmarket.models.Cart;
import soen487.foodmarket.models.OrderDTO;
import soen487.foodmarket.repository.OrderItemRepository;
import soen487.foodmarket.repository.OrderMasterRepository;
import soen487.foodmarket.repository.ProductRepository;
import soen487.foodmarket.utils.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderMasterRepository orderMasterRepository;

    private final OrderItemRepository orderItemRepository;

    private final ProductRepository productRepository;

    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderMasterRepository orderMasterRepository,
                            OrderItemRepository orderItemRepository, ProductRepository productRepository, ProductService productService) {
        this.orderMasterRepository = orderMasterRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderMasterId = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItem orderItem : orderDTO.getOrderItemList()) {
            ProductInfo productInfo = productRepository.findById(orderItem.getProductId()).orElse(null);
            if (productInfo == null) {
                log.error("[create order] product does not exist. productId={}", orderItem.getProductId());
                throw new BusinessException(EmBusinessError.PRODUCT_NOT_EXIST);
            }
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal((orderItem.getQuantity())))
                    .add(orderAmount);
            orderItem.setItemId(KeyUtil.genUniqueKey());
            orderItem.setOrderId(orderMasterId);
            OrderItem save = orderItemRepository.save(orderItem);
            orderItemList.add(save);
        }
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderMasterId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        List<Cart> cartList = orderDTO.getOrderItemList().stream().map(e ->
                new Cart(e.getProductId(), e.getQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartList);

        orderDTO.setOrderItemList(orderItemList);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findOrdersByBuyerId(Integer buyerId) {
        return null;
    }

    @Override
    public OrderDTO cancel(String orderId) {
        return null;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }

    @Override
    public OrderDTO pay(String orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> findOrdersBySellerId(Integer sellerId) {
        return null;
    }

    @Override
    public OrderDTO findByOrderId(String orderId) {
        return null;
    }
}
