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

public class L1CacheTest {

    /**
     * 测试一级缓存
     */
    @Test
    public void testL1Cache() {
        System.out.println("开启Sql Session");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee emp1 = employeeMapper.getById(1);
            emp1.setEmpName("xxxx");
            // 再次查询获取相同id的emp
            Employee emp2 = employeeMapper.getById(1);
            System.out.println(Objects.equals(emp1, emp2));

        } finally {
            // 关闭当前的sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void testClearL1Cache() {
        System.out.println("开启sqlSession");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee emp1 = employeeMapper.getById(1);
            emp1.setEmpName("xxxx");

            // 手动 clear cache
//            employeeMapper.cleanCache();

            // 再次进行相同的查询
            Employee emp2 = employeeMapper.getById(1);

            System.out.println(emp2);
            System.out.println(Objects.equals(emp1, emp2));

        } finally {
            // close
            sqlSession.close();
        }
    }



}
