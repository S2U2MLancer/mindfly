package slancer.mindfly.service.account.dao.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Repository
public abstract class RedisDao<PKT extends Object,VT extends Serializable> {

    @Autowired
    RedisTemplate<String, VT> redisTemplate;

    protected abstract String uniquePK(PKT pkt);

    public void insert(PKT pk, VT value, Long timeOut, TimeUnit timeUnit) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value,timeOut,timeUnit);
    }

    public VT get(PKT pk) {
        String key = uniquePK(pk);
        return redisTemplate.opsForValue().get(key);
    }

    public void update(PKT pk,VT value) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value);
    }

    public void update(PKT pk, VT value, Long timeOut, TimeUnit timeUnit) {
        String key = uniquePK(pk);
        redisTemplate.opsForValue().set(key,value,timeOut,timeUnit);
    }

    public void delete(PKT pk) {
        String key = uniquePK(pk);
        redisTemplate.delete(key);
    }

}
