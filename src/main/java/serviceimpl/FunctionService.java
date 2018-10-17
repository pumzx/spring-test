package serviceimpl;

import org.springframework.stereotype.Service;

/**
 * @author panzhixiong
 * @date 2018/10/15
 */
@Service
public class FunctionService {
    public String sayHello() {
        return "hello,world!";
    }
}
