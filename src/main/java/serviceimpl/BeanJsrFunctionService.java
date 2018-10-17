package serviceimpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
public class BeanJsrFunctionService {
    public BeanJsrFunctionService() {
        super();
        System.out.println("jsr-construct-method");
    }

    @PostConstruct
    public void init() {
        System.out.println("jsr-init-method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsr-destroy-method");
    }
}
