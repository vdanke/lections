package org.step.second.annot;

import java.lang.annotation.*;

@Inherited
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String value() default "empty";
}
