package labsrefactoring.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import labsrefactoring.screens.titleUI.TitleUI;
import labsrefactoring.tools.Constants;

public class TitleScreen extends AbstractScreen{

	
	private TitleUI titleUI;
	
	public TitleScreen() {
		super();
		
		viewport = new StretchViewport(Constants.V_WIDTH, Constants.V_HEIGHT, camera);
		titleUI = new TitleUI(viewport, Constants.BATCH);
	}
	
	
	@Override
	protected void handleInput(float dt) {
//		if (Gdx.input.justTouched()) {
//	
//			ScreenManager.setCurrentScreen("gameplay");
//		}
	}

	@Override
	public void resize(int width, int height) {
		
		viewport.update(width, height); //обязательно
		
	//	menuUI.resize(width, height); // не ясно, нужно или нет
		Gdx.app.log(TAG, " resized");
	}

	@Override
	public void update(float delta) {
		
		
		titleUI.update(delta);
		//camera.update(); // не ясно, нужно или нет
	}

	@Override
	public void draw(SpriteBatch sb) {
		
		titleUI.draw();
	}

	@Override
	public void dispose() {

		titleUI.dispose();
		Gdx.app.log(TAG, " Disposed");
	}

	@Override
	public void switchOff() {
		titleUI.setTitleIsActive(false);
	}


	@Override
	public void switchOn() {
		
		titleUI.setTitleIsActive(true);
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		resize(w, h);
		titleUI.resize(w, h);
	}
}
