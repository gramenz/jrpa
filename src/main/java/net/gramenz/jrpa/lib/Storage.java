package net.gramenz.jrpa.lib;

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
