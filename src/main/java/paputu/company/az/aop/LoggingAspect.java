package paputu.company.az.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* paputu.company.az.controller..*(..))")
    public Object logControllerEndpoints(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("MethodName --> {} (With ARGS: ) - {}", methodName, proceedingJoinPoint.getArgs());
            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                            .getRequest();
                String queryString = request.getQueryString();
                log.info("Request URL: {}?{}", request.getRequestURI(), queryString);

                // Xüsusi parametrləri çıxarmaq
                request.getParameterMap()
                        .forEach((paramName, paramValue) -> {
                            log.info("Request Parameter: {} = {}", paramName, paramValue);
                        });

        Object result = proceedingJoinPoint.proceed();
        log.info("MethodName--> {} Response - {}", methodName, result);
        return result;
    }

    // @Before example
    @Before("execution(* paputu.company.az.controller.UserController.*(..))")
    public void beforeUserControllerMethods(JoinPoint jp) {
        log.info("Entering UserController method: {}", jp.getSignature().getName());
        log.info("Entering UserController args: {}", jp.getArgs());
        log.info("Entering UserController class: {}", jp.getTarget().getClass().getName());
    }

    // @After example
    @After("execution(* paputu.company.az.service..*(..))")
    public void afterServiceMethods(JoinPoint joinPoint) throws Throwable {
        log.info("Completed service method: {}", joinPoint.getArgs());
    }

    // @AfterThrowing example
    @AfterThrowing(
            pointcut = "execution(* paputu.company.az.service..*(..))",
            throwing = "ex"
    )
    public void logExceptions(JoinPoint jp, Exception ex) {
        log.error("Exception in {}: {} - {}",
                jp.getSignature(),
                ex.getClass().getSimpleName(),
                ex.getMessage());
    }

    // @AfterReturning example
    @AfterReturning(
            pointcut = "execution(* paputu.company.az.controller..*(..))",
            returning = "result"
    )


    public void logReturnValues(JoinPoint jp, Object result) {
        log.info("Method {} returned: {}", jp.getSignature().getName(), result);
    }
}
