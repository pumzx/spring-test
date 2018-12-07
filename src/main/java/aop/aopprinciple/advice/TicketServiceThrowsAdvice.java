package aop.aopprinciple.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author panzhixiong
 * @date 2018/12/3
 */
public class TicketServiceThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        System.out.println("after throwing");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("调用过程出错！");
    }

}
