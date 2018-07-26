package slancer.mindfly.service.account.controller.user.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import slancer.mindfly.common.error.config.ReadOnlyParamConfig;
import slancer.mindfly.service.account.enums.GenderEnum;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class WeChatRegistDTO {
    @ApiModelProperty("code")
    private String code;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("性别")
    private GenderEnum gender = GenderEnum.Unknown;
    @JsonFormat(pattern = ReadOnlyParamConfig.dataFormat)
    @ApiModelProperty(value = "生日", dataType = "dataTime", example = ReadOnlyParamConfig.dataFormat)
    private Date birthday;
}
