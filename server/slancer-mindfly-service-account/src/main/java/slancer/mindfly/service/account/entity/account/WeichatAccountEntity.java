package slancer.mindfly.service.account.entity.account;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * class WechatAccountEntity
 *
 * @author yangxue
 * @date 2018/6/24
 */

@Getter
@Setter
@Accessors(chain = true)
public class WeichatAccountEntity {

	private String userId;
	private String openId;
	private Date createTime;

}
