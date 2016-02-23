package labsrefactoring.gravity;

import com.badlogic.gdx.math.Vector2;

import labsrefactoring.player.Entity;

public class Gravitation {

	float gravity; //= -9.8f;
	
	public Gravitation(float gravity) {

		this.gravity = gravity;
	}
	
	public void gravity(Entity actor, float dt) {
		
			Vector2 speed = actor.getVelocity();
			Vector2 position = actor.getPosition();
		
			if (position.y > 0) { actor.setVelocity(speed.add(0, gravity)); }
		
			actor.setVelocity(speed.scl(dt));
			actor.setPosition(position.add(0, speed.y));
		
			if (position.y < 0) {position.y = 0;}
			actor.setVelocity(speed.scl(1 / dt));
	}


}

