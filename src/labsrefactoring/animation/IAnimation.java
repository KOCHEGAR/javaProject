package labsrefactoring.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public interface IAnimation {

	public abstract void setCenter(float centerX, float centerY);
	public abstract void setSize(float width, float height);
	public abstract void flip(boolean flipX, boolean flipY);
	public abstract void update(float delta);
	public abstract void draw(Vector2 actorPos, SpriteBatch batch);
}
