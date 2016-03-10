package labsrefactoring.player.states;

import labsrefactoring.component.ActorKeys;
import labsrefactoring.component.PlayerInput;
import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;
import labsrefactoring.state.IState;

public class OnGroundState implements IState {

	
	@Override
	public void update(Entity actor, float delta) {
		
		/*ActorKeys keys = actor.getKeys();
		
		if (keys.getKey(Player.JUMP)) {
			
			actor.setVelocity(0, 300);
			actor.setCurrentState(Entity.IN_AIR_STATE);
			System.out.println("inAirState");
		}	*/
		
		if (PlayerInput.ifNoDirection()) {
			
			PlayerInput.moveLeft(-10f);
			PlayerInput.moveRight(110f);
		}
	}
}
