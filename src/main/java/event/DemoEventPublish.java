package event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Component
@Scope("prototype")
public class DemoEventPublish {
    @Autowired
    ApplicationContext applicationContext;

    DemoEvent demoEvent;

    public void publish(String msg) {
        demoEvent = new DemoEvent(this, msg);
        // DemoEvent构造函数里面搞事情
        applicationContext.publishEvent(demoEvent);
    }

    public void publishOther(String msg) {
        demoEvent.setMsg(msg);
        // DemoEvent构造函数里面搞事情
        applicationContext.publishEvent(demoEvent);
    }
}