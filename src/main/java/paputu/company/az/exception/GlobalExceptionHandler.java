package paputu.company.az.exception;

import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import paputu.company.az.exception.constant.CommonErrorCode;
import paputu.company.az.exception.dto.CommonErrorResponse;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

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
}


