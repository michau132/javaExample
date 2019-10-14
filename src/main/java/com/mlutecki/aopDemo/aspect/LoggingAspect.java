package com.mlutecki.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* addAccount(..))")
    public void beforeAddAcount(JoinPoint joinPoint) {
        System.out.println("Wywoluje @Before adnotacje " + Arrays.asList(joinPoint.getArgs()));
    }

    @After("execution(* com.mlutecki.aopDemo.dao.AccountDAO.addAccount(..))")
    public void afterAddAccount() {
        System.out.println("Już się wykonała metoda");
    }

    @AfterReturning(
            pointcut = "execution(* com.mlutecki.aopDemo.dao.AccountDAO.addAccount(..))",
            returning = "result"
    )
    public void afterReturn( String result) {
        System.out.println("A tutaj mamy return plus wartość zwracana" + result);

    }

    @Around("execution(* com.mlutecki.aopDemo.dao.AccountDAO.addAccount(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Jestem w @Around");
        System.out.println("=========================");
        return joinPoint.proceed();
    }
}
