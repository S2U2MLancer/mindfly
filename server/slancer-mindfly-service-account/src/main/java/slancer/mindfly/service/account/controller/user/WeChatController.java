package slancer.mindfly.service.account.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import slancer.mindfly.core.dto.S2u2mResponseBody;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegisteDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatResponseDTO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.WeChatService;
import slancer.mindfly.service.account.service.account.bo.WeChatBindBO;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @Autowired
    WeChatService weChatService;

    @S2u2mResponseBody
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public WeChatResponseDTO getOpenId(@RequestBody WeChatLoginDTO verifyDto) {
        return new WeChatResponseDTO();
    }


    @S2u2mResponseBody
    @ApiOperation(value = "微信注册")
    @PostMapping("/regist")
    public WeChatResponseDTO weChatRegist(@RequestBody WeChatRegisteDto verifyDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setBirthday(verifyDto.getBirthday())
                .setGender(verifyDto.getGender())
                .setNickName(verifyDto.getNickName())
                .setPassword(verifyDto.getPassword());
        WeChatBindBO weChatBindBo = new WeChatBindBO();
        weChatService.regist(weChatBindBo,userEntity);
        // login
        return new WeChatResponseDTO();
    }

}
