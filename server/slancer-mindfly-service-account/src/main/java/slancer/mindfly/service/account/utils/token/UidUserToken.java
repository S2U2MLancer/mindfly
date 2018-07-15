package slancer.mindfly.service.account.utils.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.UserService;

/**
 * class UidUserToken
 *
 * @author xiayy860612
 * @date 2018/7/8
 */
@Component
public class UidUserToken implements IUserToken {

    @Autowired
    private UserService userService;

    @Override
    public String create(UserEntity param) {
        return param.getId();
    }

    @Override
    public UserEntity getUser(String token) {
        return userService.get(token);
    }
}
