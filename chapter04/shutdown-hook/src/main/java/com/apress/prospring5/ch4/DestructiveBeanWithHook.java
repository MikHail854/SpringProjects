package com.apress.prospring5.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithHook {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of "
                    + DestructiveBeanWithHook.class);
        }

        this.file = new File(filePath);
        file.createNewFile();

        System.out.println("File exist: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.out.println("ERROR: failed to delete file ");
        }

        System.out.println("File exist: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        //GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DestructiveBeanWithHook.class);
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.registerShutdownHook();
        ctx.refresh();

        ctx.getBean(DestructiveBeanWithHook.class);

        ctx.close();
    }
}
