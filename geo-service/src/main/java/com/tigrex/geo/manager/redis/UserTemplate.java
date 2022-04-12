package com.tigrex.geo.manager.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tigrex.geo.entity.bo.UserBO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.time.Duration;

/**
 * redis template
 * @author linus
 */
@Repository(value = "userRedisTemplate")
public class UserTemplate extends AbstractRedisTemplate<UserBO> implements InitializingBean {

    @Override
    @Bean(value = "userRedisCacheManager")
    public CacheManager cacheManager() {
        Jackson2JsonRedisSerializer<UserBO> serializer = getSerializer();
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues().entryTtl(Duration.ofSeconds(3600L))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    }

    @Override
    public void afterPropertiesSet() {
        Jackson2JsonRedisSerializer<UserBO> serializer = getSerializer();
        setConnectionFactory(redisConnectionFactory);
        setKeySerializer(new StringRedisSerializer());
        setValueSerializer(serializer);
        setHashKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(serializer);
        super.afterPropertiesSet();
    }

    @Override
    public Jackson2JsonRedisSerializer<UserBO> getSerializer() {
        Jackson2JsonRedisSerializer<UserBO> serializer = new Jackson2JsonRedisSerializer<>(UserBO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serializer.setObjectMapper(objectMapper);
        return serializer;
    }
}
