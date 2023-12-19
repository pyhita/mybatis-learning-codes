package com.yangtao.mapper;

import com.yangtao.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: kante_yang
 * @Date: 2023/12/19
 */
//@CacheNamespace
public interface EmployeeMapper {


//    @Select("SELECT * FROM t_emp WHERE emp_id = #{empId}")
//    @Options(useCache = true)
    Employee getById(@Param("empId") Integer empId);

    @Delete("DELETE FROM t_emp WHERE emp_id = #{empId}")
    Integer deleteById(@Param("empId") Integer empId);

    Integer updateById(@Param("empId") Integer empId);

    @Select("SELECT COUNT(*) FROM t_emp")
//    @Options(flushCache = FlushCachePolicy.TRUE)
    Integer cleanCache();
}
