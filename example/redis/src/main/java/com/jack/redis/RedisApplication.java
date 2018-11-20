package com.jack.redis;

import com.jack.redis.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {

		//SpringApplication.run(RedisApplication.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		redisTemplate.opsForValue().set("key1", "jackjiang");
		redisTemplate.opsForHash().put("hash", "field", "hvalue");

		redisTemplate.boundSetOps("aa");

		System.out.println(redisTemplate.opsForValue().get("key1"));
	}
}
