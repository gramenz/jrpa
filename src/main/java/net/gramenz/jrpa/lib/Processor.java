package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Processor {
    private final Config config;

    @Autowired
    public Processor(Config config) {
        this.config = config;
    }

    @Scheduled(fixedRateString = "#{config.getProcessorIterationDuration}")
    public void run() {

        System.out.println("CONFIG\n  DEBUG: " + this.config.isDebug() + 
                           "\n  ITERATION: " + this.config.getProcessorIterationDuration() + 
                           "\n  WS SERVER PORT: " + this.config.getWsServerPort());
        System.out.println("Processor.run...");
    }
}
