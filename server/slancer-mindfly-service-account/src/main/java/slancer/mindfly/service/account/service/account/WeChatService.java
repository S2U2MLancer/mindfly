package slancer.mindfly.service.account.service.account;

import org.springframework.stereotype.Service;

import slancer.mindfly.service.account.controller.user.dto.WeChatLoginVerifyDto;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegisteDto;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.bo.WeChatBindBo;

@Service
public class WeChatService {

    public String getOpenId(String code) {
        // if user is exist return token
        // else cache code : (openId,session_key) and return error code
        return "";
    }

    public void regist(WeChatBindBo bindBo,UserEntity userEntity) {

        //get openId by code from cache
        //insert wecahtg account and userInfo

    }
}
