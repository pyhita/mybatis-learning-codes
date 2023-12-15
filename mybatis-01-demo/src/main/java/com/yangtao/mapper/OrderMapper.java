package com.yangtao.mapper;

import com.yangtao.entity.Order;
import java.util.List;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
public interface OrderMapper {

    List<Order> selectOrderWithCustomer();
}
