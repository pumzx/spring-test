package aop.aopprinciple.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author panzhixiong
 * @date 2018/12/3
 */
public class TicketServiceAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("around advice:begin");
        Object obj = methodInvocation.proceed();
        System.out.println("around advice:finish");
        return obj;
    }
}
