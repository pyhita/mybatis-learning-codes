package com.yangtao.test;

import com.yangtao.entity.Employee;
import com.yangtao.mapper.EmployeeMapper;
import com.yangtao.utils.SqlSessionUtil;
import java.util.Objects;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Author: kante_yang
 * @Date: 2023/12/19
 */
public class L2CacheTest {

    /**
     * 测试二级缓存
     */
    @Test
    public void testL2Cache() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession1.getMapper(EmployeeMapper.class);
            Employee emp1 = employeeMapper.getById(1);
            System.out.println(emp1);
            Employee emp2 = employeeMapper.getById(1);
            System.out.println(Objects.equals(emp1, emp2));

            System.out.println("关闭SqlSession ... ");
        } finally {
            sqlSession1.close();
        }

        System.out.println("开启新的SqlSession");
        sqlSession1 = SqlSessionUtil.getSqlSession();

        try {
            EmployeeMapper employeeMapper = sqlSession1.getMapper(EmployeeMapper.class);
            Employee emp3 = employeeMapper.getById(1);
            System.out.println(emp3);
        } finally {
            sqlSession1.close();
        }

    }

}
