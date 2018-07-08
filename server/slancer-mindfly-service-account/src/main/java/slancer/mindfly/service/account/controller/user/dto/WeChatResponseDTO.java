package slancer.mindfly.service.account.controller.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeChatResponseDTO {
    @ApiModelProperty(value = "token")
    private String token;
}
