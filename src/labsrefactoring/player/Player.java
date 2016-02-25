package labsrefactoring.player;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.player.animation.PlayerAnimations;
import labsrefactoring.player.states.PlayerStates;


public class Player extends Entity{

	

//	PlayerControl input;
	PlayerAnimations animations;
	PlayerStates states;
	Sprite colorRect = new Sprite(new TextureRegion(new Texture("ground.jpg")));//for test
	

	
	public Player(float x, float y) {
		super(x, y);
		
		colorRect.setColor(Color.CHARTREUSE);
		animations = new PlayerAnimations();
		states = new PlayerStates();
		setCurrentState(IN_AIR_STATE);
		setCurrentAnimation(ANIM_STAND);
	} 

	
	
	@Override
	public void handleInput(float delta) {

		
	}

	
	@Override
	public void update(float delta) {
			
		
		if (currentAnimation != null) { currentAnimation.update(delta); }
		if (currentState != null) { currentState.update(this, delta); }
	}

	@Override
	public void draw(SpriteBatch batch) {
		
		colorRect.setPosition(position.x, position.y);
		colorRect.draw(batch);
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
		colorRect.setSize(width, height);
		for (IAnimation animation : animations.getAll()) {
			animation.setSize(width, height);
		}
		setCenter(width/2, height/2);
		System.out.println(rectangle.getWidth() + " rw - rh " + rectangle.getHeight());
	}


	@Override
	public void flip(boolean flipX, boolean flipY) {

		currentAnimation.flip(flipX, flipY);
		/*for (IAnimation iAnimation : animations.getAll()) {
			iAnimation.flip(flipX, flipY);
		}*/
	}



	@Override
	public void setCenter(float centerX, float centerY) {
		// TODO Auto-generated method stub
		for (IAnimation animation : animations.getAll()) {
			animation.setCenter(centerX, centerY);
		}
	}
}
