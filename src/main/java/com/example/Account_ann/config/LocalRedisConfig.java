package com.example.Account_ann.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration // 결국엔 Component -> Bean으로 등록해서 Spring에 넣어줘
public class LocalRedisConfig {
    @Value("${spring.redis.port}")
    private int redisPort; // redis 를 띄워줄 포트

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis() {
        redisServer = new RedisServer(redisPort);
        redisServer.start(); // 이 안에서 redis를 별도의 인서트로 띄운다.
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}
