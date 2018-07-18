package slancer.mindfly.service.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.entity.account.WechatAccountEntity;

@Mapper
@Repository
public interface WeChatAccountDAO {

    int create(WechatAccountEntity entity);

    UserEntity getById(String openId);

}
