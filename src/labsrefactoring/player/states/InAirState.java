package labsrefactoring.player.states;

import labsrefactoring.component.PlayerInput;
import labsrefactoring.gravity.Gravitation;
import labsrefactoring.player.Entity;
import labsrefactoring.state.IState;

public class InAirState implements IState{

	Gravitation grav = new Gravitation(-9.8f);
	
	@Override
	public void update(Entity actor, float delta){
		
		grav.applyGravity(actor, delta);
		PlayerInput.moveLeft(-130);
		PlayerInput.moveRight(130);
		//System.out.println(actor.getPosition().y);
		if (actor.getPosition().y - actor.getRect().height/2 <= 0){// 
			
			actor.setVelY(0);
			actor.setCurrentState(Entity.ON_GROUND_STATE);
			System.out.println("onGroundState");
		}
	}
}
