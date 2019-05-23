package com.ruifu.pls.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

   /* @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }*/

    @Bean
    RedisTemplate<String, Item> redisTemplate(){
        RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
        redisTemplate.setConnectionFactory(connectionFactory());
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("a.thoughts-go.top");
        connectionFactory.setPort(26379);
        connectionFactory.setPassword("rj20170103P@ss!2#4%6");
        return connectionFactory;
    }

}
