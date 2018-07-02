package slancer.mindfly.service.account.service.account;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slancer.mindfly.core.uid.SnowFlakeUidGenerator;
import slancer.mindfly.service.account.auth.realm.UserTokenAuth;
import slancer.mindfly.service.account.controller.account.dto.WeichatAuthResponseDto;
import slancer.mindfly.service.account.controller.account.dto.WeichatGetTokenRequestDto;
import slancer.mindfly.service.account.controller.account.dto.WeichatGetTokenResponseDto;
import slancer.mindfly.service.account.dao.WeichatDao;
import slancer.mindfly.service.account.entity.account.WeiChatAccountEntity;

/**
 * class UserService
 *
 * @author yanxgue
 * @date 2018/7/11
 */
@Service
public class WeichatService {

	@Autowired
	private WeichatDao weichatDao;

	@Autowired
	SnowFlakeUidGenerator uidGenerator;

	@Transactional(rollbackFor = Exception.class)
	public UserTokenAuth login(WeiChatAccountEntity entity) {
		String id = uidGenerator.nextIdByString();
		entity.setCreateTime(Date.from(Instant.now()));
		weichatDao.create(entity);
		//TODO 获取token
		return new UserTokenAuth("token");
	}

	public WeichatGetTokenResponseDto auth(WeichatGetTokenRequestDto requestDto) {
		//TODO 调用微信的认证接口
		return new WeichatGetTokenResponseDto();
	}

	public WeichatAuthResponseDto loginRequest() {
		//TODO 微信登陆请求
		return new WeichatAuthResponseDto();
	}
}
