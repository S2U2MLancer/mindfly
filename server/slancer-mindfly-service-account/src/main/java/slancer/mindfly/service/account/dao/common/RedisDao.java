package slancer.mindfly.service.account.dao.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Repository
public abstract class RedisDao {

    
    @Autowired
    StringRedisTemplate redisTemplate;

    protected abstract String uniquePK(String pkt);

    public void insert(String pk, String value, Long timeOut, TimeUnit timeUnit) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value,timeOut,timeUnit);
    }

    public String get(String pk) {
        String key = uniquePK(pk);
        return redisTemplate.opsForValue().get(key);
    }

    public void update(String pk,String value) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value);
    }

    public void update(String pk, String value, Long timeOut, TimeUnit timeUnit) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value,timeOut,timeUnit);
    }

    public void delete(String pk) {
        String key = uniquePK(pk);
        redisTemplate.delete(key);
    }

}
