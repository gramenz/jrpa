package net.gramenz.jrpa.lib;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Console {
    private boolean debug;

    public Console() {
        this.setDebug(false);
    }

    public Console(boolean debug) {
        this.setDebug(debug);
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public void debug(Object message) {
        if (debug) {
            System.out.println("[D] " + getMoment() + " " + prepareString(message));
        }
    }

    public void log(Object message) {
        System.out.println("[L] " + getMoment() + " " + prepareString(message));
    }

    public void info(Object message) {
        System.out.println("[I] " + getMoment() + " " + prepareString(message));
    }

    public void warn(Object message) {
        System.err.println("[W] " + getMoment() + " " + prepareString(message));
    }

    public void error(Object message) {
        System.err.println("[E] " + getMoment() + " " + prepareString(message));
    }

    public static String prepareString(Object message) {
        if (message instanceof String) {
            return (String) message;
        } else {
            return message.toString();
        }
    }

    private String getMoment() {
        SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");

        return sdf.format(new Date());
    }
}

