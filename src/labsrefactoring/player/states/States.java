package labsrefactoring.player.states;

import java.util.HashMap;

import labsrefactoring.state.IState;

public class States {

	
	// field for constants
	public static final int ON_GROUND = 0;
	public static final int IN_AIR = 1;
	
	//
	
	private HashMap<Integer, IState> states;
	
	public States() {

		states = new HashMap<Integer, IState>();
		init();
	}
	
	private void init() {
		
		states.put(0, new OnGroundState());
		states.put(1, new InAirState());
	}
	
	public IState get(int state){
		
		if (states.containsKey(state)){
			return states.get(state);
		}
		else {  return null; }
	}
}
