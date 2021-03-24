package com.apress.prospring5.ch4;



import java.io.File;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithJSR250 {

    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception{
        System.out.println("Initializing bean");

        if (filePath == null){
            throw new IllegalArgumentException("You must specify the  filePath property of " + DestructiveBeanWithJSR250.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exist: " + file.exists());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying Bean");

        if (!file.delete()){
            System.out.println("ERROR: failed to delete file.");
        }

        System.out.println("File exist: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception{
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}
