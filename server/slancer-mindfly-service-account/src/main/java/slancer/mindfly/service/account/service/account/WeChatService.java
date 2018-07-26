package slancer.mindfly.service.account.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slancer.mindfly.core.exception.ExceptionBuilder;
import slancer.mindfly.service.account.auth.realm.UserTokenAuth;
import slancer.mindfly.service.account.cache.OpenIdCache;
import slancer.mindfly.service.account.dao.OpenIdDao;
import slancer.mindfly.service.account.entity.account.WechatAccountEntity;
import slancer.mindfly.service.account.error.AccountErrorCodeEnum;
import slancer.mindfly.service.account.service.UserService;
import slancer.mindfly.service.account.service.account.bo.WeChatGetOpenIdBO;
import slancer.mindfly.service.account.service.account.bo.WeChatOpenIdBO;
import slancer.mindfly.service.account.dao.WeChatAccountDAO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.service.AccessOtherServices;
import slancer.mindfly.service.account.service.account.bo.BindWeChatBO;
import slancer.mindfly.service.account.service.account.bo.WeChatRegistBO;
import slancer.mindfly.service.account.utils.password.PasswordGeneralUtil;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class WeChatService {

    @Autowired
    AccessOtherServices accessOtherServices;

    @Autowired
    WeChatAccountDAO weChatAccountDAO;
    @Autowired
    UserService userService;
    @Autowired
    OpenIdDao openIdDao;
    @Autowired
    PasswordGeneralUtil passwordGeneralUtil;


    
    public String login(String code) {

        WeChatGetOpenIdBO getOpenIdBO = new WeChatGetOpenIdBO(code);
        WeChatOpenIdBO weChatOpenIdBO = accessOtherServices.weChatLogin(getOpenIdBO);
        UserTokenAuth userTokenAuth = null;
        UserEntity userEntity = weChatAccountDAO.getById(weChatOpenIdBO.getOpenid());
        if (userEntity != null) {
            userTokenAuth = new UserTokenAuth(userEntity.getId());
            return userTokenAuth.getToken();
        }  else if (null != weChatOpenIdBO.getOpenid()) {
            OpenIdCache openIdCache = new OpenIdCache();
            openIdCache.setOpenId(weChatOpenIdBO.getOpenid());
            openIdDao.insert(code,openIdCache.getOpenId(),1L, TimeUnit.DAYS);
            throw ExceptionBuilder.build(AccountErrorCodeEnum.UserNotExisted,
                    String.format("User Not Existed"));
        }
        throw ExceptionBuilder.build(AccountErrorCodeEnum.GetOpenIdFailed,
                String.format("Get OpenId Failed by code %s",code));
       
    }

    public String regist(WeChatRegistBO bindBo, UserEntity userEntity) {

        String openId = null;
        OpenIdCache openIdCache = new OpenIdCache(openIdDao.get(bindBo.getCode()));
        if (openIdCache == null) {
            WeChatGetOpenIdBO openIdBO = new WeChatGetOpenIdBO();
            openIdBO.setCode(bindBo.getCode());
            WeChatOpenIdBO weChatOpenIdBO = accessOtherServices.weChatLogin(openIdBO);
            openId = weChatOpenIdBO.getOpenid();
        } else {
            openId = openIdCache.getOpenId();
        }

        if (weChatAccountDAO.getById(openId) != null) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.WechatRegisted,
                    String.format("wechant account [%s] has existed", openId));
        }
        String password = passwordGeneralUtil.getPassword();
        userEntity.setPassword(password);
        UserEntity saved = userService.create(userEntity);
        WechatAccountEntity wechatAccountEntity = new WechatAccountEntity()
                .setOpenId(openId)
                .setUserId(saved.getId())
                .setCreateTime(Date.from(Instant.now()));

        weChatAccountDAO.create(wechatAccountEntity);
        UserTokenAuth userTokenAuth = new UserTokenAuth(userEntity.getId());
        return userTokenAuth.getToken();
    }
}
