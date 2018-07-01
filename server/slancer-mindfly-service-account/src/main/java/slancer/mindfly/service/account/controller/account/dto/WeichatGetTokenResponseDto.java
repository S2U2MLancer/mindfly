package slancer.mindfly.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeichatGetTokenResponseDto {
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String unionid;
}
