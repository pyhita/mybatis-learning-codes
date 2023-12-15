package com.yangtao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yangtao.mapper")
public class Mybatis04AnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatis04AnnotationApplication.class, args);
    }

}
