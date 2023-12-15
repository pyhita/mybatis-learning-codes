package com.yangtao.test;

import com.yangtao.entity.Customer;
import com.yangtao.entity.Employee;
import com.yangtao.entity.Order;
import com.yangtao.mapper.CustomerMapper;
import com.yangtao.mapper.EmployeeMapper;
import com.yangtao.mapper.OrderMapper;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<Employee> employees = employeeMapper.selectEmployee();

        System.out.println(employees);
        // 5 关闭sqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectEmployee2() throws Exception {

        // 1 创建sqlSessionFactory
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2 使用SqlSessionFactory 开启一个session
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3 根据EmployeeMapper接口的class对象，获取Mapper接口类型的代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        // 4 调用代理类方法触发对应的sql语句
        Employee employee = employeeMapper.selectEmployee2(1);
        System.out.println(employee);

//        Map<String, Object> resMap = employeeMapper.selectEmpNameAndMaxSalary();
//        for (Map.Entry<String, Object> entry : resMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        // 5 关闭sqlSession
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectMap() throws Exception {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String, Object> map = employeeMapper.selectEmpNameAndMaxSalary();

        System.out.println(map);
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
        System.out.println(employee.getEmpId());

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
    public void testSelectOrders() {
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        List<Order> orders = orderMapper.selectOrderWithCustomer();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void testSelectCustomers() {
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.selectCustomerWithOrder();
        System.out.println(customers.size());
        for (Customer customer : customers) {
            System.out.println(customer);
        }

    }


}
