package slancer.mindfly.service.account.dao.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    public <KT> RedisTemplate<String, KT> getRedisTemp() {
        RedisTemplate<String, KT> template = null;
        //        RedisTemplate<String, KT> template = new RedisTemplate<>();
        //        template.setKeySer    ializer();
        //        template.setValueSerializer();
        return template;
    }
}
