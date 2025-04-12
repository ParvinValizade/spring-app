package paputu.company.az.exception;

import paputu.company.az.exception.constant.CommonErrorCode;

public class AlreadyUserExistsException extends CommonException {

    public AlreadyUserExistsException(String message) {
        super(CommonErrorCode.ALREADY_EXIST, message);
    }

}
