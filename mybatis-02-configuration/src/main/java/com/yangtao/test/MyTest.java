package com.yangtao.test;

import com.yangtao.entity.Employee;
import com.yangtao.entity.JsonModel;
import com.yangtao.entity.User;
import com.yangtao.mapper.EmployeeMapper;
import com.yangtao.mapper.JsonModelMapper;
import com.yangtao.mapper.UserMapper;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
public class MyTest {

    private SqlSession session;

    @BeforeEach
    public void buildSession() throws Exception {
        InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        session = factory.openSession();
    }

    @Test
    public void selectEmployes() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.selectEmployees();

//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
    }

    @Test
    public void selectUsers() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findAllUseTypeHandler();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectJsons() {
        JsonModelMapper jsonModelMapper = session.getMapper(JsonModelMapper.class);

        List<JsonModel> jsonModels = jsonModelMapper.selectJsons();
        for (JsonModel jsonModel : jsonModels) {
            System.out.println(jsonModel);
        }
    }

}
