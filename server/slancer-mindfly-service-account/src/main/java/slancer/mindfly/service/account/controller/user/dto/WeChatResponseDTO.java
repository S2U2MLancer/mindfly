package slancer.mindfly.service.account.controller.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class WeChatResponseDTO {
    @ApiModelProperty(value = "token")
    private String token;
}
