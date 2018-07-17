package slancer.mindfly.service.account.entity.account;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * class WechatAccountEntity
 *
 * @author xiayy860612
 * @date 2018/6/24
 */
@Setter
@Getter
public class WechatAccountEntity {
    private String openId;
    private String userId;
    private Date createDate;

}
