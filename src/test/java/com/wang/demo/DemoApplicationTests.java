package com.wang.demo;

import com.wang.demo.component.redis.RedisComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisComponent redisComponent;
    @Test
    void contextLoads() {
        redisComponent.del("0");
    }

}
