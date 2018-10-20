package annotation;

import java.lang.annotation.*;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
