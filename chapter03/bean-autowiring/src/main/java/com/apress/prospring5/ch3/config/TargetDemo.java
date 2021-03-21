package com.apress.prospring5.ch3.config;

import com.apress.prospring5.ch3.sandbox.Bar;
import com.apress.prospring5.ch3.sandbox.Foo;
import com.apress.prospring5.ch3.sandbox.FooImplOne;
import com.apress.prospring5.ch3.sandbox.TrickyTarget;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class TargetDemo {
    @Configuration
    static class TargetConfig {
        @Bean
        public Foo fooImplOne() {
            return new FooImplOne();
        }

        @Bean
        public Foo fooImplTwo() {
            return new FooImplOne();
        }

        @Bean
        public Bar bar() {
            return new Bar();
        }

        @Bean
        public TrickyTarget trickyTarget() {
            return new TrickyTarget();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConfig.class);
        TrickyTarget t = ctx.getBean(TrickyTarget.class);
        ctx.close();
    }
}
