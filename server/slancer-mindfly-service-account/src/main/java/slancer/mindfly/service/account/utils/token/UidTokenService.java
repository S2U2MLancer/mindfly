package slancer.mindfly.service.account.utils.token;

import org.springframework.stereotype.Service;
import slancer.mindfly.service.account.entity.UserEntity;

@Service
public class UidTokenService implements IUserToken {

    @Override
    public String create(UserEntity param) {
        return null;
    }

    @Override
    public UserEntity getUser(String token) {
        return null;
    }
}
