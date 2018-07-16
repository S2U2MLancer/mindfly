package slancer.mindfly.service.account.service.account.bo;

import lombok.Getter;
import lombok.Setter;
import slancer.mindfly.service.account.enums.GenderEnum;

import java.util.Date;

@Getter
@Setter
public class WeChatRegistBO {

    private String code;

    private String nickName;

    private GenderEnum gender = GenderEnum.Unknown;

    private Date birthday;
}
