package slancer.mindfly.service.account.cache;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OpenIdCache implements Serializable {
    private String  openId;
}
