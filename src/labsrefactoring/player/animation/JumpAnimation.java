package labsrefactoring.player.animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.tools.Constants;

public class JumpAnimation implements IAnimation{
	
	MyAnimation jump;
	
	public JumpAnimation() {

		//jump = new MyAnimation(Constants.explosion, 4, 4, 1.1f, 0, 0, 64, 64);
	    
		ArrayList<Sprite> jumpFrames = new ArrayList<Sprite>();
		TextureRegion region = new TextureRegion(Constants.testAnim222);
		
		jumpFrames.add(new Sprite(region, 16, 378, 93, 103));
		jumpFrames.add(new Sprite(region, 139, 388, 85, 86));
		jumpFrames.add(new Sprite(region, 262, 382, 74, 79));
		jumpFrames.add(new Sprite(region, 381, 374, 80, 88));
		jumpFrames.add(new Sprite(region, 494, 378, 96, 90));
		jumpFrames.add(new Sprite(region, 614, 384, 91, 91));
		jumpFrames.add(new Sprite(region, 732, 387, 89, 92));
		
		jump = new MyAnimation(jumpFrames, 1f);
		System.out.println("jump init");
	}

	@Override
	public void setSize(float width, float height) {

		jump.setSize(width, height);
	}

	@Override
	public void flip(boolean flipX, boolean flipY) {

		jump.flip(flipX, flipY);
	}

	@Override
	public void update(float delta) {

		jump.update(delta);
	}

	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {

		jump.draw(actorPos, batch);
	}

}
