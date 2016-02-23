package labsrefactoring.player;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.player.animation.PlayerAnimations;


public class Player extends Entity{

	public static final int STAND = 0;
	public static final int WALK  = 1;
	

//	PlayerControl input;
	PlayerAnimations animations;
	

	
	public Player(float x, float y) {
		super(x, y);
		
		animations = new PlayerAnimations();
		currentAnimation = animations.get(STAND); 
	} 

	
	
	@Override
	public void handleInput(float delta) {

		
	}

	@Override
	public void update(float delta) {
			
		currentAnimation.update(delta);
	}

	@Override
	public void draw(SpriteBatch batch) {
		
		currentAnimation.draw(position, batch);
	}



	@Override
	public void setCurrentDirection(Integer Dir) {

		
	}



	@Override
	public void setCurrentState(int state) {

		
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
		for (IAnimation iAnimation : animations.getAll()) {
			iAnimation.setSize(width, height);
		}
		System.out.println(rectangle.getWidth() + " rw - rh " + rectangle.getHeight());
	}


	@Override
	public void flip(boolean flipX, boolean flipY) {

		for (IAnimation iAnimation : animations.getAll()) {
			iAnimation.flip(flipX, flipY);
		}
	}
}
