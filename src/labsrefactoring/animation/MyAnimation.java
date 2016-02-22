package labsrefactoring.animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;



public class MyAnimation implements IAnimation{

	
	private ArrayList<Sprite> frames;
	private float maxFrameTime; // длительность отображения одного кадра
	private float currentFrameTime; // время отображения текущего кадра
	private int frameCountX; // количество кадров анимации
	private int frameCountY;
	private int frame; // отдельный кадр
	
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
	
	@Override
	public void update(float dt) {
		
		currentFrameTime += dt; // добавляем значеия dt к currentFrameTime
		if (currentFrameTime > maxFrameTime) { //если время текущего кадра  больше времени отображения одного кадра, то инкрементируем фрейм и обнуляем текущее время кадра
			
			frame++;
			currentFrameTime = 0;
		}
		
		if (frame >= frameCountX*frameCountY) { // если фрейм больше или равен количеству всех фреймов, то обнуляем фрейм
			frame = 0;
		}
	}
	
	@Override
	public void setSize(float width, float height) {
		
		for (Sprite sprite : frames) {
			sprite.setSize(width, height);
		}
	}
	
	
	@Override
	public void draw(Vector2 actorPos, SpriteBatch batch) {
		
		Sprite region = null;
		region = frames.get(frame);
		
		float x = actorPos.x;
		float y = actorPos.y;

		region.setPosition(x, y);
		region.draw(batch);
	}

	@Override
	public void flip(boolean flipX, boolean flipY) {

		for (Sprite sprite : frames) {
			if (flipX && !sprite.isFlipX()) {
				sprite.flip(flipX, flipY);
				//System.out.println("flipx1 -> " +flipX);
			}
			else if (!flipX && sprite.isFlipX()) {
				//System.out.println("flipx2 -> " +flipX);
				sprite.flip(!flipX, flipY);
			}
		}
	}
	
	/*public void dispose() {
		
		if (!frames.isEmpty()) {
			
			frames.clear();
			System.out.println("массив frames очищен");
		}
	}*/
}
