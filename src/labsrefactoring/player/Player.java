package labsrefactoring.player;



import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.player.animation.PlayerAnimations;
import labsrefactoring.player.playerInput.PlayerInput;
import labsrefactoring.player.states.PlayerStates;


public class Player extends Entity{

	public static final float MAX_SPEED = 150;
	public static final float MAX_JUMP_HEIGHT = 300;
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int JUMP = 2;
	//public static final int DOWN = 3;

	PlayerAnimations animations;
	PlayerStates states;
	//Sprite colorRect = new Sprite(new TextureRegion(new Texture("ground.jpg")));//for test
	

	
	public Player(float x, float y) {
		super(x, y);
		
	//	colorRect.setColor(Color.CHARTREUSE);
		animations = new PlayerAnimations();
		states = new PlayerStates();
		setCurrentState(IN_AIR_STATE);
		setCurrentAnimation(ANIM_JUMP);
		PlayerInput.setActorForControl(this);
	} 

	@Override
	public void handleInput(float delta) {

		PlayerInput.handleInput(delta);
	}

	@Override
	public void update(float delta) {
		
		if (velocity.x > 0) { directionRight = true;      flip(directionRight, false); }
		else if (velocity.x < 0) { directionRight = false; flip(directionRight, false);}
		
		//if (currentGround != null) { currentGround.updateCurrentGround(this, currentGround); }
		if (currentAnimation != null) { currentAnimation.update(delta); }
		if (currentState != null) { currentState.update(this, delta); }
	}

	@Override
	public void draw(SpriteBatch batch) {
		
		//colorRect.setCenter(position.x, position.y);
		//colorRect.draw(batch);
		if (currentAnimation != null) { currentAnimation.draw(position, batch); }
	}

	@Override
	public void setCurrentDirection(Integer Dir) {

		
	}

	@Override
	public void setCurrentState(int state) {
		currentState = states.get(state);
	}

	@Override
	public void setCurrentAnimation(int anim) {
		currentAnimation = animations.get(anim);
	}

	@Override
	public IAnimation getCurrentAnimation() {
		return currentAnimation;
	}

	@Override 
	public void setSize(float width, float height) {
		
		rectangle.setSize(width, height);
		//colorRect.setSize(width, height);
		for (IAnimation animation : animations.getAll()) {
			animation.setSize(width, height);
		}

		System.out.println(rectangle.getWidth() + " rw - rh " + rectangle.getHeight());
	}

	@Override
	public void flip(boolean flipX, boolean flipY) {

		//currentAnimation.flip(flipX, flipY);
		for (IAnimation iAnimation : animations.getAll()) {
			iAnimation.flip(flipX, flipY);
		}
	}

	@Override
	public int getCurrentState() {
		return states.getCurrentStateIndex();
	}

	@Override
	public boolean getDirectionRight() {

		return  directionRight;
	}
}
