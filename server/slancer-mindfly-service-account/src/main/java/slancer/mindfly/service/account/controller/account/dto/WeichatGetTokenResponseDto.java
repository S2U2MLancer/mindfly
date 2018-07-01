package slancer.mindfly.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeichatGetTokenResponseDto {
	private String accessToken;
	private String expiresIn;
	private String refreshToken;
	private String openId;
	private String scope;
	private String unionid;
}
