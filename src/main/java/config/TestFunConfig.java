package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import serviceimpl.TestFunctionService;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Configuration
public class TestFunConfig {

    @Bean
    @Profile(value = "dev")
    public TestFunctionService devTestBean() {
        return new TestFunctionService("from dev");
    }

    @Bean
    @Profile("prd")
    public TestFunctionService prdTestBean() {
        return new TestFunctionService("from prd");
    }
}
