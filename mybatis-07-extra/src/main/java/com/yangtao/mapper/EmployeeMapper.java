package com.yangtao.mapper;

import com.yangtao.entity.Employee;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: kante_yang
 * @Date: 2023/12/19
 */
public interface EmployeeMapper {

    @Update("UPDATE t_emp SET emp_name = #{empName} WHERE emp_id = #{empId}")
    Integer updateById(Employee employee);

    @Select("SELECT * FROM t_emp")
    List<Employee> listEmployees();

    @Select("SELECT * FROM t_emp WHERE emp_id = #{empId}")
    Employee getById(Integer empId);

    @Select("SELECT * FROM t_emp WHERE emp_id = #{empId}")
    Map<String, Object> getEmpMap(Integer empId);
}
