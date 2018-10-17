package serviceimpl;

/**
 * @author panzhixiong
 * @date 2018/10/15
 */
public class UseJavaFunctionService {
    JavaFunctionService javaFunctionService;

    public void setJavaFunctionService(JavaFunctionService javaFunctionService) {
        this.javaFunctionService = javaFunctionService;
    }
    public String sayHello(String name) {
        return javaFunctionService.sayHello(name);
    }
}
