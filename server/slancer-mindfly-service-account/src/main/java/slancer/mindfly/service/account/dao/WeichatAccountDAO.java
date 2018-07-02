package slancer.mindfly.service.account.dao;

/**
 * interface UserDAO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface WeichatAccountDAO {

    int insert(WeiChatAccountEntity entity);

    WeiChatAccountEntity getById(String openUid);
}
