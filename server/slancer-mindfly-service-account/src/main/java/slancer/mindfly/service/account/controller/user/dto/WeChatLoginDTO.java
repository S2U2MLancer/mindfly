package slancer.mindfly.service.account.controller.user.dto;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeChatLoginDTO {
    private String code;
}