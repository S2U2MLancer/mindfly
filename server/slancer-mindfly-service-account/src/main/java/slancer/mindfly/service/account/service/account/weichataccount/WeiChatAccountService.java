package slancer.mindfly.service.account.service.account.weichataccount;

import slancer.mindfly.service.account.controller.account.dto.WeichatLoginDto;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.IAccountService;

public class WeiChatAccountService implements IAccountService<WeiChatAccountEntity,WeiChatAccountEntity,WeichatLoginDto> {

	@Override
	public UserEntity reg(WeiChatAccountEntity info) {
		return null;
	}

	@Override
	public UserEntity login(WeiChatAccountEntity info) {
		return null;
	}

	@Override
	public void bind(WeichatLoginDto account, UserEntity user) {

	}
}
