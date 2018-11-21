package com.jack.redis.config;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    private RedisConnectionFactory connectionFactory = null;

    @Bean(name="RedisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory(){
        if (this.connectionFactory != null){
            return this.connectionFactory;
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(30);
        poolConfig.setMaxTotal(50);
        poolConfig.setMaxWaitMillis(2000);

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
        RedisStandaloneConfiguration rscfg = connectionFactory.getStandaloneConfiguration();
        rscfg.setHostName("192.168.227.131");
        rscfg.setPort(6379);
        //rscfg.setPassword("12");
        this.connectionFactory = connectionFactory;

        return  this.connectionFactory;
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate(){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        RedisSerializer stringReisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringReisSerializer);
        redisTemplate.setHashKeySerializer(stringReisSerializer);
        redisTemplate.setHashValueSerializer(stringReisSerializer);

        redisTemplate.setConnectionFactory(initRedisConnectionFactory());

        return redisTemplate;
    }

    /*
    @Bean(name="stringRedisTemplate")
    public StringRedisTemplate initStringRedisTemplate(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return stringRedisTemplate;
    }*/
}
