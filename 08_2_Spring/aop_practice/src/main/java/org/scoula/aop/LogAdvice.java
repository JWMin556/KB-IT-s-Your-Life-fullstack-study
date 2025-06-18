package org.scoula.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LogAdvice {
    @Pointcut("execution(* org.scoula.service.MessageService.*(..))")
    public void messageServiceMethods() {}

    @Before("messageServiceMethods()")
    public void logParameters(JoinPoint joinPoint){
        log.info("[Before] 호출된 메서드: {}" , joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("\uD83D\uDCE9 [Before] 전달받은 파라미터: {}" + arg);
        }
    }

    @Around("messageServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("{} - [Around] 실행 시간: {}ms", joinPoint.getSignature().getName(), (end - start));
        return result;
    }
}
