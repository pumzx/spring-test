package config;

import condition.MacOsCondition;
import condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import service.ListService;
import serviceimpl.MacOsListService;
import serviceimpl.WindowsListService;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService WindowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacOsCondition.class)
    public ListService MacOsListService() {
        return new MacOsListService();
    }
}
