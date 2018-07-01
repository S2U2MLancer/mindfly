package slancer.mindfly.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeichatGetTokenRequestDto {
	private String appid;
	private String secret;
	private String code;
	private String grant_type;
}
