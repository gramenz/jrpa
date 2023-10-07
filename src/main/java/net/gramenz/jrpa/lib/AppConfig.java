package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppConfig {
  @Value("${server.port}")
  protected int _serverPort;

  @Value("${debug}")
  protected boolean _debug;

  @Value("${processor.iteration.duration}")
  protected int _processorIterationDuration;

  public int getServerPort() {
      return this._serverPort;
  }

  public boolean isDebug() {
      return this._debug;
  }

  public int getProcessorIterationDuration() {
      return this._processorIterationDuration;
  }
}
