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
import slancer.mindfly.test.AbS2u2mControllerTest;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WeChatControllerTest extends AbS2u2mControllerTest {

    @MockBean
    WeChatService weChatService;
    String token = "123456";

    @Test
    public void login() throws Exception {
        WeChatLoginDTO weChatLoginDTO = new WeChatLoginDTO();
        weChatLoginDTO.setCode("123");
        ObjectMapper objectMapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("login")
        .content(objectMapper.writeValueAsString(weChatLoginDTO)))
                .andExpect(status().isOk())
                .andDo(documentAPI("wechatLogin"))
                .andReturn();
        given(weChatService.login("123")).willReturn("123456");

        WeChatResponseDTO weChatResponseDTO = this.convertResponseToObject(rst,WeChatResponseDTO.class);
        assertEquals(token,weChatResponseDTO.getToken());


    }

    @Test
    public void weChatRegist() throws Exception {
        //prepare
        WeChatRegistDTO weChatRegistDTO = new WeChatRegistDTO();
        weChatRegistDTO.setBirthday(new Date())
                .setCode("123")
                .setGender(GenderEnum.Female)
                .setNickName("123456")
                .setPassword("123456");
        BindWeChatBO bindWeChatBO = new BindWeChatBO();
        UserEntity userEntity = new UserEntity();

        //action
        ObjectMapper objectMapper = new ObjectMapper();
        given(weChatService.regist(bindWeChatBO,userEntity)).willReturn(token);
        MvcResult rst = mockMvc.perform(post("regist")
        .content(objectMapper.writeValueAsString(weChatRegistDTO)))
                .andExpect(status().isOk())
                .andDo(documentAPI("wechatRegist"))
                .andReturn();
        WeChatResponseDTO weChatResponseDTO = this.convertResponseToObject(rst, WeChatResponseDTO.class);
        assertEquals(token,weChatResponseDTO.getToken());
    }

}