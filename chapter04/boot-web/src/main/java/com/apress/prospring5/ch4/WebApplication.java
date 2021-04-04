package com.apress.prospring5.ch4;

import com.apress.prospring5.ch4.ctrl.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication(scanBasePackageClasses = HelloWorld.class)
public class WebApplication {
    private static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(WebApplication.class, args);
        assert (ctx != null);

        logger.info("Application started...");

        System.in.read();

        ctx.close();

    }
}
