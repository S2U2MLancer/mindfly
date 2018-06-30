package slancer.mindfly.service.account.utils.encrypt.password;

import slancer.mindfly.core.exception.ExceptionBuilder;
import slancer.mindfly.service.account.error.AccountErrorCodeEnum;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * class MD5PasswordEncrypt
 *
 * @author xiayy860612
 * @date 2018/6/30
 */
public final class MD5PasswordEncrypt implements IPasswordEncrypt {

    @Override
    public String encrypt(String orig) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(orig.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.PasswordEncryptError,
                    e.toString());
        }
    }
}
