package com.yangtao.controller;

import com.yangtao.entity.Order;
import com.yangtao.mapper.OrderMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */
@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return orderMapper.findOrders();
    }
}
