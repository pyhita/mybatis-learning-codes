package com.yangtao.mapper;

import com.yangtao.entity.Employee;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {


    @Select("SELECT * FROM t_emp")
    List<Employee> selectEmployees();

    @Insert("INSERT INTO t_emp(emp_name, emp_salary) VALUES (#{empName}, #{empSalary})")
    @Options(useGeneratedKeys = true, keyProperty = "empId")
    int insert(Employee employee);

//    测试mybatis 传参方式
    // 一个简单类型
    @Select("SELECT * FROM t_emp WHERE emp_name = #{empName} LIMIT 1")
    Employee findEmpByName(String empName);

    // 多个简单类型参数
    @Select("SELECT * FROM t_emp WHERE emp_id = #{empId} AND emp_name = #{empName} LIMIT 1")
    Employee findEmpByIdAndName(String empId, String empName);

    // 对象传参第一种情况
    @Select("""
        <script>
            SELECT * FROM t_emp
            <where>
                <if test="emp.empId != null">emp_id = #{emp.empId}</if>
                <if test="emp.empName != null and emp.empName != ''">AND emp_name = #{emp.empName}</if>
            </where>
            LIMIT 1
        </script>
    """)
    List<Employee> findAllByExample(@Param("emp") Employee emp);

    // 对象传参 第二种方式
    @Select("""
        <script>
            SELECT * FROM t_emp
            <where>
                <if test="empId != null">emp_id = #{empId}</if>
                <if test="empName != null and empName != ''">AND emp_name = #{empName}</if>
            </where>
            LIMIT 1
        </script>
    """)
    List<Employee> findAllByExample2(Employee employee);

//    测试 mybatis 动态sql

    @Select("""
    <script>
        SELECT * FROM t_emp
        <where>
            <if test="empName != null and empName != ''">
                AND emp_name LIKE CONCAT('%', #{empName}, '%')
            </if>
            <if test="empSalary &gt; 20">
                AND emp_salary > #{empSalary}
            </if>
        </where>
    </script>
    """)
    List<Employee> selectEmployeeByCondition(Employee employee);

    @Select("""
    <script>
        SELECT * FROM t_emp
        <trim prefix="where" prefixOverrides="and|or">
            <if test="empName != null and empName != ''">
                AND emp_name LIKE CONCAT('%', #{empName}, '%')
            </if>
            <if test="empSalary &gt; 20">
                AND emp_salary > #{empSalary}
            </if>
        </trim>
    </script>
    """)
    List<Employee> selectEmployeeByConditionByTrim(Employee employee);

    @Select("""
    <script>
        SELECT * FROM t_emp
        WHERE
        <choose>
            <when test="empName != null">emp_name = #{empName}</when>
            <when test="empSalary != null and empSalary &lt; 3000">emp_salary &lt; 3000</when>
            <otherwise>1 = 1</otherwise>
        </choose>
    </script>
    """)
    List<Employee> selectEmployeeByConditionByChoose(Employee employee);

    @Select("""
    <script>
        SELECT * FROM t_emp
        WHERE emp_id IN 
        <foreach collection="empIds" item="empId" open="(" close=")" separator=",">
            #{empId}
        </foreach>
    </script>
    """)
    List<Employee> selectEmployeeUseForeach(List<Integer> empIds);

    @Select("""
    <script>
        <bind name="namelike" value="'%' + empName + '%'"></bind>
        SELECT * FROM t_emp
        WHERE emp_name LIKE #{namelike}
    </script>
    """)
    List<Employee> selectEmployeeUseBind(Employee employee);


    @Select("""
    <script>
        UPDATE t_emp
        <set>
            <if test="empName != null and empName != ''">emp_name = #{empName}</if>
            <if test="empSalary != null">emp_salary = #{empSalary}</if>
        </set>
    </script>
    """)
    Integer updateEmployeeDynamic(Employee employee);

    @Select("""
    <script>
        UPDATE t_emp
        <foreach collection="beanMap" index="key" item="value" open="set" separator=",">
            <if test="value!=null">${key} = #{value}</if>
        </foreach>
    </script>
    """)
    Integer updateEmployeeByMap(Map<String, Object> beanMap);


}