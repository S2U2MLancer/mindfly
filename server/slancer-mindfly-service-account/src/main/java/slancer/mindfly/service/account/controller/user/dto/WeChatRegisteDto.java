package slancer.mindfly.service.account.controller.user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import slancer.mindfly.service.account.enums.GenderEnum;

@Setter
@Getter
public class WeChatRegisteDto {
	private String openId;
	private String password;
    private String nickName;
    private GenderEnum gender = GenderEnum.Unknown;
    private Date birthday;
}
