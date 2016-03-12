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
			
			//actor.setVelY(300);
			//actor.setCurrentState(Entity.IN_AIR_STATE);
			//actor.setCurrentAnimation(Entity.ANIM_STAND);
			PlayerInput.jump(300f);
			
			System.out.println("inAirState");
			return;
		}	
		
		
		if (PlayerInput.ifNoDirection()) {
			
			PlayerInput.moveLeft(-130f);
			PlayerInput.moveRight(130f);
			System.out.println("here!!!");
		}
	}
}
