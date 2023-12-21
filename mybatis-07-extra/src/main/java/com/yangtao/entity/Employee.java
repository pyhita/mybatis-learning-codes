package com.yangtao.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kante_yang
 * @Date: 2023/12/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private Integer empId;

    private String empName;

    private Double empSalary;

    //getter | setter

    public Employee(String empName, Double empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }
}
