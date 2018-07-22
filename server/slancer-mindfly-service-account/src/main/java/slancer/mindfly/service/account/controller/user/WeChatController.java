package slancer.mindfly.service.account.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import slancer.mindfly.core.dto.S2u2mResponseBody;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegistDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatResponseDTO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.WeChatService;
import slancer.mindfly.service.account.service.account.bo.BindWeChatBO;
import slancer.mindfly.service.account.service.account.bo.WeChatRegistBO;

@RestController
@RequestMapping("/account/weChat")
public class WeChatController {

    @Autowired
    WeChatService weChatService;

    @S2u2mResponseBody
    @ApiOperation(value = "登录")
    @GetMapping("/login/{code}")
    public WeChatResponseDTO login(@PathVariable String code) {

        String login = weChatService.login(code);
        return new WeChatResponseDTO(login);
    }


    @S2u2mResponseBody
    @ApiOperation(value = "微信注册")
    @PostMapping("/regist")
    public WeChatResponseDTO weChatRegist(@RequestBody WeChatRegistDTO verifyDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(verifyDto.getBirthday())
                .setGender(verifyDto.getGender())
                .setNickName(verifyDto.getNickName())
                .setPassword(verifyDto.getPassword());
        WeChatRegistBO weChatRegistBO = new WeChatRegistBO();
        weChatRegistBO.setCode(verifyDto.getCode());
        String regist = weChatService.regist(weChatRegistBO, userEntity);
        // login
        return new WeChatResponseDTO(regist);
    }

}
