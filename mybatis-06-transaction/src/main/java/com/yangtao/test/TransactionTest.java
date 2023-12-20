package com.yangtao.test;

import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Author: kante_yang
 * @Date: 2023/12/20
 */
public class TransactionTest {

    private SqlSessionFactory factory;

    @BeforeEach
    public void before() throws Exception {
        InputStream ins = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
        factory = sqlSessionFactory;
    }

    @Test
    public void closeAutoCommit() {
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession(false);
        EmployeeMapper employeeMapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        EmployeeMapper employeeMapper2 = sqlSession2.getMapper(EmployeeMapper.class);

        Employee emp = employeeMapper1.getById(1);
        emp.setEmpName("xxxx");
        employeeMapper1.updateById(emp);

        // 因为没有开启自动提交，所以上面的更改对于事务2来说是不生效的
        for (Employee employee : employeeMapper2.listEmployees()) {
            System.out.println(employee);
        }

    }

    @Test
    public void openAutoCommit() {
        SqlSession sqlSession1 = factory.openSession(true);
        SqlSession sqlSession2 = factory.openSession(false);
        EmployeeMapper employeeMapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        EmployeeMapper employeeMapper2 = sqlSession2.getMapper(EmployeeMapper.class);

        Employee emp = employeeMapper1.getById(1);
        emp.setEmpName("xxxx");
        employeeMapper1.updateById(emp);

        // 开启自动提交了，立即生效了
        for (Employee employee : employeeMapper2.listEmployees()) {
            System.out.println(employee);
        }
    }
}
