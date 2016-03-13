package labsrefactoring.animation;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;



public class MyAnimation implements IAnimation{

	public static final int RUN_REPEAT=1;
	public static final int STOP_ON_LAST=2;
	private int currentMode; 
	
	private ArrayList<Sprite> frames;
	private float maxFrameTime; // ������������ ����������� ������ �����
	private float currentFrameTime; // ����� ����������� �������� �����
	private int frameCountX; // ���������� ������ ��������
	private int frameCountY;
	private int frame; // ��������� ����
	
	public MyAnimation() { }
	
	public MyAnimation(Texture texture, int frameCountX, int frameCountY, float cycleFrame, int x, int y, int w, int h) {

		frames = new ArrayList<Sprite>();
		
		if (frameCountY <= 0) { frameCountY = 1; this.frameCountY = 1; }
		if (frameCountX <= 0) { frameCountX = 1; this.frameCountY = 1; }
		
		this.frameCountX = frameCountX;
		this.frameCountY = frameCountY;
		int frameWidth = w; // ������ ������ ������ �����
		int frameHeight = h;
		
		for (int i = 0; i < frameCountY; ++i) {
			
			for(int j = 0; j < frameCountX; ++j){// ��������� � frames ������ ��� ����� textureRegion
				// ��� i * frameWidth ��� ������ ��������� ����� �� ��������
				frames.add(new Sprite(new TextureRegion(texture, x+(frameWidth*j), y+(frameHeight*i), frameWidth, frameHeight)));
			}
		}
			
		maxFrameTime = cycleFrame  / (frameCountX*frameCountY); // ����� ������������ ������ ����� �������� �����
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
		
		currentFrameTime += dt; // ��������� ������� dt � currentFrameTime
		if (currentFrameTime > maxFrameTime) { //���� ����� �������� �����  ������ ������� ����������� ������ �����, �� �������������� ����� � �������� ������� ����� �����
			
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
		
		if (frame >= frameCountX*frameCountY) { // ���� ����� ������ ��� ����� ���������� ���� �������, �� �������� �����
			frame = 0;
		}
	}
	
	private void stopOnLastFrameMode() {
		
		if (frame >= frameCountX*frameCountY) {
			
			frame = frameCountX*frameCountY-1;
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

		region.setCenter(x, y);
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
			System.out.println("������ frames ������");
		}
	}*/
}
