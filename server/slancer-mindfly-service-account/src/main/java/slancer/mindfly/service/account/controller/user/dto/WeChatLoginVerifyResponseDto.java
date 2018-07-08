package slancer.mindfly.service.account.controller.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeChatLoginVerifyResponseDto {
    @ApiModelProperty(value = "weCaht openId")
    private String openId;
}
