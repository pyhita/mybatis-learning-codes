package com.yangtao.controller;

import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@RestController
@Slf4j
public class EmployeeController {


    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeMapper.selectEmployees();
        log.info("employees: {}", employees);
        return employees;
    }

//    @GetMapping("/employee")
//    public Employee getEmployee(@RequestParam(value = "empId") String empId) {
//        log.info("empId: {}", empId);
//        return employeeMapper.selectEmployeeById(empId);
//    }
//
//    @GetMapping("byExample")
//    public List<Employee> getEmployeesByExample(Employee employee) {
//        log.info("employee: {}", employee);
//        return employeeMapper.findAllByExample(employee);
//    }
//
//    @GetMapping("byExample2")
//    public List<Employee> getEmployeesByExample2(Employee employee) {
//        log.info("employee: {}", employee);
//        return employeeMapper.findAllByExample2(employee);
//    }
//
//    @GetMapping("byId")
//    public Employee getEmployeesById(Integer empId) {
//        log.info("empId: {}", empId);
//        return employeeMapper.findEmpById(empId);
//    }
//
//    @GetMapping("byName")
//    public Employee getEmployeesByName(String empName) {
//        log.info("empName: {}", empName);
//        return employeeMapper.findEmpByName(empName);
//    }
//
//    @GetMapping("byIdAndName")
//    public Employee getEmployeesByIdAndName(String empId, String empName) {
//        log.info("empId: {}, empName: {}", empId, empName);
//        return employeeMapper.findEmpByIdAndName(empId, empName);
//    }

}
