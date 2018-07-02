package slancer.mindfly.service.account.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import slancer.mindfly.core.dto.S2u2mResponseBody;
import slancer.mindfly.service.account.auth.realm.UserTokenAuth;
import slancer.mindfly.service.account.controller.account.dto.WeichatAuthRequstDto;
import slancer.mindfly.service.account.controller.account.dto.WeichatAuthResponseDto;
import slancer.mindfly.service.account.controller.account.dto.WeichatGetTokenRequestDto;
import slancer.mindfly.service.account.controller.account.dto.WeichatLoginDto;
import slancer.mindfly.service.account.service.account.WeichatService;

@RestController
@RequestMapping("/weichat")
public class WeichatController {
	@Autowired
    private WeichatService weichatService;

    @S2u2mResponseBody
    @PostMapping(value = "/login/request")
    public WeichatAuthResponseDto loginRequest(@RequestBody WeichatAuthRequstDto user) {
        return new WeichatAuthResponseDto();
    }

    @S2u2mResponseBody
    @PostMapping(value = "/auth")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token",
                    required = true, dataType = "string")
    })
    public void updateUserInfo(@RequestBody WeichatGetTokenRequestDto requestDto) {
        weichatService.auth(requestDto);
    }

	@S2u2mResponseBody
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token",
                    required = true, dataType = "string")
    })
    public UserTokenAuth login(@RequestBody WeichatLoginDto requestDto) {
		WeiChatAccountEntity entity = new WeiChatAccountEntity()
			.setOpenId(requestDto.getOpenId());
		return weichatService.login(entity);
    }
}
