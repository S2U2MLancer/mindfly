package slancer.mindfly.service.account.utils.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * class UserTokenConfig
 *
 * @author xiayy860612
 * @date 2018/7/8
 */
@Configuration
public class UserTokenConfig {

    @Bean
    @Primary
    IUserToken userToken() {
        return new UidUserToken();
    }
}
