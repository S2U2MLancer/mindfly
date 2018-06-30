package slancer.mindfly.service.account.utils.encrypt.password;

import slancer.mindfly.core.exception.ExceptionBuilder;
import slancer.mindfly.service.account.error.AccountErrorCodeEnum;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * class MD5PasswordEncrypt
 *
 * @author xiayy860612
 * @date 2018/6/30
 */
public final class OldMD5PasswordEncrypt implements IPasswordEncrypt {

    @Override
    public String encrypt(String orig) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] arr = md5.digest(orig.getBytes(StandardCharsets.UTF_8));
            return toHex(arr).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw ExceptionBuilder.build(AccountErrorCodeEnum.PasswordEncryptError,
                    e.toString());
        }
    }

    private String toHex(byte[] bytes) {
        final char[] hexDigits = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(hexDigits[(bytes[i] >> 4) & 0x0f]);
            ret.append(hexDigits[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

}
