package labsrefactoring.player.animation;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.tools.Constants;

public class StandAnimation implements IAnimation{

	MyAnimation stand;
	

	public StandAnimation() {
		
		stand = new MyAnimation(Constants.testAnim, 1, 1, 0.5f, 0, 0, 64, 129);
		System.out.println("stand init");
	}
	
	@Override
	public void flip(boolean flipX, boolean flipY) {

		stand.flip(flipX, flipY);
	}
	
	@Override
	public void setSize(float width, float height) {

		stand.setSize(width, height);
	}
	
	@Override 
	public void update(float delta) {

		stand.update(delta);
	}
	
	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {
		
		stand.draw(actorPos, batch);
	}

	@Override
	public Sprite getFrame() {
		// TODO Auto-generated method stub
		return stand.getFrame();
	}
}
