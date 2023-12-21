package com.yangtao.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import com.yangtao.utils.SqlSessionUtil;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Author: kante_yang
 * @Date: 2023/12/20
 */
public class TestPlugin {

    @Test
    public void testCustomInterceptor() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee emp = employeeMapper.getById(1);
        emp.setEmpName("yyyy");
        employeeMapper.updateById(emp);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testCamelPlugin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Object> empMap = employeeMapper.getEmpMap(1);
        System.out.println(empMap);
    }

    @Test
    public void testPageInterceptor() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        PageHelper.startPage(1, 4);
        List<Employee> employees = employeeMapper.listEmployees();
        Page<Employee> result = (Page<Employee>) employees;
        System.out.println("pages = " + result.getPages());
        System.out.println("result " + result.getResult());
        System.out.println("total " + result.getTotal());
    }

    @Test
    public void testSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        // 不用过mapper执行查询
        Employee employee = sqlSession.selectOne("com.yangtao.mapper.EmployeeMapper.getById", 1);
        System.out.println(employee);
    }
}
