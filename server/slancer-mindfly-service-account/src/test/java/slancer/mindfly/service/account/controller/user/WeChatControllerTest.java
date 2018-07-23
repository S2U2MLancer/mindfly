package slancer.mindfly.service.account.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import slancer.mindfly.service.account.controller.user.dto.UserInfoDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatLoginDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegistDTO;
import slancer.mindfly.service.account.controller.user.dto.WeChatResponseDTO;
import slancer.mindfly.service.account.entity.UserEntity;
import slancer.mindfly.service.account.enums.GenderEnum;
import slancer.mindfly.service.account.service.account.WeChatService;
import slancer.mindfly.service.account.service.account.bo.BindWeChatBO;
import slancer.mindfly.service.account.service.account.bo.WeChatRegistBO;
import slancer.mindfly.test.AbS2u2mControllerTest;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeChatControllerTest extends AbS2u2mControllerTest {

    @MockBean
    WeChatService weChatService;
    String token = "123456";

    @Test
    public void login() throws Exception {
        String code = "123456";
        String url = "/account/weChat/login" +"/" + code;
        doReturn(token).when(weChatService).login(any(String.class));
        MvcResult rst = mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(documentAPI("wechatLogin"))
                .andReturn();


        WeChatResponseDTO weChatResponseDTO = this.convertResponseToObject(rst,WeChatResponseDTO.class);
        assertEquals(token,weChatResponseDTO.getToken());


    }

    @Test
    public void weChatRegist() throws Exception {
        //prepare
        WeChatRegistDTO weChatRegistDTO = new WeChatRegistDTO();
        weChatRegistDTO.setBirthday(new Date())
                .setCode("033DYZiv1DeEKa0i9ufv1T31jv1DYZiS")
                .setGender(GenderEnum.Female)
                .setNickName("123456")
                .setPassword("123456");
        WeChatRegistBO weChatRegistBO = new WeChatRegistBO();
        UserEntity userEntity = new UserEntity();
        doReturn(token).when(weChatService).regist(any(WeChatRegistBO.class), any(UserEntity.class));

        //action
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("/account/weChat/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weChatRegistDTO)))
                .andExpect(status().isOk())
                .andDo(documentAPI("wechatRegist"))
                .andReturn();
        WeChatResponseDTO weChatResponseDTO = this.convertResponseToObject(rst, WeChatResponseDTO.class);
        assertEquals(token,weChatResponseDTO.getToken());
    }

}