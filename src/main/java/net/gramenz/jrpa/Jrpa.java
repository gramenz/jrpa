package net.gramenz.jrpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.gramenz.jrpa.lib.Base;

@SpringBootApplication
public class Jrpa extends Base {
    public Jrpa() {
        super("", "", "");
    }

    public static void main(String[] args) {
       Jrpa jrpa = new Jrpa();
       jrpa._preInit();
       SpringApplication.run(Jrpa.class, args);
       jrpa._postInit();
    }

    protected void _preInit() {
        this.getLogger().info("Jrpa is starting...");
    }

    protected void _postInit() {
    }    

    public Object toStatus() {
        // TODO



        return new Object(); 
    }
}
