package slancer.mindfly.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeichatAuthResponseDto {
	private int errCode;
	private int code;
	private String state;
	private String lang;
	private String country;
}
