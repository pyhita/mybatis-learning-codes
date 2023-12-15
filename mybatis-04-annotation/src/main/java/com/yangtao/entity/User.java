package com.yangtao.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Data
public class User {

    private String id;

    private String name;

    private Integer age;

    private Date birthday;

    private Department department;

    private Department department_id;

}