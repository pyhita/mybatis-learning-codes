package com.yangtao.entity;

import lombok.Data;

/**
 * @Author: kante_yang
 * @Date: 2023/12/14
 */
@Data
public class JsonModel {

    private Integer id;
//    private JSONObject jsonModel;
//    private String jsonModel;
    private Person jsonModel;
    private String testField;

    @Data
    public static class Person {
        private Integer id;
        private Integer age;
        private String name;

    }
}
