package labsrefactoring.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Constants {
	//Singleton
	private static Constants instance;
	private Constants(){}
	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	
	
	///visible game world
	/*public static final float VIEWPORT_WIDTH = 250.0f;
	public static final float VIEWPORT_HEIGHT = 100.0f;*/
	
	/// screen size
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 480;
	public static final String TITLE = "Refactoring my Labs";
	/// visible game world
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 240;
	
	/// Sprite for test
	public static final Sprite testSprite = new Sprite(new TextureRegion(new Texture("ground.jpg"), 1, 67, 32, 32));
	//public static final Sprite testPlayerSprite = new Sprite(new TextureRegion(new Texture("monsterSpriteSheet.png"), 0, 0, 100, 100));
	public static final Texture testAnim = new Texture("standandwalk.png");
	public static final Texture explosion = new Texture("Explosion.png");
	/// static SpriteBatch
	public static final SpriteBatch BATCH = new SpriteBatch();
	
	/// skin
	public static final Skin SKIN = new Skin(Gdx.files.internal("uiskin.json"));
	
}
