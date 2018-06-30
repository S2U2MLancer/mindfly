package slancer.mindfly.service.account.utils.encrypt.password;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import slancer.mindfly.test.AbS2u2mControllerTest;
import slancer.mindfly.test.AbS2u2mSpringTest;

import static org.junit.Assert.*;

public class PasswordEncryptTest extends AbS2u2mSpringTest {

    @Autowired
    private IPasswordEncrypt passwordEncrypt;

    @Test
    public void encrypt() {
        String pwd = "test@123456";
        String exp = "39c3f82b0f479fa61bf46f78e8b4df35";

        String rst = passwordEncrypt.encrypt(pwd);
        assertTrue(rst.equals(exp));
    }
}