package com.yangtao.controller;

import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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



    @GetMapping("byName")
    public Employee getEmployeesByName(String empName) {
        log.info("empName: {}", empName);
        return employeeMapper.findEmpByName(empName);
    }

    @GetMapping("byIdAndName")
    public Employee getEmployeesByIdAndName(String empId, String empName) {
        log.info("empId: {}, empName: {}", empId, empName);
        return employeeMapper.findEmpByIdAndName(empId, empName);
    }

        @GetMapping("byExample")
    public List<Employee> getEmployeesByExample(Employee employee) {
        log.info("employee: {}", employee);
        return employeeMapper.findAllByExample(employee);
    }

    // 测试传参方式
    @GetMapping("byExample2")
    public List<Employee> getEmployeesByExample2(Employee employee) {
        log.info("employee: {}", employee);
        return employeeMapper.findAllByExample2(employee);
    }

    @PostMapping("/insertEmp")
    public Integer insert(@RequestBody Employee employee) {
        employeeMapper.insert(employee);

        return employee.getEmpId();
    }

    // 测试动态sql
    @GetMapping("/byCondition")
    public List<Employee> selectByCondition(Employee employee) {

        return employeeMapper.selectEmployeeByCondition(employee);
    }

    @GetMapping("/byConditionByTrim")
    public List<Employee> selectByConditionByTrim(Employee employee) {

        return employeeMapper.selectEmployeeByConditionByTrim(employee);
    }

    @GetMapping("/byConditionByChoose")
    public List<Employee> selectEmployeeByConditionByChoose(Employee employee) {

        return employeeMapper.selectEmployeeByConditionByChoose(employee);
    }

    @GetMapping("/byConditionUseForeach")
    public List<Employee> selectEmployeeUseForeach(@RequestParam(required = false) List<Integer> empIds) {

        return employeeMapper.selectEmployeeUseForeach(empIds == null ? Collections.emptyList() : empIds);
    }

    @GetMapping("/byConditionUseBind")
    public List<Employee> selectEmployeeUseBind(Employee employee) {

        return employeeMapper.selectEmployeeUseBind(employee);
    }


}
