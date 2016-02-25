package labsrefactoring.player.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.tools.Constants;

public class ExplosionAnim implements IAnimation{
	
	MyAnimation explosion;
	
	public ExplosionAnim() {

		explosion = new MyAnimation(Constants.explosion, 4, 4, 1.1f, 0, 0, 64, 64);
	    System.out.println("expl init");
	}

	@Override
	public void setSize(float width, float height) {

		explosion.setSize(width, height);
	}

	@Override
	public void flip(boolean flipX, boolean flipY) {

		
	}

	@Override
	public void update(float delta) {

		explosion.update(delta);
	}

	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {

		explosion.draw(actorPos, batch);
	}

	@Override
	public void setCenter(float centerX, float centerY) {
		// TODO Auto-generated method stub
		
	}

}
