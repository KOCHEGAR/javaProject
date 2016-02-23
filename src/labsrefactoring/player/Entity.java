package labsrefactoring.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.state.IState;

public abstract class Entity {

	protected Vector2 position;
	protected Vector2 velocity;
	protected Rectangle rectangle;
	protected IAnimation currentAnimation;
//	protected IState currentState;
	
	public Entity(float x, float y) {

		velocity = new Vector2();
		rectangle = new Rectangle();
		position = new Vector2(x, y);
		currentAnimation = null;
	}
	
	//если понадобится
	
	
	public void setPosition(float x, float y) { 
		
		position.x = x;
		position.y = y;
		rectangle.x = x;
		rectangle.y = y;
		/*sprite.setPosition(x, y);*/
	}
	public void setPosition(Vector2 pos){
		position = pos;
		rectangle.setPosition(pos);
	}
	
	public void setVelocity(float x, float y) {
		velocity.x = x;
		velocity.y = y;
	}
	
	public void setVelocity(Vector2 vel) {
		velocity = vel;
	}
	
	public void setPosX(float x) {
		
		position.x = x;
		rectangle.x = x;
	}
	
	public void setPosY(float y) {
		position.y = y;
		rectangle.y = y;
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
	
	public Rectangle getRect() {
		return rectangle;
	}
	
	public abstract void setSize(float width, float height);
	public abstract void flip(boolean flipX, boolean flipY);
	public abstract void setCurrentDirection(Integer Dir);
	public abstract IAnimation getCurrentAnimation();
	public abstract void setCurrentState(int state);
	public abstract void setCurrentAnimation(int anim);
	
	public abstract void handleInput(float delta);
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch batch);

}
