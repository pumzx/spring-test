package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Configuration
@ComponentScan({"aop","serviceimpl"})
@EnableAspectJAutoProxy
public class AopFunConfig {
}
