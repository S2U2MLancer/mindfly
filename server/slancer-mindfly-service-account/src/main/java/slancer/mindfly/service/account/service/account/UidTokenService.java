package slancer.mindfly.service.account.service.account;

import org.springframework.stereotype.Service;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.bo.UserEntityToken;

@Service
public class UidTokenService implements ITokenService<UserEntityToken> {
    @Override
    public String create(UserEntityToken token) {
        return "";
    }
}
