package com.didi.db.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @ClassName JedisAutoConfigure
 * @Author zhangxinkun
 * @Date 2020/1/28  5:00 PM
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(Jedis.class)
public class JedisAutoConfigure {

    @Bean
    public Jedis injectJedis(){
        Jedis jedis = new Jedis("localhost",6379);
        return jedis;
    }
}
