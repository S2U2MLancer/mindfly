package slancer.mindfly.service.account.dao;

import slancer.mindfly.service.account.entity.account.WeiChatAccountEntity;

public interface WeichatDao {

	int create(WeiChatAccountEntity entity);

	WeiChatAccountEntity getById(String id);

}
