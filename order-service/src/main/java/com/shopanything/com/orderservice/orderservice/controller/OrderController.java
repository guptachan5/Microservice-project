package com.shopanything.com.orderservice.orderservice.controller;

import com.shopanything.com.orderservice.orderservice.dto.OrderRequest;
import com.shopanything.com.orderservice.orderservice.model.Order;
import com.shopanything.com.orderservice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placedOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order is placed successfully..";
    }


}
