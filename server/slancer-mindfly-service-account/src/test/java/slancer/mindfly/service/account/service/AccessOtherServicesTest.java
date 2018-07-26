package slancer.mindfly.service.account.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import slancer.mindfly.service.account.config.ThirdServerProperty;
import slancer.mindfly.service.account.service.account.bo.WeChatGetOpenIdBO;
import slancer.mindfly.service.account.service.account.bo.WeChatOpenIdBO;
import slancer.mindfly.test.AbS2u2mSpringTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class AccessOtherServicesTest extends AbS2u2mSpringTest {

    @Autowired
    AccessOtherServices accessOtherServices;
    @Autowired
    ThirdServerProperty thirdServerProperty;

    @Test
    public void weChatLogin_success() {

        //prepare
        WeChatGetOpenIdBO weChatGetOpenIdBO = new WeChatGetOpenIdBO();
        thirdServerProperty.getAppId();
        thirdServerProperty.getGrantType();
        weChatGetOpenIdBO.setCode("033DYZiv1DeEKa0i9ufv1T31jv1DYZiS");
        thirdServerProperty.getSecret();

        //action
        WeChatOpenIdBO weChatOpenIdBO = accessOtherServices.weChatLogin(weChatGetOpenIdBO);
        //verify
            assertThat(weChatOpenIdBO.getOpenid()).isNotBlank();



    }

}