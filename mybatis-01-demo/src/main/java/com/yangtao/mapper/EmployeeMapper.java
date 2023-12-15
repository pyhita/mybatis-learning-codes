package com.yangtao.mapper;

import com.yangtao.entity.Employee;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/10/20
 */
public interface EmployeeMapper {

    List<Employee> selectEmployee();

    @Select("SELECT emp_id empId, emp_name empName, emp_salary empSalary FROM t_emp WHERE emp_id = #{empId}")
    Employee selectEmployee2(Integer empId);

    Employee selectEmployee3(Employee employee);

    int insertEmployee(Employee employee);

    int updateEmployee(@Param("empId") Integer empId, @Param("empName") String empName, @Param("empSalary") Double empSalary);

    int updateEmployeeByMap(Map<String, Object> paramMap);

    Map<String, Object> selectEmpNameAndMaxSalary();

    List<Employee> listEmployee();

    Employee selectEmployeeByRMResultMap(Integer emp_id);

}
