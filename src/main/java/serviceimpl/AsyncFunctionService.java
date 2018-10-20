package serviceimpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Service
public class AsyncFunctionService {

    @Async
    public void execGetInt(Integer i) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(i);
    }

}
