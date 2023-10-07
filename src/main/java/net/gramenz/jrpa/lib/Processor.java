package net.gramenz.jrpa.lib;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class Processor extends Base {
    public Processor() {
        super("", "", "");
    }

    @Scheduled(fixedRateString = "#{appConfig.getProcessorIterationDuration}")
    public void run() {

        this._log("CONFIG: SERVER_PORT: " + this.getAppConfig().getServerPort() + ", DEBUG: " + this.getAppConfig().isDebug() + ",  ITERATION: " + this.getAppConfig().getProcessorIterationDuration());
        this._debug("TEST");
        this._log("TEST");                   
        this._info("TEST");
        this._warn("TEST");
        this._error("TEST");

        this._log("Processor.run...");
    }

    public Object toStatus() {
        // TODO



        return new Object(); 
    }
}
