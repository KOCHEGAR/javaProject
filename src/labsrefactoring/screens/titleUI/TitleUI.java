package labsrefactoring.screens.titleUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

import labsrefactoring.screens.ScreenManager;
import labsrefactoring.tools.Constants;

public class TitleUI implements Disposable {

	
	private Stage stage;
	private Skin skin;
	//private	Table table;
	//private Sprite bg;
	private TextButton clickToPlay;
	private TextButton quit;
	
	public TitleUI(Viewport viewport, SpriteBatch batch) {

		stage = new Stage(viewport, batch);
		skin = Constants.SKIN;
		Table table = new Table();
		
		clickToPlay = new TextButton("===> Play <===", skin);
		quit = new TextButton("===> Quit <===", skin);
		
		table.setFillParent(true);
		table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("bg.jpg"))));
		table.center();
		
		table.add(clickToPlay).row();
		table.add(quit);
		
		handleInput(); // задаем события слушателям
		
		stage.addActor(table);	
	}
	
	
	///////////
	public void resize(int screenWidth, int screenHeight) {
		stage.getViewport().update(screenWidth, screenHeight);
		Gdx.app.log("titleUI", "resized");
	}
	
	public void update(float delta) {
		
		stage.act(delta);
		stage.getCamera().update();// не ясно, нужно или нет
	}
	
	public void draw() {
		
		//stage.getBatch().setProjectionMatrix(stage.getCamera().combined);// не ясно, нужно или нет
		stage.draw();
	}
	
	@Override
	public void dispose() {

		if (stage == null) return;
			
		skin.dispose();
		stage.dispose();
		Gdx.app.log("titleUI ", "Disposed");
	}
	//////////
	
	
	public void setTitleIsActive(boolean isActive){
		if (isActive) {
			Gdx.input.setInputProcessor(stage);
		}
		else {
			Gdx.input.setInputProcessor(null);
		}
		
	}
	
	private void handleInput(){
		
		clickToPlay.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {

					ScreenManager.setCurrentScreen("gameplay");
			}
		});
		
		quit.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				Gdx.app.exit();
			}
		});
	}
}
