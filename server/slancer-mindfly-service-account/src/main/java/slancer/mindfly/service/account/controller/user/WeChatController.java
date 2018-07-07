package slancer.mindfly.service.account.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyResponseDto;
import slancer.mindfly.service.account.service.account.WeChatService;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

	@Autowired
	WeChatService weChatService;

	@ApiOperation(value = "登录凭证校验")
	@PostMapping("/login/verify")
	public WeChatLoginVerifyResponseDto getOpenId(@RequestBody WeChatLoginVerifyDto verifyDto) {
		WeChatLoginVerifyResponseDto responseDto = new WeChatLoginVerifyResponseDto();
		responseDto.setOpenId(weChatService.getOpenId(verifyDto.getCode()));
		return responseDto;
	}

}
