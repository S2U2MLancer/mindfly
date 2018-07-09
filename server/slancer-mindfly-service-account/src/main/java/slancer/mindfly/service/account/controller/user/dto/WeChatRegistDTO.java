package slancer.mindfly.service.account.controller.user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import slancer.mindfly.service.account.enums.GenderEnum;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class WeChatRegistDTO {
	private String code;
	private String password;
	private String nickName;
	private GenderEnum gender = GenderEnum.Unknown;
	private Date birthday;
}
