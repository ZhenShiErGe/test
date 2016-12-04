package exception;

import common.ErrorEnum;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class SystemException extends BaseException {
    public SystemException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
