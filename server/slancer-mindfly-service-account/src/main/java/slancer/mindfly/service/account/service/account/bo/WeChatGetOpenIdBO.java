package slancer.mindfly.service.account.service.account.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeChatGetOpenIdBO {
    private String js_code;
    private String appid;
    private String secret;
    private String grant_type;
}
