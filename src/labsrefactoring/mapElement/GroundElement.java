package labsrefactoring.mapElement;

import com.badlogic.gdx.math.Rectangle;

import labsrefactoring.player.Entity;
import labsrefactoring.player.Player;

public class GroundElement {

	private Rectangle ground;
	
	public GroundElement(float x, float y, float width, float height) {

		ground = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getGround() {
		
		return ground; 
	}
	
	public float getX() {
		return ground.getX();
	}
	public float getY() {
		return ground.getY();
	}
	public float getRight(){
		return ground.getX() + ground.getWidth();
	}
	public float getTop() {
		return ground.getY() + ground.getHeight();
	}
	public float getWidth() {
		return ground.getWidth();
	}
	public float getHeight() {
		return ground.getHeight();
	}
	
	public void updateCurrentGround(Entity actor, GroundElement element) {
		
		float playerRight = actor.getPosition().x + actor.getRect().getWidth()/2;
		float playerLeft = actor.getPosition().x -  actor.getRect().getWidth()/2;
		float platformLeft = actor.getCurrentGround().getX();
		float platformRight = platformLeft + actor.getCurrentGround().getWidth();
		
			if (playerRight <= platformLeft) {
				actor.setCurrentState(Player.IN_AIR_STATE);
			}
			
			if (playerLeft >= platformRight) {
				actor.setCurrentState(Player.IN_AIR_STATE);
			}
	}
}
