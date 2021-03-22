package com.apress.prospring5.ch4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {

    private File file;
    private String filePath;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exist: " + file.exists());
    }

    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to deleted file.");
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}
