package com.example.antd.antd_pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.antd.antd_pro.mapper")
public class AntdProApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntdProApplication.class, args);
    }

}
