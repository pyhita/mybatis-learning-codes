package com.yangtao.controller;

import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employeeMapper.selectEmployees();
    }

}
