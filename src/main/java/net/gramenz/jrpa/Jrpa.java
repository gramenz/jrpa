package net.gramenz.jrpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import net.gramenz.jrpa.lib.Base;

@SpringBootApplication
public class Jrpa extends Base {
    public Jrpa() {
        super("", "", "");
    }

    public static void main(String[] args) {
       Jrpa jrpa = new Jrpa();
       jrpa._preInitialization();
       SpringApplication.run(Jrpa.class, args);
       jrpa._postInitialization();
    }

    protected void _preInitialization() {
        this.getLogger().info("Jrpa is starting...");
    }

    protected void _postInitialization() {
    }    

    public Object toStatus() {
        // TODO



        return new Object(); 
    }
}
