package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class Config {
  @Value("${server.port}")
  private int serverPort;

  @Value("${ws.server.port}")
  private int wsServerPort;

  @Value("${debug}")
  private boolean debug;

  @Value("${processor.iteration.duration}")
  private int processorIterationDuration;

  public int getServerPort() {
      return this.serverPort;
  }

  public int getWsServerPort() {
      return this.wsServerPort;
  }

  public boolean isDebug() {
      return this.debug;
  }

  public int getProcessorIterationDuration() {
      return this.processorIterationDuration;
  }
}
