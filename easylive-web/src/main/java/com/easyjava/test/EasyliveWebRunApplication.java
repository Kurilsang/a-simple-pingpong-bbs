package com.easyjava.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.easyjava.test"})
@ComponentScan("com.easyjava.test.*")
@MapperScan("com.easyjava.test.mappers")
@ComponentScan(basePackages = "com.easyjava.test.config")
@EnableTransactionManagement
public class EasyliveWebRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyliveWebRunApplication.class, args);
    }
}
