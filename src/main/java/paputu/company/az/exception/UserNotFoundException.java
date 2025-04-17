package paputu.company.az.exception;

import paputu.company.az.exception.constant.CommonErrorCode;

public class UserNotFoundException extends CommonException {

    public UserNotFoundException(String message) {
        super(CommonErrorCode.USER_NOT_FOUND, message);
    }
}
