package com.yangtao;

import com.yangtao.mapper.EmployeeMapper;
import java.lang.reflect.Method;

/**
 * @Author: kante_yang
 * @Date: 2023/10/20
 */
public class Main {
    public static void main(String[] args) {
        Class type = EmployeeMapper.class;

        Method[] methods = type.getMethods();

        String clssName = type.getName();
        for (Method method : methods) {
            String methodName = method.getName();

            if (methodName.contains("selectEmployee2")) {
                System.out.println(clssName + "." + methodName);
            }
        }
    }
}