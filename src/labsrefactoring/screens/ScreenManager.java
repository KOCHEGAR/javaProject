package labsrefactoring.screens;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ScreenManager {


	private static HashMap<String, AbstractScreen> screens;
	private static AbstractScreen currentScreen;
	
	
	public static  void init() {
		
		screens = new HashMap<String, AbstractScreen>();
		
		screens.put("title", new TitleScreen());
		screens.put("gameplay", new GameplayScreen());
	}
	
	public static void setCurrentScreen(String screenName) {
		
		if (currentScreen != null) { currentScreen.switchOff(); }
		currentScreen = screens.get(screenName);
		currentScreen.switchOn();
	}
	
	/////
	
	public static void handleInput(float dt) {
		if (currentScreen != null) { currentScreen.handleInput(dt); }
	}
	
	public static void update(float dt) {
		if (currentScreen != null) { currentScreen.update(dt); }
	}
	
	public static void draw(SpriteBatch sb){
		if (currentScreen != null) { currentScreen.draw(sb); }
	}
	/////
	public static void resize(int width, int height) {
		
		// тут надо подумать, нужно ли ресайзить все окна сразу
		Iterator<Entry<String, AbstractScreen>> iterator = screens.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, AbstractScreen> pair = (Map.Entry<String, AbstractScreen>)iterator.next();
			
			pair.getValue().resize(width, height);
		}
		
		currentScreen.resize(width, height);
	}
	
	public static void dispose(){
		
		Iterator<Entry<String, AbstractScreen>> iterator = screens.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, AbstractScreen> pair = (Map.Entry<String, AbstractScreen>)iterator.next();
			
			pair.getValue().dispose();
			
		}
	}
}
