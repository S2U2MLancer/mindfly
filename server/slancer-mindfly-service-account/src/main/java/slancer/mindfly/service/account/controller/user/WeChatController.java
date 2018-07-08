package slancer.mindfly.service.account.controller.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import slancer.mindfly.core.dto.S2u2mResponseBody;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyResponseDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegisteDto;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.WeChatService;
import slancer.mindfly.service.account.service.account.bo.WeChatBindBo;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

    @Autowired
    WeChatService weChatService;

    @S2u2mResponseBody
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public String getOpenId(@RequestBody WeChatLoginVerifyDto verifyDto) {
        WeChatLoginVerifyResponseDto responseDto = new WeChatLoginVerifyResponseDto();
        return "";
    }


    @S2u2mResponseBody
    @ApiOperation(value = "微信注册")
    @PostMapping("/regist")
    public String weChatRegist(@RequestBody WeChatRegisteDto verifyDto) {
        UserEntity userEntity = new UserEntity(verifyDto);
        WeChatBindBo weChatBindBo = new WeChatBindBo(verifyDto);
        weChatService.regist(weChatBindBo,userEntity);
        // login
        return "";
    }

}