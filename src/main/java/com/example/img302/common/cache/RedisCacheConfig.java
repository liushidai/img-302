package com.example.img302.common.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author liushidai
 */
@Slf4j
@Configuration
public class RedisCacheConfig implements CachingConfigurer {

    /**
     * 提供默认的cacheManager，应用于全局
     *
     * @param factory
     * @return
     */
    @Bean(name = "cacheManager_default")
    @Primary
    public CacheManager cacheManagerDefault(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = this.getRedisCacheConfiguration();
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config.entryTtl(Duration.ofSeconds(-1)))
                .transactionAware()
                .build();
    }

    /**
     * 自定义的cacheManager，一天
     *
     * @param factory
     * @return
     */
    @Bean(name = "cacheManager_one_day")
    public CacheManager cacheManagerOneDay(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = this.getRedisCacheConfiguration();
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config.entryTtl(Duration.ofDays(1)))
                .build();
    }


    private RedisCacheConfiguration getRedisCacheConfiguration() {

        // 配置序列化（解决乱码的问题）
        return RedisCacheConfiguration.defaultCacheConfig()
                //Key序列化方式redisSerializer
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()));
    }

    /**
     * key 序列化
     *
     * @return
     */
    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    /**
     * 值采用JSON序列化
     *
     * @return
     */
    private RedisSerializer<Object> valueSerializer() {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(new ObjectMapper().getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        return new Jackson2JsonRedisSerializer(om, Object.class);
    }

    /**
     * 异常处理 当Redis缓存相关操作发生异常时 打印日志 程序正常走
     *
     * @return
     */
    @Override
    public CacheErrorHandler errorHandler() {

        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                log.warn("Redis occur handleCacheGetError：key: [{}]", key);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {

                log.warn("Redis occur handleCachePutError：key: [{}]；value: [{}]", key, value);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                log.warn("Redis occur handleCacheEvictError：key: [{}]", key);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                log.warn("Redis occur handleCacheClearError");
            }
        };
    }
}
