package slancer.mindfly.service.account.utils.password;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PasswordGeneralUtil {

    @Value("${password}")
    private String password;

    public String getPassword() {
        return password;
    }
}
