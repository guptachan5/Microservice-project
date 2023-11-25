package com.shopanything.com.orderservice.orderservice.service;

import com.shopanything.com.orderservice.orderservice.dto.OrderLineItemDto;
import com.shopanything.com.orderservice.orderservice.dto.OrderRequest;
import com.shopanything.com.orderservice.orderservice.model.Order;
import com.shopanything.com.orderservice.orderservice.model.OrderLineItem;
import com.shopanything.com.orderservice.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItems(getOrderLineItem(orderRequest.getOrderLineItemDtoList()))
                .build();
        orderRepository.save(order);
    }

    private List<OrderLineItem> getOrderLineItem(List<OrderLineItemDto> orderLineItemDtoList) {
        return orderLineItemDtoList.stream().map(this::mapToOrderLineItems).toList();
    }

    private OrderLineItem mapToOrderLineItems(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .skuCode(orderLineItemDto.getSkuCode())
                .price(orderLineItemDto.getPrice())
                .quantity(orderLineItemDto.getQuantity())
                .build();
    }


}
