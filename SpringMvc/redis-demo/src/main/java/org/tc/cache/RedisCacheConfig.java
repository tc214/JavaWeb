package org.tc.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;


@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {
    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String, String> redisTemplate;




    public RedisCacheConfig() {
        super();
    }

    /**
     * 带参数的构造方法 初始化所有的成员变量
     *
     * @param jedisConnectionFactory
     * @param redisTemplate
     * @param redisCacheManager
     */
    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate) {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param: []
     * @return: org.springframework.data.redis.connection.jedis.JedisConnectionFactory
     * @Description: Jedis配置
     */
    public JedisConnectionFactory getJedisConnecionFactory(){
        return jedisConnectionFactory;
    }


    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }


    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

}
