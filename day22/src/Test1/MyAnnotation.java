package Test1;/*
@author Serenity
@create 2022-02-11-14:35
*/

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
@Repeatable(MyAnnotations.class)
@Inherited
@Target({TYPE, PARAMETER, CONSTRUCTOR, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default "auguigu";
}
