package slancer.mindfly.service.account.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import slancer.mindfly.core.dto.S2u2mResponseBody;
import slancer.mindfly.service.account.controller.user.dto.LoginDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegistDTO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.utils.token.UidTokenService;
import slancer.mindfly.service.account.service.account.WeChatService;
import slancer.mindfly.service.account.service.account.bo.WeChatRegistBO;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @Autowired
    WeChatService weChatService;
    @Autowired
    UidTokenService uidTokenService;

    @S2u2mResponseBody
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public LoginDTO login(@RequestBody WeChatLoginDTO verifyDto) {
        return new LoginDTO();
    }


    @S2u2mResponseBody
    @ApiOperation(value = "微信注册")
    @PostMapping("/regist")
    public LoginDTO weChatRegist(@RequestBody WeChatRegistDTO verifyDto) {
        WeChatRegistBO weChatRegistBO = new WeChatRegistBO();
        UserEntity reg = weChatService.reg(weChatRegistBO);
        String token = uidTokenService.create(reg);
        return new LoginDTO().setToken(token);
    }

}
