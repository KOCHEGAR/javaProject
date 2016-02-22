package labsrefactoring.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;

public abstract class Entity {

	protected Vector2 position;
	protected Vector2 velocity;

	
	public Entity(float x, float y) {

		 position = new Vector2(x, y);

	}
	
	//если понадобится
	
	
	public void setPosition(float x, float y) { 
		
		position.x = x;
		position.y = y;
		/*sprite.setPosition(x, y);*/
	}
	
	public void setVelocity(float x, float y) {
		velocity.x = x;
		velocity.y = y;
	}
	
	public void setPosX(float x) {
		position.x = x;
	}
	
	public void setPosY(float y) {
		position.y = y;
	}
	
	public void setVelX(float x) {
		velocity.x = x;
	}
	
	public void setVelY(float y) {
		velocity.y = y;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public abstract void setSize(float width, float height);
	public abstract void flip(boolean flipX, boolean flipY);
	public abstract void setCurrentDirection(Integer Dir);
	public abstract IAnimation getCurrentAnimation();
	public abstract void setCurrentState(int state);
	public abstract void setCurrentAnimation(int anim);
	
	public abstract void handleInput(float delta);
	public abstract void update(float delta);
	public abstract void draw(Vector2 actorPos, SpriteBatch batch);

}
