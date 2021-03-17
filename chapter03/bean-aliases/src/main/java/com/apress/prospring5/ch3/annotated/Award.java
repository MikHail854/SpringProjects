package com.apress.prospring5.ch3.annotated;

import org.springframework.core.annotation.AliasFor;

public @interface Award {

    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};

}
