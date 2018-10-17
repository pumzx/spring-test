package serviceimpl;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
public class BeanFunctionService {

    public BeanFunctionService() {
        super();
        System.out.println("@Bean-construct-method");
    }
    public void init() {
        System.out.println("@Bean-init-method");
    }
    public void destroy() {
        System.out.println("@Bean-destroy-method");
    }
}
