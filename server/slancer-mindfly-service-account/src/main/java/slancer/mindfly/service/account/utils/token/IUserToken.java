package slancer.mindfly.service.account.utils.token;

import slancer.mindfly.service.account.entity.UserEntity;

/**
 * interface IUserToken
 *
 * @author xiayy860612
 * @date 2018/6/24
 */
public interface IUserToken<TP> {
    String create(TP param);

    UserEntity getUser(String token);
}
