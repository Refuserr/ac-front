package pers.ls.exchange.ac.front.util;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    String title()default "";
    int sort() default 0;
}
