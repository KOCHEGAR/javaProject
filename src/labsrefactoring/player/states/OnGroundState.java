package labsrefactoring.player.states;

import labsrefactoring.component.ActorKeys;
import labsrefactoring.component.PlayerInput;
import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;
import labsrefactoring.state.IState;

public class OnGroundState implements IState {

	
	@Override
	public void update(Entity actor, float delta) {
		
		
		
		if (PlayerInput.checkJump()) {
			
			PlayerInput.jump(300f);
			
			System.out.println("inAirState");
		//	return;
		}	
		
		
		if (PlayerInput.ifNoDirection()) {
			
			PlayerInput.moveLeft(-100f);
			PlayerInput.moveRight(100f);
			System.out.println("here!!!");
		}
	}
}
