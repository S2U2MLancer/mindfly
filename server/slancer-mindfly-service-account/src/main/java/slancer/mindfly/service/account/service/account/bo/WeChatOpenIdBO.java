package slancer.mindfly.service.account.service.account.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeChatOpenIdBO {
    private String openId;
    private String session_key;
    private String unionid;
}
