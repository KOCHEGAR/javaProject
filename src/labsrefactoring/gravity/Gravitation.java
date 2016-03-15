package labsrefactoring.gravity;

import com.badlogic.gdx.math.Vector2;

import labsrefactoring.player.Entity;

public class Gravitation {

	private float gravity; 
	public static float GRAVITY = -9.8f;
	
	public Gravitation(float gravity) {

		this.gravity = gravity;
	}
	
	public void applyGravity(Entity actor, float dt) {
		
		// не забывать,что в джаве всЁ ссылки
			Vector2 speed = actor.getVelocity();
			Vector2 position = actor.getPosition();
		
		//	actor.setVelocity(speed.add(0, gravity)); 
			actor.setVelY(speed.y + gravity);
			
		//	actor.setVelocity(speed.scl(dt));
			actor.setVelY(speed.y * dt);
			
		//	actor.setPosition(position.add(0, speed.y));
			actor.setPosY(position.y + speed.y);
			
		//	actor.setVelocity(speed.scl(1 / dt));
			actor.setVelY(speed.y * (1 / dt));
			System.out.println("rectPos = " + actor.getRect().y + " " + "playerPos = " + actor.getPosition().y);
			
	}
}

