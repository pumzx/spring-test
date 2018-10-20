package annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {};
}
