package slancer.mindfly.service.account.service.account.bo;

import lombok.Getter;
import lombok.Setter;
import slancer.mindfly.service.account.enums.GenderEnum;

import java.util.Date;

@Setter
@Getter
public class BindWeChatBO {
    private String openId;
    private String userId;
}
