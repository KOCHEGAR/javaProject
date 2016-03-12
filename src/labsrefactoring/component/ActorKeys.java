package labsrefactoring.component;

import java.util.HashMap;

public class ActorKeys {
	
	private HashMap<Integer, Boolean> keys;
	
	public ActorKeys() {

		keys = new HashMap<Integer, Boolean>();
	}
	
	public void setKey(int key, boolean pressed) {
		keys.put(key, pressed);
	}
	public boolean getKey(int key) { 
		if (!keys.containsKey(key)) return false;
		return keys.get(key); 
	}
}
