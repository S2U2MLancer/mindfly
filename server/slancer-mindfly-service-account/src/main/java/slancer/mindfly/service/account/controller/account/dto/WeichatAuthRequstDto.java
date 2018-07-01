package slancer.mindfly.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeichatAuthRequstDto {
	private String appid;
	private String scope;
	private String state;
}
