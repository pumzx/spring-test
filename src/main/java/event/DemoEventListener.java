package event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("I'm listener,i receive your msg:" + msg);
    }
}
