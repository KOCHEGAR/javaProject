package labsrefactoring.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import labsrefactoring.screens.ScreenManager;
import labsrefactoring.tools.Constants;


public class MyLabsRefactoringMainClass extends ApplicationAdapter {
	
	
	
	@Override
	public void create () {
	
		Gdx.gl.glClearColor(0.7f, 0.3f, 0.1f, 0.7f);
		
		ScreenManager.init();
		ScreenManager.setCurrentScreen("title");
	}		

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		ScreenManager.handleInput(dt);
		ScreenManager.update(dt);
		ScreenManager.draw(Constants.BATCH);
	}
	
	@Override
	public void resize(int width, int height) {

		ScreenManager.resize(width, height);
	}
	
	@Override
	public void dispose() {

		ScreenManager.dispose();
	}
}
