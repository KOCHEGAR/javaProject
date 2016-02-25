package labsrefactoring.state;

import java.util.HashMap;


// класс для наследования
public abstract class States {

	
	protected HashMap<Integer, IState> states;
	
	public States() {

		states = new HashMap<Integer, IState>();
	}
	
	protected abstract void init();
	
	public IState get(int state){
		
		if (states.containsKey(state)){
			return states.get(state);
		}
		else { return null; }
	}
}
