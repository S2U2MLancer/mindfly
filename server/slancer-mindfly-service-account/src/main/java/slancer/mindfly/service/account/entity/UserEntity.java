package slancer.mindfly.service.account.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import slancer.mindfly.service.account.enums.GenderEnum;

import java.time.Instant;
import java.util.Date;

/**
 * class UserEntity
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {
    private String id;
    private String password;
    private String nickName;
    private GenderEnum gender = GenderEnum.Unknown;
    private Date birthday;

    private Date createTime = Date.from(Instant.now());
    private Date updateTime;
    private Boolean deleteFlag = false;

}
