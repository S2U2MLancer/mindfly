package slancer.mindfly.service.account.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import slancer.mindfly.service.account.config.ThirdServerProperty;
import slancer.mindfly.service.account.service.account.bo.WeChatGetOpenIdBO;
import slancer.mindfly.service.account.service.account.bo.WeChatOpenIdBO;

@Service
@Slf4j
public class AccessOtherServices {

    @Autowired
    ThirdServerProperty thirdServerProperty;

    public WeChatOpenIdBO weChatLogin(WeChatGetOpenIdBO getOpenIdBO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String url = thirdServerProperty.getWeChatUrl() + "?appid=" + thirdServerProperty.getAppId()
                + "&secret=" + thirdServerProperty.getSecret()
                + "&js_code=" + getOpenIdBO.getCode()
                + "&grant_type=" + thirdServerProperty.getGrantType();
        WeChatOpenIdBO weChatOpenIdBO = new WeChatOpenIdBO();
        try {
            log.info("invoke get openId from wechant");
            ResponseEntity<String> responseEntity =
                    restTemplate.exchange(url,
                            HttpMethod.GET,
                            new HttpEntity<>(headers),
                            String.class);
            log.info("invoke get openId from wechant [" + responseEntity.getBody());
            JSONObject jsonpObject = JSONObject.parseObject(responseEntity.getBody());
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                WeChatOpenIdBO weChatOpenId = new WeChatOpenIdBO();
                weChatOpenId.setOpenId(jsonpObject.getString("openid"));
                weChatOpenId.setSession_key(jsonpObject.getString("session_key"));
                weChatOpenId.setUnionid(jsonpObject.getString("unionid"));
                return weChatOpenId;
            }

        } catch (RestClientException e) {
            log.info(e.getMessage(), e);
        }
        return weChatOpenIdBO;
    }

}
