package exception;


import common.ErrorEnum;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class BusinessException extends BaseException {
    public BusinessException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
