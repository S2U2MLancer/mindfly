package slancer.mindfly.service.account.entity.account;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * class WechatAccountEntity
 *
 * @author xiayy860612
 * @date 2018/6/24
 */
@Getter
@Setter
@Accessors(chain = true)
public class WechatAccountEntity {
    private String openId;
    private String userId;
    private Date createTime;

}
