package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect  //이게 반드시 붙어야 함
@Log4j2
@Component
public class LogAdvice {

    @Before("execution(* org.scoula.sample.service.SampleService*.*(..)))")  //포인트 컷 정의 (SampleService의 모든 메서드를 대상으로 한다는 것이다)
    public void logBefore() {
        log.info("==================================");
    }

    // DI 정검을 진행한다.
    @Before("execution(* org.scoula.sample.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1:" + str1);
        log.info("str2:" + str2);
    }

    //예외처리를 해준다
    @AfterThrowing(pointcut = "execution(* org.scoula.sample.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!!");
        log.info("exception: " + exception);
    }

    @Around("execution(* org.scoula.sample.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));
        
        Object result = null;
        try {
            result = pjp.proceed();  // 실제 메서드 호출
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));
        return result;
    }
}
