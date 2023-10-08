package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.UUID;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public abstract class Base {
    protected final Logger _logger = LoggerFactory.getLogger(Base.class);

    @Autowired
    protected AppConfig _appConfig;

    //@Autowired
    protected Storage _storage;

    protected String _type = this.getClass().getSimpleName(); // type = Klasse
    protected long _created = new Date().getTime(); // timestamp of instance creation (for deletion purposes etc.)
    protected String _id = UUID.randomUUID().toString(); // muss unique für jede Instanz sein, obwohl gleicher type sein kann
    protected boolean _active = true;
    protected boolean _running = false;
    protected String _name = "Base object";
    protected String _description = "";
    protected String _entityLog = this._type + "[" + this._id + "]"; // just for logging purposes, represents the actual unique instance despite multiple processor instances

    //protected Socket _socket; // TODO: ist das hier wirklich sinnvoll, vielleicht nur in TaskProcessor (aber Achtung: config)?

    public Base(String id, String name, String description) {
        if (null != id && !id.isEmpty()) {
            this._id = id;
        }

        if (null != name && !name.isEmpty()) {
            this._name = name;
        }

        if (null != description && !description.isEmpty()) {
            this._description = description;
        }
    }

    public AppConfig getAppConfig() {
        return this._appConfig;
    }

    public Logger getLogger() {
        return this._logger;
    }

    public String getType() {
        return this._type;
    }

    public long getCreated() {
        return this._created;
    }

    // TODO: ist das hier wirklich sinnvoll, vieleicht nur in TaskProcessor (aber Achtung: config)?
    public String getEntityLog() {
        return this._entityLog;
    }

    public void setActive(boolean active) {
        this._active = active;
    }

    public boolean isActive() {
        return this._active;
    }

    public boolean isRunning() {
        return this._running;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getId() {
        return this._id;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getName() {
        return this._name;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public String getDescription() {
        return this._description;
    }

    // TODO: ist das hier wirklich sinnvoll, vieleicht nur in TaskProcessor (aber Achtung: config)?
    public void setStorage(Storage storage) {
        this._storage = storage;
    }

    public Storage getStorage() {
        return this._storage;
    }

    protected void _debug(Object msg) {
        this.getLogger().debug(this.getEntityLog() + ": " + this.prepareString(msg));
    }
    
    protected void _debug(String msg) {
        this.getLogger().debug(this.getEntityLog() + ": "  + this.prepareString(msg));
    }

    protected void _info(Object msg) {
      this.getLogger().info(this.getEntityLog() + ": "  + this.prepareString(msg));
    }

    protected void _info(String msg) {
      this.getLogger().info(this.getEntityLog() + ": "  + this.prepareString(msg));
    }      
    
    protected void _warn(Object msg) {
      this.getLogger().warn(this.getEntityLog() + ": "  + this.prepareString(msg));
    }

    protected void _warn(String msg) {
      this.getLogger().warn(this.getEntityLog() + ": "  + this.prepareString(msg));
    }      
    
    protected void _error(Object msg) {
      this.getLogger().error(this.getEntityLog() + ": "  + this.prepareString(msg));
    }

    protected void _error(String msg) {
      this.getLogger().error(this.getEntityLog() + ": "  + this.prepareString(msg));
    }

    public String prepareString(String message) {
        return (String) message;
    }

    public String prepareString(Object message) {
        return message.toString();
    }      

    public abstract Object toStatus();
}

