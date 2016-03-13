package labsrefactoring.player.animation;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.player.Entity;
import labsrefactoring.tools.Constants;

public class WalkAnimation implements IAnimation {

	
	MyAnimation walk;
	
	public WalkAnimation() {

		//walk = new MyAnimation(Constants.testAnim, 9, 1, 1f, 64, 0, 64, 129);
		
		ArrayList<Sprite> walkFrames = new ArrayList<Sprite>();
		TextureRegion region = new TextureRegion(Constants.testAnim222);
		
		walkFrames.add(new Sprite(region, 9, 129, 86, 109));
		walkFrames.add(new Sprite(region, 121, 137, 95, 101));
		walkFrames.add(new Sprite(region, 252, 133, 93, 104));
		walkFrames.add(new Sprite(region, 370, 138, 106, 99));
		walkFrames.add(new Sprite(region, 484, 126, 98, 110));
		walkFrames.add(new Sprite(region, 610, 128, 91, 100));
		walkFrames.add(new Sprite(region, 851, 135, 93, 101));
		walkFrames.add(new Sprite(region, 5, 247, 97, 111));
		
		walk = new MyAnimation(walkFrames, 1f);
		walk.setPlayMode(MyAnimation.RUN_REPEAT);
		
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
	public void draw(Entity actorPos, SpriteBatch batch) {

		walk.draw(actorPos, batch);
	}

	@Override
	public void setPlayMode(int mode) {

		walk.setPlayMode(mode);
	}

	@Override
	public void resetAnimation() {

		walk.resetAnimation();
	}
	
	/*@Override
	public Sprite getFrame() {
		// TODO Auto-generated method stub
		return walk.getFrame();
	}*/
}
