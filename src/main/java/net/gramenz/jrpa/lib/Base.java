package net.gramenz.jrpa.lib;

import net.gramenz.jrpa.lib.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.Date;

@Component
public abstract class Base {
    protected final Config config;
    protected String type = this.getClass().getSimpleName(); // type = Klasse
    protected long created = new Date().getTime(); // timestamp of instance creation (for deletion purposes etc.)
    protected String id = UUID.randomUUID().toString(); // muss unique für jede Instanz sein, obwohl gleicher type sein kann
    protected boolean active = true;
    protected boolean running = false;
    protected String name = "Base object";
    protected String description = "";
    protected String entityLog = this.type + "[" + this.id + "]"; // just for logging purposes, represents the actual unique instance despite multiple processor instances

    @Autowired
    protected Console console;

    protected Storage storage;

    //protected Socket _socket; // TODO: ist das hier wirklich sinnvoll, vielleicht nur in TaskProcessor (aber Achtung: config)?

    @Autowired
    public Base(Config config, String id, String name, String description) {
      this.config = config;

        if (id != null && !id.isEmpty()) {
            this.id = id;
        }

        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public Config getConfig() {
        return this.config;
    }

    public String getType() {
        return this.type;
    }

    public long getCreated() {
        return this.created;
    }

    // TODO: ist das hier wirklich sinnvoll, vieleicht nur in TaskProcessor (aber Achtung: config)?
    public String getEntityLog() {
        return this.entityLog;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Console getConsole() {
        return this.console;
    }

    // TODO: ist das hier wirklich sinnvoll, vieleicht nur in TaskProcessor (aber Achtung: config)?
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public abstract Object toStatus();

    protected void _debug(Object msg) {
        new Console(this.getConfig().isDebug()).debug(this.getEntityLog() + ": " + Console.prepareString(msg));
    }

    protected void _log(Object msg) {
        new Console(this.getConfig().isDebug()).log(this.getEntityLog() + ": " + Console.prepareString(msg));
    }

    protected void _info(Object msg) {
        new Console(this.getConfig().isDebug()).info(this.getEntityLog() + ": " + Console.prepareString(msg));
    }

    protected void _warn(Object msg) {
        new Console(this.getConfig().isDebug()).warn(this.getEntityLog() + ": " + Console.prepareString(msg));
    }

    protected void _error(Object msg) {
        new Console(this.getConfig().isDebug()).error(this.getEntityLog() + ": " + Console.prepareString(msg));
    }
}

