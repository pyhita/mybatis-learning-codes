package com.yangtao.entity;

import com.yangtao.contanst.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

    private Gender empGender;

    //getter | setter

    public Employee(String empName, Double empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }
}
