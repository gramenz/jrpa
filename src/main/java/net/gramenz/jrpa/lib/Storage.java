package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;

public class Storage {
	@Autowired
	protected AppConfig _appConfig;

	@Autowired
	protected Console _console;

  public AppConfig getAppConfig() {
	  return this._appConfig;
  }

  public Console getConsole() {
	  return this._console;
  }

}
