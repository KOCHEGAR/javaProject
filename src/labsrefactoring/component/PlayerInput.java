package labsrefactoring.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;

public class PlayerInput {

	public static Entity actor;
	
	private static float dt;
	
	private static boolean a, d, space;
	
	public static boolean hasActor() {
		
		return actor != null;
	}
	
	public static void setActorForControl(Entity actorForControl){
	
		if (hasActor()) {
			return;
		}
		else {
			actor = actorForControl;
		}
	}
	
	public static void handleInput(float delta) {
		
		if (!hasActor()) { return; }
		
		dt = delta;
		
		ActorKeys keys = actor.getKeys();
		
		keys.setKey(Player.LEFT, Gdx.input.isKeyPressed(Input.Keys.A));
		a = keys.getKey(Player.LEFT);
		
		keys.setKey(Player.RIGHT, Gdx.input.isKeyPressed(Input.Keys.D));
		d = keys.getKey(Player.RIGHT);
		
		keys.setKey(Player.JUMP, Gdx.input.isKeyPressed(Input.Keys.SPACE));
		space = keys.getKey(Player.JUMP);
	}
	
	public static boolean ifNoDirection() {
		
		if (a == d) {
			actor.setCurrentAnimation(Player.ANIM_STAND);
			actor.setVelX(0);
			return false;
		}
		return true;
	}
	
	public static boolean checkJump() {
		
		return space;
	}

	private static boolean inAir() {
		
		return actor.getCurrentState() == Player.IN_AIR_STATE;
	}

	public static void moveLeft(float velocityX){
		
		if (a) {
			
			float velX = velocityX * dt;
			actor.setVelX(velX);
			//actor.addVelocityX(velX);
			
			float posX = actor.getPosition().x;
			 velX = actor.getVelocity().x;
			actor.setPosX(posX + velX);
			
			if (!inAir()) { actor.setCurrentAnimation(Player.ANIM_WALK); }
			//actor.flip(true, false);
		}
	}
	
	public static void moveRight(float velocityX){
		
		if (d) {
			
			float velX = velocityX * dt;
			actor.setVelX(velX);
			
			float posX = actor.getPosition().x;
			// пока так
			velX = actor.getVelocity().x;
			
			actor.setPosX(posX + velX);
			
			if (!inAir()) {	actor.setCurrentAnimation(Player.ANIM_WALK); }
			//actor.flip(false, false);
		}
	}
	
	public static void jump(float velocityY){
			
		actor.setVelY(velocityY);
		actor.setCurrentState(Player.IN_AIR_STATE);
		actor.setCurrentAnimation(Player.ANIM_JUMP);
		//actor.flip(true, true);
	}
}
