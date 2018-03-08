package com.lss.girls.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Magic
 * @date 17:11 2018/2/11
 * @description
 */
@EnableCaching
@Configuration
@EnableRedisHttpSession
public class CacheConfig extends JCacheConfigurerSupport{

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

//    @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
}
