package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import serviceimpl.JavaFunctionService;
import serviceimpl.UseJavaFunctionService;

/**
 * @author panzhixiong
 * @date 2018/10/15
 */
@Configuration
public class JavaFunConfig {
    @Bean
    public JavaFunctionService javaFunctionService() {
        return new JavaFunctionService();
    }

    @Bean
    public UseJavaFunctionService useJavaFunctionService() {
        UseJavaFunctionService useJavaFunctionService = new UseJavaFunctionService();
        useJavaFunctionService.setJavaFunctionService(javaFunctionService());
        return useJavaFunctionService;
    }

}
