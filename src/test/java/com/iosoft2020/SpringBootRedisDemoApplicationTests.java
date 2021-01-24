package com.iosoft2020;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iosoft2020.pojo.User;

@SpringBootTest
class SpringBootRedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("mykey", "iosoft2020");
        System.err.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void testGetSet() throws JsonProcessingException {
        User userObj = new User("iosoftああ", 18);
        //        String user = objectMapper.writeValueAsString(new User("iosoftああ", 18));
        redisTemplate.opsForValue().set("user", userObj);
        System.err.println(redisTemplate.opsForValue().get("user"));

    }

}
