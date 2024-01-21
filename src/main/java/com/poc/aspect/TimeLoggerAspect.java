package com.poc.aspect;

import com.poc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
@Slf4j
public class TimeLoggerAspect {

    //@Pointcut("execution(* com.poc.controller.*.*(..))") // execute pointcut for a particular method
    //@Pointcut("within(com.poc.controller.*)") // execute pointcut within the package
    //@Pointcut("this(com.poc.controller.EmployeeController)") // execute pointcut for the particular class
    @Pointcut("@annotation(com.poc.annotation.TimeLogger)")
    public void pointCut(){}

   /* @Before("pointCut()")
    public void beforeExecution(JoinPoint joinPoint) {
        log.info("Before Timestamp: {}", new Timestamp(System.currentTimeMillis()));
    }

    @After("pointCut()")
    public void afterExecution(JoinPoint joinPoint) {
        log.info("After Timestamp: {}", new Timestamp(System.currentTimeMillis()));
    }


    @AfterReturning(value = "pointCut()", returning = "employee")
    public void afterReturningExecution(JoinPoint joinPoint, Employee employee) {
        log.info("After Returning Timestamp: {}", new Timestamp(System.currentTimeMillis()));
        log.info("Employee is returned: {}", employee);
    }



    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowingExecution(JoinPoint joinPoint, Exception exception) {
        log.info("After Throwing Timestamp: {}", new Timestamp(System.currentTimeMillis()));
        log.info("Exception thrown: {}", exception.getMessage());
    }*/


    @Around("pointCut()")
    public Object aroundExecution(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Around Before Timestamp: {}", new Timestamp(System.currentTimeMillis()));

        Object object = pjp.proceed();

        log.info("Around After Timestamp: {}", new Timestamp(System.currentTimeMillis()));

        return object;
    }
}
