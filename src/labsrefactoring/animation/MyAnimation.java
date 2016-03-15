package labsrefactoring.animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import labsrefactoring.player.Entity;



public class MyAnimation implements IAnimation{

	public static final int RUN_REPEAT=1;
	public static final int STOP_ON_LAST=2;
	private int currentMode; 
	
	private ArrayList<Sprite> frames;
	private float maxFrameTime; // длительность отображения одного кадра
	private float currentFrameTime; // время отображения текущего кадра
	private int frameCountX; // количество кадров анимации
	private int frameCountY;
	private int frame; // отдельный кадр
	private boolean directionRight;
	private boolean flipY;
	
	public MyAnimation() { }
	
	public MyAnimation(Texture texture, int frameCountX, int frameCountY, float cycleFrame, int x, int y, int w, int h) {

		frames = new ArrayList<Sprite>();
		
		if (frameCountY <= 0) { frameCountY = 1; this.frameCountY = 1; }
		if (frameCountX <= 0) { frameCountX = 1; this.frameCountY = 1; }
		
		this.frameCountX = frameCountX;
		this.frameCountY = frameCountY;
		int frameWidth = w; // узнаем ширину одного кадра
		int frameHeight = h;
		
		for (int i = 0; i < frameCountY; ++i) {
			
			for(int j = 0; j < frameCountX; ++j){// добавляем в frames каждый раз новый textureRegion
				// где i * frameWidth это начало вырезания кадра из текстуры
				frames.add(new Sprite(new TextureRegion(texture, x+(frameWidth*j), y+(frameHeight*i), frameWidth, frameHeight)));
			}
		}
			
		maxFrameTime = cycleFrame  / (frameCountX*frameCountY); // время проигрывания одного кадра узнается путем
		currentFrameTime = 0;
		frame = 0;
	}
	
	public MyAnimation(ArrayList<Sprite> frames, float cycleFrame){
		
		this.frames = frames;
		
		frameCountX = this.frames.size();
		frameCountY = 1;
		
		maxFrameTime = cycleFrame / (frameCountX*frameCountY);
		currentFrameTime = 0;
		frame = 0;
	}
	
	
	@Override
	public void update(float dt) {
		
		currentFrameTime += dt; // добавляем значеия dt к currentFrameTime
		if (currentFrameTime > maxFrameTime) { //если время текущего кадра  больше времени отображения одного кадра, то инкрементируем фрейм и обнуляем текущее время кадра
			
			frame++;
			currentFrameTime = 0;
		}
		
		runPlayMode(currentMode);
	}
	
	@Override
	public void setSize(float width, float height) {
		
		for (Sprite sprite : frames) {
			sprite.setSize(width, height);
		}
	}
	
	/*public int getFrame(){
		
		return frame;
	}*/
	
	private void runPlayMode(int mode) {
		
		switch (mode) {
		
			case RUN_REPEAT: runRepeatMode(); break;
			
			case STOP_ON_LAST: stopOnLastFrameMode(); break;

			default: runRepeatMode(); break;
		}
	}
	
	private void runRepeatMode() {
		
		if (frame >= frames.size()) { // если фрейм больше или равен количеству всех фреймов, то обнуляем фрейм
			frame = 0;
		}
	}
	
	private void stopOnLastFrameMode() {
		
		if (frame >= frames.size()-1) {
			
			frame = frames.size()-1;
		}
	}
	
	@Override
	public void setPlayMode(int mode){
		currentMode = mode;
	}
	
	@Override
	public void resetAnimation() {
		frame = 0;
	}
	
	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {
		
		Sprite region = null;
		region = frames.get(frame);
		
		float x = actorPos.x;
		float y = actorPos.y;
		float scaleX = directionRight ? 1 : -1;
		float scaleY = flipY ? -1 : 1;

		region.setScale(scaleX, scaleY);
		region.setCenter(x, y);
		region.draw(batch);
	}

	@Override
	public void flip(boolean flipX, boolean flipY) {

		directionRight = flipX;
		this.flipY =  flipY;
		
		/*for (Sprite sprite : frames) {
			if (flipX && !sprite.isFlipX()) {
				sprite.flip(flipX, flipY);
			}
			else if (!flipX && sprite.isFlipX()) {
				sprite.flip(!flipX, flipY);
			}
		}*/
	}

	
	/*public void dispose() {
		
		if (!frames.isEmpty()) {
			
			frames.clear();
			System.out.println("массив frames очищен");
		}
	}*/
}
