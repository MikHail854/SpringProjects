package com.apress.prospring5.ch4.multiple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.apress.prospring5.ch4.annotated"})
public class AppConfigFour {
}
