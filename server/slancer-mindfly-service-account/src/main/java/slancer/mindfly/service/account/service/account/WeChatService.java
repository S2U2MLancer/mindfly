package slancer.mindfly.service.account.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slancer.mindfly.core.exception.ExceptionBuilder;
import slancer.mindfly.service.account.auth.realm.UserTokenAuth;
import slancer.mindfly.service.account.entity.account.WechatAccountEntity;
import slancer.mindfly.service.account.error.AccountErrorCodeEnum;
import slancer.mindfly.service.account.service.UserService;
import slancer.mindfly.service.account.service.account.bo.WeChatGetOpenIdBO;
import slancer.mindfly.service.account.service.account.bo.WeChatOpenIdBO;
import slancer.mindfly.service.account.dao.WeChatAccountDAO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.AccessOtherServices;
import slancer.mindfly.service.account.service.account.bo.BindWeChatBO;

import java.time.Instant;
import java.util.Date;

@Service
public class WeChatService {

    @Autowired
    AccessOtherServices accessOtherServices;

    @Autowired
    WeChatAccountDAO weChatAccountDAO;
    @Autowired
    UserService userService;

    public String getOpenId(String code) {
        // if user is exist return token

        WeChatGetOpenIdBO getOpenIdBO = new WeChatGetOpenIdBO(code,"","","");
        WeChatOpenIdBO weChatOpenIdBO = accessOtherServices.weChatLogin(getOpenIdBO);
        UserTokenAuth userTokenAuth = null;
        UserEntity userEntity = weChatAccountDAO.getById(weChatOpenIdBO.getOpenId());
        if (userEntity != null) {
            userTokenAuth = new UserTokenAuth(userEntity.getId());
        }  else {
            //TODO cache code and openID
        }
        return userTokenAuth.getToken();
    }

    public String regist(BindWeChatBO bindBo, UserEntity userEntity) {

        String code = "";
        String openId = "";
        //TODO get code and openId from cache

        if ( weChatAccountDAO.getById(openId) != null) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.WechatRegisted,
                    String.format("wechant account [%s] has existed", openId));
        }
        UserEntity saved = userService.create(userEntity);
        WechatAccountEntity wechatAccountEntity = new WechatAccountEntity()
                .setOpenId(openId)
                .setUserId(saved.getId())
                .setCreateDate(Date.from(Instant.now()));

        weChatAccountDAO.create(wechatAccountEntity);
        UserTokenAuth userTokenAuth = new UserTokenAuth(userEntity.getId());
        return userTokenAuth.getToken();
    }
}
