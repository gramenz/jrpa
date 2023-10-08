package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class TaskProcessor extends Base {
  public TaskProcessor(String id, String name, String description) {
    super(id, name, description);
  }

  public Object toStatus() {
    // TODO



    return new Object(); 
}
}
