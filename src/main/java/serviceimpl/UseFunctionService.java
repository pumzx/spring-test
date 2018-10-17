package serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panzhixiong
 * @date 2018/10/15
 */
@Service
public class UseFunctionService {
    /**
     * Autowired是把functionService这个bean注入到UseFunctionService这个bean中
     */
    @Autowired
    FunctionService functionService;

    public String sayHello() {
        return functionService.sayHello();
    }
}
