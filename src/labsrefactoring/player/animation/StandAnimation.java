package labsrefactoring.player.animation;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.animation.IAnimation;
import labsrefactoring.animation.MyAnimation;
import labsrefactoring.tools.Constants;

public class StandAnimation implements IAnimation{

	MyAnimation stand;
	

	public StandAnimation() {
		
		//stand = new MyAnimation(Constants.testAnim, 1, 1, 0.5f, 0, 0, 64, 129);
		
		ArrayList<Sprite> standFrames = new ArrayList<Sprite>();
		TextureRegion region = new TextureRegion(Constants.testAnim222);
		
		standFrames.add(new Sprite(region, 20, 0, 68, 119));
		standFrames.add(new Sprite(region, 142, 0, 67, 120));
		standFrames.add(new Sprite(region, 259, 3, 70, 117));
		standFrames.add(new Sprite(region, 378, 1, 71, 119));
		standFrames.add(new Sprite(region, 496, 2, 72, 119));
		standFrames.add(new Sprite(region, 613, 0, 76, 119));
		standFrames.add(new Sprite(region, 732, 0, 76, 119));
		standFrames.add(new Sprite(region, 855, 1, 76, 118));
		
		stand = new MyAnimation(standFrames, 1f); 
		;
		
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


	/*@Override
	public Sprite getFrame() {
		// TODO Auto-generated method stub
		return stand.getFrame();
	}*/
}
