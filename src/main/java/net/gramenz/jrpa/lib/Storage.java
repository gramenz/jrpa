package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;

public class Storage {
    private final Config config;

    @Autowired
    public Storage(Config config) {
        this.config = config;
    }
}
