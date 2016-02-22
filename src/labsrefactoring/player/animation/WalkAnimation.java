package labsrefactoring.player.animation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.tools.Constants;

public class WalkAnimation implements IAnimation {

	
	MyAnimation walk;
	
	public WalkAnimation() {

		walk = new MyAnimation(Constants.testAnim, 9, 1, 1f, 64, 0, 64, 129);
		System.out.println("walk init");
	}
	
	@Override
	public void flip(boolean flipX, boolean flipY) {
		
		walk.flip(flipX, flipY);
	}

	@Override
	public void setSize(float width, float height) {

		walk.setSize(width, height);
	}
	
	@Override
	public void update(float delta) {

		walk.update(delta);
	}

	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {

		walk.draw(actorPos, batch);
	}

	@Override
	public Sprite getFrame() {
		// TODO Auto-generated method stub
		return walk.getFrame();
	}
}
