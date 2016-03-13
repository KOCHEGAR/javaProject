package labsrefactoring.player.states;

import labsrefactoring.component.PlayerInput;
import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;
import labsrefactoring.state.IState;

public class OnGroundState implements IState {

	
	@Override
	public void update(Entity actor, float delta) {
		
		
		
		if (PlayerInput.checkJump()) {
			
			PlayerInput.jump(Player.MAX_JUMP_HEIGHT);
			
			System.out.println("inAirState");
			return;
		}	
		
		
		if (PlayerInput.ifNoDirection()) {
			
			PlayerInput.moveLeft(-Player.MAX_SPEED);
			PlayerInput.moveRight(Player.MAX_SPEED);
		}
	}
}
