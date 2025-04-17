package paputu.company.az.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import paputu.company.az.exception.constant.CommonErrorCode;
import paputu.company.az.exception.dto.CommonErrorResponse;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({AlreadyUserExistsException.class})
    public CommonErrorResponse handleAlreadyUserExistsException(AlreadyUserExistsException ex) {
        log.error("User Already Exists  {}", ex.getMessage(), ex);
        return CommonErrorResponse.builder()
                .requestId(UUID.randomUUID().toString())
                .errorCode(CommonErrorCode.ALREADY_EXIST)
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler({NotFoundException.class})
    public CommonErrorResponse handleUserNotFoundException(NotFoundException ex) {
        log.error("User Not Found  {}", ex.getMessage(), ex);
        return CommonErrorResponse.builder()
                .requestId(UUID.randomUUID().toString())
                .errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build();
    }
}


