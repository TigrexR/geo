package com.tigrex.geo.manager.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author linus
 */
public abstract class AbstractRedisTemplate<T> extends RedisTemplate<String, T> {

    @Autowired
    public RedisConnectionFactory redisConnectionFactory;

    /**
     * cache manager
     * @return CacheManager
     */
    abstract CacheManager cacheManager();

    /**
     * get serializer
     * @return serializer
     */
    abstract RedisSerializer<T> getSerializer();
}
