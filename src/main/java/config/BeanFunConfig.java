package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import serviceimpl.BeanFunctionService;
import serviceimpl.BeanJsrFunctionService;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Configuration
@ComponentScan("serviceimpl")
public class BeanFunConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanFunctionService beanFunctionService() {
        return new BeanFunctionService();
    }

    @Bean
    public BeanJsrFunctionService beanJsrFunctionService() {
        return new BeanJsrFunctionService();
    }
}
