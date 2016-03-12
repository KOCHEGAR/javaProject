package labsrefactoring.player.states;

import labsrefactoring.player.Entity;
import labsrefactoring.state.States;

public class PlayerStates extends States{

	
	public PlayerStates() {
		super();
		init();
	}
	
	@Override
	protected void init() {

		states.put(Entity.ON_GROUND_STATE, new OnGroundState());
		states.put(Entity.IN_AIR_STATE, new InAirState());
	}
}
