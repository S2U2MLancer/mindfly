package slancer.mindfly.service.account.dao.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {
    @Bean
    public <KT> RedisTemplate<String, KT> getRedisTemp() {
        RedisTemplate<String, KT> template = null;
        //        RedisTemplate<String, KT> template = new RedisTemplate<>();
        //        template.setKeySer    ializer();
        //        template.setValueSerializer();
        return template;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisConnectionFactory redisConnectionFactory () {
        RedisConnectionFactory factory = new JedisConnectionFactory();
        return factory;
    }

    
}
