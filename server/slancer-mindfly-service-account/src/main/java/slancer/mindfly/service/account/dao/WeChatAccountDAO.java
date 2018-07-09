package slancer.mindfly.service.account.dao;

import org.apache.ibatis.annotations.Mapper;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.entity.account.WechatAccountEntity;

@Mapper
public interface WeChatAccountDAO {

    int create(WechatAccountEntity entity);

    UserEntity getById(String openId);

}
