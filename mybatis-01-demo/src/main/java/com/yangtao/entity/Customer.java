package com.yangtao.entity;

import java.util.List;
import lombok.Data;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Data
public class Customer {

    private Integer customerId;
    private String customerName;
    // 一对多
    private List<Order> orders;

}
