package com.yangtao.test;

import com.yangtao.entity.Customer;
import com.yangtao.entity.Employee;
import com.yangtao.entity.Order;
import com.yangtao.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kante_yang
 * @Date: 2023/10/20
 */
public class MyBatisTest {

    private SqlSession session;

    @BeforeEach
    public void buildSqlSession() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
    }


    @Test
    public void testSelectEmployee() throws Exception {

        // 1 创建sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 使用SqlSessionFactory 开启一个session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 根据EmployeeMapper接口的class对象，获取Mapper接口类型的代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 4 调用代理类方法触发对应的sql语句
        Employee employee = employeeMapper.selectEmployee(1);
        System.out.println(employee);

        Map<String, Object> resMap = employeeMapper.selectEmpNameAndMaxSalary();
        for (Map.Entry<String, Object> entry : resMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // 5 关闭sqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertEmployee() throws Exception {
        // 1 创建sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 使用SqlSessionFactory 开启一个session
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee("kante", 22.3);
        int result = employeeMapper.insertEmployee(employee);

        System.out.println(result);
        session.commit();
        session.close();
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        // 1 创建sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 使用SqlSessionFactory 开启一个session
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//        int result = employeeMapper.updateEmployee(5, "kante2", 2.2);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("empName", "liam");
        paramMap.put("empId", 5);
        int result = employeeMapper.updateEmployeeByMap(paramMap);

        System.out.println(result);
        session.commit();
        session.close();
    }

    @Test
    public void testSelectEmployeeByRMResultMap() throws Exception {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployeeByRMResultMap(5);

        System.out.println(employee);
    }


    @Test
    public void testSelectOrder() throws Exception {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Order order = mapper.selectOrderWithCustomer(1);
        System.out.println(order);
    }

    @Test
    public void testSelectCustomer() throws Exception {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Customer customer = mapper.selectCustomerWithOrder(1);
        System.out.println(customer);
    }

}
