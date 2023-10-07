package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Console {
    public enum Color {
        /* Textfarbe
        RESET("\u001B[0m"),
        WHITE("\u001B[37m"),
        GREEN("\u001B[32m"),
        LIGHTBLUE("\u001B[94m"),
        YELLOW("\u001B[33m"),
        RED("\u001B[31m");
        */

        /* Hintergrundfarbe */
        RESET("\u001B[0m"),
        WHITE("\u001B[47m"),
        GREEN("\u001B[42m"),
        LIGHTBLUE("\u001B[104m"),
        YELLOW("\u001B[43m"),
        RED("\u001B[41m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    @Autowired
    protected AppConfig _appConfig;

	public AppConfig getConfig() {
		return this._appConfig;
	}

    public void debug(Object message) {
        if (this.getConfig().isDebug()) {
            System.out.println(Color.GREEN + "[D] " + this._getMoment() + " " + this.prepareString(message) + Color.RESET);
        }
    }

    public void log(Object message) {
        System.out.println("[L] " + this._getMoment() + " " + this.prepareString(message));
    }

    public void info(Object message) {
        System.out.println(Color.LIGHTBLUE + "[I] " + this._getMoment() + " " + this.prepareString(message) + Color.RESET);
    }

    public void warn(Object message) {
        System.err.println(Color.YELLOW + "[W] " + this._getMoment() + " " + this.prepareString(message) + Color.RESET);
    }

    public void error(Object message) {
        System.err.println(Color.RED + "[E] " + this._getMoment() + " " + this.prepareString(message) + Color.RESET);
    }

    public String prepareString(String message) {
        return (String) message;
    }

    public String prepareString(Object message) {
        return message.toString();
    }

    protected String _getMoment() {
        return new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());
    }
}

