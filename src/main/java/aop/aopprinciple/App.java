package aop.aopprinciple;

import aop.aopprinciple.advice.TicketServiceAfterReturningAdvice;
import aop.aopprinciple.advice.TicketServiceAroundAdvice;
import aop.aopprinciple.advice.TicketServiceBeforeAdvice;
import aop.aopprinciple.advice.TicketServiceThrowsAdvice;
import aop.aopprinciple.service.RailwayStation;
import aop.aopprinciple.service.TicketService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author panzhixiong
 * @date 2018/12/3
 */
public class App {
    public static void main(String[] args) {
        Advice beforeAdvice = new TicketServiceBeforeAdvice();
        Advice afterReturningAdvice = new TicketServiceAfterReturningAdvice();
        Advice aroundAdvice = new TicketServiceAroundAdvice();
        Advice throwsAdvice = new TicketServiceThrowsAdvice();

        RailwayStation railwayStation = new RailwayStation();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterfaces(TicketService.class);
        proxyFactoryBean.setTarget(railwayStation);
        proxyFactoryBean.setProxyTargetClass(false);

        proxyFactoryBean.addAdvice(beforeAdvice);
        proxyFactoryBean.addAdvice(afterReturningAdvice);
        proxyFactoryBean.addAdvice(aroundAdvice);
        proxyFactoryBean.addAdvice(throwsAdvice);

        TicketService ticketService = (TicketService) proxyFactoryBean.getObject();
        ticketService.sellTicket();
        System.out.println("--------------");
        try {
            ticketService.inquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
