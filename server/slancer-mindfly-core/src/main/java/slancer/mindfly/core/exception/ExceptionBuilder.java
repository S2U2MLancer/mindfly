package slancer.mindfly.core.exception;

import slancer.mindfly.core.errors.IErrorCodeEnum;

public class ExceptionBuilder {

    // max error code, 2^TYPE_LF_SHIFT - 1
    private static final int TYPE_LF_SHIFT = 20;

    /**
     *
     * @param errCode ErrorCodeEnum value
     * @param errMsg Error Message
     * @param <ET> ErrorCodeEnum type inherit from IErrorCodeEnum
     * @return S2u2mSpringException
     */
    public static <ET extends IErrorCodeEnum> S2u2mSpringException build(
            ET errCode, String errMsg) {
        int code = errCode.getTypeCode() << TYPE_LF_SHIFT
                | errCode.getCode();
        S2u2mSpringException exception = new S2u2mSpringException();
        exception.setErrCode(code);
        exception.setErrMsg(errMsg);
        return exception;
    }

    /**
     *
     * @param errCode ErrorCodeEnum value
     * @param <ET> ErrorCodeEnum type inherit from IErrorCodeEnum
     * @return S2u2mSpringException
     */
    public static <ET extends IErrorCodeEnum> S2u2mSpringException build(
            ET errCode) {
        return build(errCode, errCode.toString());
    }
}
