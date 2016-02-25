package labsrefactoring.player.states;

import labsrefactoring.gravity.Gravitation;
import labsrefactoring.player.Entity;
import labsrefactoring.state.IState;

public class InAirState implements IState{

	Gravitation grav = new Gravitation(-1.9f);
	
	@Override
	public void update(Entity actor, float delta){
		grav.applyGravity(actor, delta);
		System.out.println(actor.getPosition().y);
		if (actor.getPosition().y - actor.getRect().height/2 <= 0) {
			//todo setcenter 
			actor.setCurrentState(Entity.ON_GROUND_STATE);
		}
	}
}
