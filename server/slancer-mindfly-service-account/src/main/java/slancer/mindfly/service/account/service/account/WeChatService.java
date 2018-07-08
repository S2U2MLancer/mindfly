package slancer.mindfly.service.account.service.account;

import org.springframework.stereotype.Service;

import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegisteDto;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.bo.WeChatBindBo;

@Service
public class WeChatService {

	public String getOpenId(String code) {
		return "";
	}

	public void bind(WeChatBindBo bindBo,UserEntity userEntity) {

	}
}
