package serviceimpl;

import aop.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Service
public class AopAnnotationFunctionService {
    @Action(name = "注解式拦截add方法")
    public void add(){}
}
