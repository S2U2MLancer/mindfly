package slancer.mindfly.service.account.entity.account;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WeiChatLoginEntity {
	private String openId;
}
