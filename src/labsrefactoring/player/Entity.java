package labsrefactoring.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.component.ActorKeys;
import labsrefactoring.mapElement.GroundElement;
import labsrefactoring.state.IState;

public abstract class Entity {

	//// STATES
	public static final int ON_GROUND_STATE = 0;
	public static final int IN_AIR_STATE    = 1;
	////
	
	/// ANIMATIONS
	public static final int ANIM_WALK  = 0;
	public static final int ANIM_JUMP  = 1;
	public static final int ANIM_FALL  = 2;
	public static final int ANIM_STAND = 3;
	///
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected Rectangle rectangle;
	protected IAnimation currentAnimation;
	protected IState currentState;
	protected GroundElement currentGround;
	protected ActorKeys keys;
	protected boolean directionRight;
	
	
	public Entity(float x, float y) {

		velocity = new Vector2(0, 0);
		rectangle = new Rectangle(x, y, 0, 0);
		position = new Vector2(x, y);
		keys = new ActorKeys();
		directionRight = true;
		currentAnimation = null;
		currentGround = null;
	}
	
	//
	
	
	public ActorKeys getKeys() {
		return keys;
	}
	
	public void setPosition(float x, float y) { 
		
		position.x = x;
		position.y = y;
		rectangle.setCenter(x, y);	
	}
	public void setPosition(Vector2 pos){
		
		position = pos;
		rectangle.setCenter(pos);
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
		rectangle.setCenter(x, rectangle.y-rectangle.height/2);
	}
	
	public void setPosY(float y) {
		
		position.y = y;
		rectangle.setCenter(rectangle.x-rectangle.width/2 , y);
	}
	
	public void setVelX(float x) {
		velocity.x = x;
	}
	
	public void addVelocityX(float dVelX) { velocity.x += dVelX; }
	
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
	
	public void setCurrentGround(GroundElement currentGround) {
		this.currentGround = currentGround;
	}
	public GroundElement getCurrentGround() {
		return currentGround;
	}
	
	public abstract void setSize(float width, float height);
	public abstract void flip(boolean flipX, boolean flipY);
	public abstract void setCurrentDirection(Integer Dir);
	public abstract boolean getDirectionRight();
	public abstract IAnimation getCurrentAnimation();
	public abstract int getCurrentState();
	public abstract void setCurrentState(int state);
	public abstract void setCurrentAnimation(int anim);
	
	
	public abstract void handleInput(float delta);
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch batch);

}
