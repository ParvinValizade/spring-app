package paputu.company.az.exception;

import paputu.company.az.exception.constant.CommonErrorCode;

public class NotFoundException extends CommonException {

    public NotFoundException(String message) {
        super(CommonErrorCode.NOT_FOUND, message);
    }
}
