package com.example.mybookstore2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.mybookstore2.mapper")
public class MyBookstore2Application {

    public static void main(String[] args) {
        SpringApplication.run(MyBookstore2Application.class, args);
    }

}
