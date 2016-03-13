package labsrefactoring.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import labsrefactoring.World.TestMap;
import labsrefactoring.player.Player;
import labsrefactoring.tools.Constants;

public class GameplayScreen extends AbstractScreen{

	private TestMap map;
	private Player player;
	
	private Sprite bg;
	
	public GameplayScreen() {
		super();
		
		player = new Player(10, 100);
		player.setSize(50, 105);
		
		
		///test bg
		bg = new Sprite(new Texture("bg.jpg"));
		bg.setSize(400, 240);
		//
		map = new TestMap();
		map.loadMap();
		viewport = new FitViewport(Constants.V_WIDTH, Constants.V_HEIGHT, camera);
	}
	
	@Override
	protected void handleInput(float dt) {
// testing  camera
		player.handleInput(dt);
		
		if (Gdx.input.justTouched()) {
			
//			ScreenManager.setCurrentScreen("title");
		}
		
		/*if (Gdx.input.isKeyPressed(Keys.D)) {
			//camera.position.x += 150*dt;
			//player.setVelX(100*dt);
			//player.setPosition(player.getPosition().x += player.getVelocity().x, player.getPosition().y);
			//player.setCurrentAnimation(Player.ANIM_WALK);
			//player.flip(false, false);
			
		}
		else {
			player.setCurrentAnimation(Player.ANIM_STAND);
		}*/
		
		/*if (Gdx.input.isKeyPressed(Keys.A)) {
			//camera.position.x -= 150*dt;
			player.setPosition(player.getPosition().x -= 1, player.getPosition().y);
			player.setCurrentAnimation(Player.ANIM_WALK);
			player.flip(true, false);
		}*/
		if (Gdx.input.isKeyPressed(Keys.W)) {
				//camera.position.y += 150*dt;
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
				//camera.position.y -= 150*dt;
		}
	}

	@Override
	public void update(float dt) {
		
		
		// фиксация  камеры
		player.update(dt);
		
		//if (player.getPosition().y <= 0) {player.setPosition(player.getPosition().x, 0);}
		if (camera.position.x <= 200) camera.position.x = 200;
		if (camera.position.y <= 120) camera.position.y = 120;
		
//		System.out.println(camera.position.x+" x <-> y "+camera.position.y);
		camera.update();
	}

	@Override
	public void draw(SpriteBatch batch) {

		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		bg.draw(batch);
		map.drawMap(batch);
		player.draw(batch);
	
		batch.end();
	}

	@Override
	public void dispose() {
		Gdx.app.log(TAG, " Disposed");
	}

	@Override
	public void resize(int width, int height) {

		viewport.update(width, height);	
		Gdx.app.log(TAG, "resized");
	}

	@Override
	public void switchOff() { }

	@Override
	public void switchOn() {
		
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		resize(w, h);
	}
}
