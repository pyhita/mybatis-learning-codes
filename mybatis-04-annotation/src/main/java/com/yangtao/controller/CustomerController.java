package com.yangtao.controller;

import com.yangtao.entity.Customer;
import com.yangtao.mapper.CustomerMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerMapper.selectAllCustomers();
    }

}
