package net.gramenz.jrpa.lib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Storage {
	public enum Type {
		IN("i"),
		OUT("o"),
		COMPLETED("c"),
		BACKLOG("b");

		private final String type;

		Type(String type) {
				 this.type = type;
		}

		@Override
		public String toString() {
				return type;
		}		
	}






}
