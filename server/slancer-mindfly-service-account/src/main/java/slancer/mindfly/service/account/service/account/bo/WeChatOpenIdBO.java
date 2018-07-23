package slancer.mindfly.service.account.service.account.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class WeChatOpenIdBO {
    private String openid;
    private String session_key;
    private String unionid;
}
