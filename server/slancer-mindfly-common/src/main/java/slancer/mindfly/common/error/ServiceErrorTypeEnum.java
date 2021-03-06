package slancer.mindfly.common.error;

import slancer.mindfly.core.enumhandler.IIntEnum;
import slancer.mindfly.core.errors.S2u2mErrorTypeConfig;

/**
 * class ServiceErrorTypeEnum
 *
 * @author xiayy860612
 * @date 2018/6/7
 */
public enum ServiceErrorTypeEnum implements IIntEnum {
    Common(S2u2mErrorTypeConfig.CustomError + 1),
    AccountService(S2u2mErrorTypeConfig.CustomError + 100),
    ;

    @Override
    public int getValue() {
        return this.value;
    }

    private int value;
    ServiceErrorTypeEnum(int value) {
        this.value = value;
    }
}
