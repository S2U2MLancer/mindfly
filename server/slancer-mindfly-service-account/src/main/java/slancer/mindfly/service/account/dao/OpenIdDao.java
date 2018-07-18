package slancer.mindfly.service.account.dao;

import org.springframework.stereotype.Repository;
import slancer.mindfly.service.account.cache.OpenIdCache;
import slancer.mindfly.service.account.dao.common.RedisDao;

@Repository
public class OpenIdDao extends RedisDao<String,OpenIdCache>{

    @Override
    protected String uniquePK(String s) {
        return String.format("%s_%s", this.getClass().getSimpleName(), s);
    }
}
