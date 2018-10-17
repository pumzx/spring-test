package aop.aspect;

import aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(aop.annotation.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("aop 注解式拦截，after......");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("after 注解式拦截" + action.name());
    }

    @Before("execution(* serviceimpl.AopFunctionService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("aop 方法规则式拦截，before......");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("before 方法规则式拦截："+method.getName());
    }
}
