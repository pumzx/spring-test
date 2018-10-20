package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Configuration
@ComponentScan("serviceimpl")
@EnableScheduling
public class ScheduledFunConfig {
}
