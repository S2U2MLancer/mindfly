package slancer.mindfly.service.account.utils.encrypt.password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class PasswordEncryptConfig
 *
 * @author xiayy860612
 * @date 2018/6/30
 */
@Configuration
public class PasswordEncryptConfig {

    @Bean
    IPasswordEncrypt pwdEncrypt() {
        return new MD5PasswordEncrypt();
    }
}
