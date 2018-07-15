package slancer.mindfly.service.account.service.account.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import slancer.mindfly.service.account.entity.UserEntity;

@Setter
@Getter
@Accessors(chain = true)
public class UserEntityToken {
    private UserEntity userEntity;
}
