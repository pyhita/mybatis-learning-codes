package com.linkedbear.mybatis.app;

import com.linkedbear.mybatis.entity.User;
import com.linkedbear.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AppTest {

    private SqlSession sqlSession;

    @Before
    public void before() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config-4.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = factory.openSession();
    }

    @Test
    public void testTypeHandler() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> allUsersWithTypeHandler = mapper.findAllUsersWithTypeHandler();
        allUsersWithTypeHandler.forEach(user -> {
            System.out.println(user);
        });
    }
}
