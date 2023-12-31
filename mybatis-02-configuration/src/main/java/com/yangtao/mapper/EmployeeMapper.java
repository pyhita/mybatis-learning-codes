package com.yangtao.mapper;

import com.yangtao.entity.Employee;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Mapper
public interface EmployeeMapper {


    @Select("SELECT * FROM t_emp")
    List<Employee> selectEmployees();
}
