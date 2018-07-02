package slancer.mindfly.service.account.dao;

public interface WeichatDao {

	int create(WeiChatAccountEntity entity);

	WeiChatAccountEntity getById(String id);

}
