package main;

import config.*;
import event.DemoEventPublish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import profile.ProfileDemo;
import service.ListService;
import serviceimpl.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author panzhixiong
 * @date 2018/10/15
 */
public class Main {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        //startFun();
        //startJavaFun();
        //startAopFun();
        //startScopeFun();
        //startElFun();
        //startBeanFun();
        //startProfileFun();
        //startEventFun();
        //startAwareFun();
        //startAsyncFun();
        //startScheduleFun();
        //startConditionFun();
        startWiselyFun();
    }

    private static void startFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FunConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello());
        context.close();
    }

    private static void startJavaFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaFunConfig.class);
        UseJavaFunctionService useJavaFunctionService = context.getBean(UseJavaFunctionService.class);
        System.out.println(useJavaFunctionService.sayHello("panzx"));
        context.close();
    }

    private static void startAopFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopFunConfig.class);
        AopFunctionService aopFunctionService = context.getBean(AopFunctionService.class);
        aopFunctionService.add();
        AopAnnotationFunctionService aopAnnotationFunctionService = context.getBean(AopAnnotationFunctionService.class);
        aopAnnotationFunctionService.add();
        context.close();
    }
    private static void startScopeFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeFunConfig.class);
        ScopeSingleFunctionService singleService1 = context.getBean(ScopeSingleFunctionService.class);
        ScopeSingleFunctionService singleService2 = context.getBean(ScopeSingleFunctionService.class);
        System.out.println("single:"+singleService1.equals(singleService2));

        ScopePrototypeFunctionService prototypeService1 = context.getBean(ScopePrototypeFunctionService.class);
        ScopePrototypeFunctionService prototypeService2 = context.getBean(ScopePrototypeFunctionService.class);
        System.out.println("prototype:"+prototypeService1.equals(prototypeService2));

        context.close();
    }

    private static void startElFun() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElFunConfig.class);
        ElFunConfig elFunConfig = context.getBean(ElFunConfig.class);
        elFunConfig.outputResource();

        context.close();
    }

    private static void startBeanFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanFunConfig.class);
        BeanFunctionService beanFunctionService = context.getBean(BeanFunctionService.class);
        BeanJsrFunctionService beanJsrFunctionService = context.getBean(BeanJsrFunctionService.class);

        context.close();
    }

    private static void startProfileFun() {
        // 带参构造会调用register()和refresh(),但是spring不允许启动时执行多个refresh，所以这里是无参构造。
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("prd");
        context.register(ProfileFunConfig.class);
        context.refresh();

        ProfileDemo profileDemo = context.getBean(ProfileDemo.class);
        System.out.println(profileDemo.getConntent());

        context.close();
    }

    private static void startEventFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventFunConfig.class);
        DemoEventPublish eventPublish = context.getBean(DemoEventPublish.class);
        eventPublish.publish("hello,event!");
        eventPublish.publishOther("other msg");

        context.close();
    }

    private static void startAwareFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareFunConfig.class);
        AwareFunctionService awareFunctionService = context.getBean(AwareFunctionService.class);
        awareFunctionService.outPutInfo();

        context.close();
    }

    private static void startAsyncFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncFunConfig.class);
        AsyncFunctionService asyncFunctionService = context.getBean(AsyncFunctionService.class);
        AsyncFunConfig asyncFunConfig = context.getBean(AsyncFunConfig.class);
        int len = 10;
        for (int i = 0; i < len; i++) {
            asyncFunctionService.execGetInt(i);
        }

        // 正常情况是不需要关闭线程池的
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncFunConfig.closePool();
        context.close();
    }

    private static void startScheduleFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledFunConfig.class);
        System.out.println("now:" + sdf.format(new Date()));

        //context.close();
    }

    private static void startConditionFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + " list cmd is " + listService.showListCmd());

        context.close();
    }

    private static void startWiselyFun() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WiselyFunConfig.class);
        WiselyFunctionService wiselyFunctionService = context.getBean(WiselyFunctionService.class);
        wiselyFunctionService.outputResult();

        context.close();
    }
}
