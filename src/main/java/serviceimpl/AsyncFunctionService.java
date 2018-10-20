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
    public Integer execGetInt(Integer i) {
        return i;
    }

    @Async
    public Integer execAddInt(Integer i) {
        return i+1;
    }
}
