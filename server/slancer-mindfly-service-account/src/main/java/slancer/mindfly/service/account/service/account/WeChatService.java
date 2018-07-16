package slancer.mindfly.service.account.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.account.bo.BindWeChatBO;
import slancer.mindfly.service.account.service.account.bo.UserEntityToken;
import slancer.mindfly.service.account.service.account.bo.WeChatLoginBO;
import slancer.mindfly.service.account.service.account.bo.WeChatRegistBO;

@Service
public class WeChatService implements IAccountService<WeChatLoginBO,WeChatRegistBO,UserEntity>{



    @Override
    public UserEntity reg(WeChatRegistBO info) {
        //get openId by code from cache
        //insert wecahtg account and userInfo

        return null;
    }

    @Override
    public UserEntity login(WeChatLoginBO info) {
        // if user is exist return token
        // else cache code : (openId,session_key) and return error code
        return null;
    }

    @Override
    public void bind(UserEntity account, UserEntity user) {

    }

}
