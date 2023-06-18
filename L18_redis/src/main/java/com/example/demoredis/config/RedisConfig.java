package com.example.demoredis.config;

import com.example.demoredis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Value("${redis.host.url}")
    String host;

    @Value("${redis.host.port}")
    Integer port;

    @Value("${redis.auth.password}")
    String password;

    @Bean
    public LettuceConnectionFactory getConnection(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        configuration.setPassword(password);

        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);

        return lettuceConnectionFactory;
    }

    // Redis Template

    @Bean
    public RedisTemplate<String, Person> getTemplate(){

        RedisTemplate<String, Person> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getConnection());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }


    @Bean
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }
}
