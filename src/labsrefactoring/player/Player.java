package labsrefactoring.player;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.player.animation.StandAnimation;
import labsrefactoring.player.animation.WalkAnimation;

public class Player extends Entity{

	public static final int STAND = 0;
	public static final int WALK  = 1;
	
	private IAnimation currentAnimation;
	private IAnimation[] animations = new IAnimation[]{
		
			new StandAnimation(),
			new WalkAnimation(),
	};
//	PlayerControl input;
	

	
	public Player(float x, float y) {
		super(x, y);
		
		currentAnimation = animations[STAND];
	} 

	
	
	@Override
	public void handleInput(float delta) {

		
	}

	@Override
	public void update(float delta) {
	
		currentAnimation.update(delta);
	}

	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {
		
		currentAnimation.draw(actorPos, batch);
	}



	@Override
	public void setCurrentDirection(Integer Dir) {

		
	}



	@Override
	public void setCurrentState(int state) {

		
	}


	@Override
	public void setCurrentAnimation(int anim) {

		currentAnimation = animations[anim];
	}

	@Override
	public IAnimation getCurrentAnimation() {

		return currentAnimation;
	}


	@Override 
	public void setSize(float width, float height) {
		
		for (IAnimation iAnimation : animations) {
			iAnimation.setSize(width, height);
		}
	}


	@Override
	public void flip(boolean flipX, boolean flipY) {

		for (IAnimation iAnimation : animations) {
			iAnimation.flip(flipX, flipY);
		}
	}
}
