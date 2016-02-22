package labsrefactoring.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;



public abstract class AbstractScreen {

	protected String TAG;
	protected OrthographicCamera camera;
	protected Viewport viewport;
	
	public AbstractScreen() {
		
		TAG = getClass().getName();
		camera = new OrthographicCamera();
	}
	
	protected abstract void handleInput(float dt);
	
	public abstract void switchOff();
	public abstract void switchOn(); // дл€ выполнени€ кода при переходах и уходах с экрана
	
	public abstract void resize(int width, int height);
	public abstract void update(float dt);
	public abstract void draw(SpriteBatch sb);
	public abstract void dispose();
}
