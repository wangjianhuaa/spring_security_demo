package com.wang.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangjianhua
 * @date 2021-04-22
 */
@SpringBootApplication
@MapperScan(basePackages = "com.wang.demo.modules.**.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
