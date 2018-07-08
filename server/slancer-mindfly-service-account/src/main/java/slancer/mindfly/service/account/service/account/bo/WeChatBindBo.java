package slancer.mindfly.service.account.service.account.bo;

import org.springframework.beans.BeanUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slancer.mindfly.service.account.controller.user.dto.WeChatRegisteDto;

@Setter
@Getter
@NoArgsConstructor
public class WeChatBindBO {

    private String openId;

}
