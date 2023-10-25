package com.yangtao.mapper;

import com.yangtao.entity.Customer;
import com.yangtao.entity.Employee;
import com.yangtao.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: kante_yang
 * @Date: 2023/10/20
 */
public interface EmployeeMapper {

    Employee selectEmployee(Integer empId);

    int insertEmployee(Employee employee);

    int updateEmployee(@Param("empId") Integer empId, @Param("empName") String empName, @Param("empSalary") Double empSalary);

    int updateEmployeeByMap(Map<String, Object> paramMap);

    Map<String, Object> selectEmpNameAndMaxSalary();

    List<Employee> listEmployee();

    Employee selectEmployeeByRMResultMap(Integer emp_id);

    // 测试一对多
    Order selectOrderWithCustomer(Integer orderId);

    // 测试多对一
    Customer selectCustomerWithOrder(Integer customerId);

}
